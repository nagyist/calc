package org.openforis.calc.engine;

import java.io.IOException;
import java.util.List;

import org.jooq.Field;
import org.jooq.Insert;
import org.jooq.Record;
import org.openforis.calc.chain.CalculationStep;
import org.openforis.calc.chain.ProcessingChainService;
import org.openforis.calc.metadata.AoiDao;
import org.openforis.calc.metadata.Entity;
import org.openforis.calc.metadata.QuantitativeVariable;
import org.openforis.calc.metadata.StratumDao;
import org.openforis.calc.metadata.Variable;
import org.openforis.calc.metadata.Variable.Scale;
import org.openforis.calc.metadata.VariableDao;
import org.openforis.calc.persistence.jooq.Sequences;
import org.openforis.calc.persistence.jooq.tables.daos.CalculationStepDao;
import org.openforis.calc.persistence.jooq.tables.daos.EntityDao;
import org.openforis.calc.persistence.jooq.tables.daos.SamplingDesignDao;
import org.openforis.calc.persistence.jooq.tables.daos.WorkspaceDao;
import org.openforis.calc.psql.Psql;
import org.openforis.calc.schema.DataSchema;
import org.openforis.calc.schema.DataSchemaDao;
import org.openforis.calc.schema.DataTable;
import org.openforis.calc.schema.EntityDataView;
import org.openforis.calc.schema.EntityDataViewDao;
import org.openforis.calc.schema.ResultTable;
import org.openforis.calc.schema.Schemas;
import org.openforis.calc.schema.TableDataDao;
import org.openforis.commons.io.csv.CsvReader;
import org.openforis.commons.io.flat.FlatRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Manages {@link Workspace} instances.
 * 
 * @author G. Miceli
 * @author M. Togna
 */
@Service
//@Scope( WebApplicationContext.SCOPE_SESSION )
public class WorkspaceService {

	@Autowired
	private WorkspaceDao workspaceDao;
	@Autowired
	private MetadataManager metadataManager;
	@Autowired
	private EntityDao entityDao;
	@Autowired
	private EntityDataViewDao entityDataViewDao;
	@Autowired
	private VariableDao variableDao;
	@Autowired
	private ProcessingChainService processingChainService;
	@Autowired
	private DataSchemaDao inputSchemaDao;
	@Autowired
	private SamplingDesignDao samplingDesignDao;
	@Autowired
	private AoiDao aoiDao;
	@Autowired
	private StratumDao stratumDao;
	@Autowired
	private TableDataDao tableDataDao;
	@Autowired
	private CalculationStepDao calculationStepDao;
	
	@Autowired
	private Psql psql;

	public WorkspaceService() {
	}

	public Workspace get( int workspaceId ) {
		return metadataManager.fetchWorkspaceById( workspaceId );
	}

	public Workspace fetchByCollectSurveyUri( String uri ) {
		return metadataManager.fetchWorkspaceByCollectSurveyUri( uri );
	}

	public Workspace save(Workspace workspace) {
		return metadataManager.saveWorkspace( workspace );
	}

	public List<Workspace> loadAll() {
		return metadataManager.findAllWorkspaces();
	}

	public List<Workspace> loadAllInfos(){
		return metadataManager.loadAllWorksaceInfos();
	}
	
	/**
	 * It returns the active workspace
	 * 
	 * @return
	 */
	public Workspace getActiveWorkspace() {
		Workspace workspace = metadataManager.fetchActiveWorkspace();
			
//		if ( workspace != null ) {
//			List<AoiHierarchy> aoiHierarchies = workspace.getAoiHierarchies();
//			// set root aoi to each aoiHierarchy linked to the workspace
//			for (AoiHierarchy aoiHierarchy : aoiHierarchies) {
//				aoiDao.assignRootAoi(aoiHierarchy);
//			}
//		}
		return workspace;
	}

	public Workspace createAndActivate(String name, String uri, String schema) {
		metadataManager.deactivateAll();

		Workspace ws = new Workspace();
		ws.setActive(true);
		ws.setCollectSurveyUri(uri);
		ws.setInputSchema(schema);
		ws.setName(name);
		ws.setCaption(name);
		ws = metadataManager.saveWorkspace(ws);

		processingChainService.createDefaultProcessingChain(ws);

		setActiveWorkspace(ws);
		
		return ws;
	}

	@Transactional
	public QuantitativeVariable addOutputVariable( Entity entity, String name ) {
		
		// add variable to entity and update entity view
		QuantitativeVariable variable = createQuantitativeVariable(name);
		entity.addVariable(variable);

		variableDao.save( variable );
		
		// get result table
		
//		addVariableColumn(variable);
		
		// add column to results table and update entity view
//		if( originalResultTable == null) { 
//			try {
//					
//					resetResultTable(resultTable, schema.getDataTable(entity) );
//					
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} else {
//			new Psql(dataSource)
//				.alterTable(resultTable)
//				.addColumn( resultTable.getQuantityField(variable) )
//				.execute();
//		}
//		
		
		updateEntityView( variable );
		
		return variable;
	}

	@Transactional
	public void saveCalculationStep( CalculationStep step ) {
		if ( step.getId() == null ) {
			Long nextval = psql.nextval( Sequences.CALCULATION_STEP_ID_SEQ );
			step.setId( nextval.intValue() );
			
			calculationStepDao.insert(step);
		} else {
			calculationStepDao.update(step);
		}
		
		QuantitativeVariable variable = (QuantitativeVariable) step.getOutputVariable();
		Entity entity = variable.getEntity();
		
		resetResult( entity, variable );
	}
	
	
	private QuantitativeVariable createQuantitativeVariable(String name) {
		QuantitativeVariable variable = new QuantitativeVariable();
		
		variable.setName(name);
		variable.setInputValueColumn(name);
		variable.setOutputValueColumn(name);
		variable.setScale(Scale.RATIO);
		variable.setOverride( true );
		variable.setDegenerateDimension(false);
		variable.setDisaggregate(false);
		
		return variable;
	}

	private void updateEntityView(QuantitativeVariable variable) {
		Entity entity = getEntity(variable);
		entityDataViewDao.createOrUpdateView(entity);
	}

	private Entity getEntity(QuantitativeVariable variable) {
		Entity entity = variable.getEntity();
		if (entity == null) {
			QuantitativeVariable sourceVariable = variable.getSourceVariable();
			if(sourceVariable == null){
				throw new IllegalStateException("Unable to find entity to update for variable " + variable.getName());
			}
			entity = sourceVariable.getEntity();
		}
		return entity;
	}

	public void addUserDefinedVariableColumns(Workspace ws) {
		for (Variable<?> v : ws.getUserDefinedVariables()) {
			if (v instanceof QuantitativeVariable) {
				inputSchemaDao.addUserDefinedVariableColumn((QuantitativeVariable) v);
			}
		}
	}

	public void activate( Workspace ws ) {
		metadataManager.activate( ws );
		setActiveWorkspace( ws );
	}
	
	
	public void resetDataViews(Workspace ws) {
		for (Entity entity : ws.getEntities()) {
			entityDataViewDao.createOrUpdateView(entity);
		}
	}
	
	@Transactional
	public void resetWorkspace( Workspace ws ) {
		resetSamplingUnitWeight( ws );
		resetCalculationResults( ws );
	}
	
	@Transactional
	private void resetSamplingUnitWeight(Workspace ws) {
		Entity samplingUnit = ws.getSamplingUnit();
		if( samplingUnit != null ) {
			
			DataSchema schema = new Schemas(ws).getDataSchema();
			DataTable dataTable = schema.getDataTable( samplingUnit );
			psql
				.alterTable(dataTable)
				.dropColumnIfExists( dataTable.getWeightField() , true )
				.execute();
		
			psql
				.alterTable(dataTable)
				.addColumn( dataTable.getWeightField() )
				.execute();
		}
	}
	/**
	 * Remove all results table and recreates them empty
	 */
	@Transactional
	public void resetCalculationResults(Workspace ws) {
		List<Entity> entities = ws.getEntities();
		for (Entity entity : entities) {
			resetResults( entity );
		}
	}
	
	@Transactional
	private void resetResults( Entity entity ) {
		DataSchema schema = new Schemas( entity.getWorkspace() ).getDataSchema();
		ResultTable resultsTable = schema.getResultTable(entity);
		DataTable dataTable = schema.getDataTable(entity);
		
		entityDataViewDao.drop( entity );
		
		if( resultsTable != null ) {
			//drop data view first
			psql
				.dropTableIfExists( resultsTable )
				.execute();
			
			psql
				.createTable( resultsTable, resultsTable.fields() )
				.execute();
			
			Insert<Record> insert = psql
					.insertInto( resultsTable, resultsTable.getIdField() )
					.select(
							new Psql()
							.select( dataTable.getIdField() )
							.from( dataTable )
					);
			insert.execute();
			
		}
		entityDataViewDao.createOrUpdateView( entity );
	}
	
	private void resetResult( Entity entity , Variable<?> variable ){
		DataSchema schema = new Schemas( entity.getWorkspace() ).getDataSchema();
		ResultTable resultTable = schema.getResultTable( entity );
		
		boolean exists = resultTable != null && tableDataDao.exists( resultTable.getSchema().getName() , resultTable.getName() );
		if( exists ) {
			entityDataViewDao.drop( entity );
			
			Field<?> field = resultTable.field( variable.getOutputValueColumn() );
			psql
				.alterTable( resultTable )
				.dropColumnIfExists( field )
				.execute();
			psql
				.alterTable( resultTable )
				.addColumn( field )
				.execute();
			
			entityDataViewDao.createOrUpdateView( entity );
		} else if( !exists ) {
			resetResults( entity );
		}
	}
	
//	@Transactional
	@Deprecated
	public QuantitativeVariable createVariableAggregate(Workspace workspace, int entityId, int variableId, String agg) {
		return null;
//		Entity entity = workspace.getEntityById(entityId);
//		QuantitativeVariable variable = entity.getQtyVariableById(variableId);
//		
//		int variableReturnId = 0;
//		//the variable id passed is a variable-per-ha linked to another variable
//		if(variable == null) {
//			variable = entity.getQtyVariablePerHaById(variableId);
//			variableReturnId = variable.getSourceVariable().getId();
//		} else {
//			variableReturnId = variable.getId();
//		}
//		
//		if (!variable.hasAggregate(agg)) {
//			if (VariableAggregate.AGGREGATE_TYPE.isValid(agg)) {
//				VariableAggregate varAgg = new VariableAggregate();
//				varAgg.setVariable(variable);
//				varAgg.setAggregateType(agg);
//				varAgg.setAggregateFormula("");
//				variableAggregateDao.saveWorkspace(varAgg);
//			} else {
//				throw new IllegalArgumentException("Invalild aggregate type: " + agg);
//			}
//		}
//		variable = (QuantitativeVariable) variableDao.fetchWorkspaceById(variableReturnId);
//		
////		updateEntityView(variable);
//		
//		return variable;
	}
	
	@Transactional
	@Deprecated
	public QuantitativeVariable deleteVariableAggregate(Workspace workspace, int entityId, int variableId, String agg) {
		return null;
//		Entity entity = workspace.getEntityById(entityId);
//		QuantitativeVariable variable = entity.getQtyVariableById(variableId);
//		
//		int variableReturnId = 0;
//		//the variable id passed is a variable-per-ha linked to another variable
//		if(variable == null) {
//			variable = entity.getQtyVariablePerHaById(variableId);
//			variableReturnId = variable.getSourceVariable().getId();
//		} else {
//			variableReturnId = variable.getId();
//		}
//		
//		VariableAggregate aggregate = variable.getAggregate(agg);
//		if (aggregate != null) {
//			variable.deleteAggregate(agg);
//			variableDao.saveWorkspace(variable);
//			variableAggregateDao.delete(aggregate.getId());
//		}
//		
//		variable = (QuantitativeVariable) variableDao.fetchWorkspaceById(variableReturnId);
//		
////		updateEntityView(variable);
//		
//		return variable;
	}

	@Transactional
	@Deprecated
	public QuantitativeVariable addVariablePerHa(QuantitativeVariable variable) {
		return null;
//		QuantitativeVariable variablePerHa = variable.getVariablePerHa();
//
//		if (variablePerHa == null) {
//			
//			String name = variable.getName() + "_per_ha";
//			variablePerHa = createQuantitativeVariable(name);
//			variablePerHa.setSourceVariable(variable);
//			
//			variable.setVariablePerHa(variablePerHa);
//			
//			variableDao.saveWorkspace(variablePerHa);			
//			variable = (QuantitativeVariable) variableDao.saveWorkspace(variable);
//			
////			addVariableColumn(variablePerHa);
////			updateEntityView(variablePerHa);
//		}
//
//		return variable;
	}

//	@Transactional
	@Deprecated
	public QuantitativeVariable deleteVariablePerHa(QuantitativeVariable variable) {
//		return deleteVariablePerHa(variable, true);
		return null;
	}

//	@Transactional
	@Deprecated
	public QuantitativeVariable deleteVariablePerHa(QuantitativeVariable variable, boolean updateEntityView) {
		return null;
//		QuantitativeVariable variablePerHa = variable.getVariablePerHa();
//
//		if (variablePerHa != null) {
////			dropVariableColumn(variablePerHa);
//			
//			variable.setVariablePerHa(null);
//			variableDao.delete(variablePerHa.getId());
//			variable = (QuantitativeVariable) variableDao.saveWorkspace(variable);
//			
////			if ( updateEntityView ) {
////				updateEntityView(variable);
////			}
//		}
//
//		return variable;
	}
	
	@Transactional
	public void deleteOutputVariable(QuantitativeVariable variable, boolean updateEntityView) {
		QuantitativeVariable variablePerHa = variable.getVariablePerHa();
		if ( variablePerHa != null ) {
			deleteVariablePerHa(variable, false);
		}
//		dropVariableColumn(variable);
		
		Entity entity = getEntity(variable);
		
		DataSchema schema = new Schemas(entity.getWorkspace()).getDataSchema();
		ResultTable originalResultTable = schema.getResultTable(entity);
		EntityDataView view = schema.getDataView(entity);

		// drop entity data view
		entityDataViewDao.drop( view );
		
		// drop column from results table
		psql
			.alterTable( originalResultTable )
			.dropColumn( originalResultTable.getQuantityField(variable) )
			.execute();
		
		// delete variable
		entity.removeVariable( variable );
		variableDao.delete( variable );
		
		// drop result table, if there are no more output variables
		ResultTable newResultTable = schema.getResultTable( entity );
		if ( newResultTable == null ) {
			psql
				.dropTableIfExists( originalResultTable )
				.execute();
		}
		
//		if ( updateEntityView ) {
		updateEntityView(variable);
//		}
	}
	
	/**
	 * Set plot area script for the given entity and returns it
	 * @param entity
	 * @param plotAreaScript
	 * @return
	 */
	@Transactional
	public Entity setEntityPlotAreaScript(Entity entity, String plotAreaScript) {
		entity.setPlotAreaScript( plotAreaScript );
		entityDao.update( entity );
		return entity;
	}

	@Transactional
	public void importStrata(Workspace workspace, String filepath) throws IOException {
		stratumDao.deleteAll(workspace);
		
		CsvReader csvReader = new CsvReader(filepath);
		csvReader.readHeaders();
		
//		FlatRecord record = csvReader.nextRecord();
		for(FlatRecord record = csvReader.nextRecord() ; record != null ; record = csvReader.nextRecord() ) {
			Integer no = record.getValue(0, Integer.class);
			String caption = record.getValue(1, String.class);
			
			stratumDao.insert(workspace, no, caption);
		}
		
	}

	private void setActiveWorkspace(Workspace activeWorkspace) {
//		this.activeWorkspace = activeWorkspace;
	}
}
