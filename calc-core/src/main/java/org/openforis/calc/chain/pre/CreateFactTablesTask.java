package org.openforis.calc.chain.pre;

import java.util.List;

import org.openforis.calc.engine.Task;
import org.openforis.calc.engine.Workspace;
import org.openforis.calc.metadata.BinaryVariable;
import org.openforis.calc.metadata.CategoricalVariable;
import org.openforis.calc.metadata.Category;
import org.openforis.calc.metadata.Entity;
import org.openforis.calc.metadata.QuantitativeVariable;
import org.openforis.calc.metadata.Variable;
import org.openforis.calc.persistence.postgis.PsqlBuilder;

/**
 * Copy tables into output schema based on {@link Category}s
 * 
 * @author G. Miceli
 * @author A. Sanchez-Paus Diaz
 */
public final class CreateFactTablesTask extends Task {

	private static final String DIMENSION_CODE_ID_SUFFIX = "_code_id";
	// TODO group system table and columns names into single class
	public static final String STRATUM_ID = "_stratum_id";
	private static final String DIMENSION_TABLE_ID_COLUMN = "id";
	private static final String DIMENSION_TABLE_ORIGINAL_ID_COLUMN = "original_id";
	private static final String CALC_CATEGORY_TABLE = "calc.category";
	private static final String CALC_CATEGORY_ID = CALC_CATEGORY_TABLE + ".id";
	private static final String CALC_CATEGORY_VALUE = CALC_CATEGORY_TABLE + ".value";
	private static final String CALC_CATEGORY_VARIABLE_ID = CALC_CATEGORY_TABLE + ".variable_id";
	
	@Override
	protected void execute() throws Throwable {
		Workspace workspace = getWorkspace();
		List<Entity> entities = workspace.getEntities();
		String inputSchema = workspace.getInputSchema();

		for (Entity entity : entities) {
			String inputTable = inputSchema + "." + PsqlBuilder.quote(entity.getDataTable());
			String outputFactTable = PsqlBuilder.quote(entity.getDataTable());
			String idColumnFactTable = PsqlBuilder.quote(entity.getIdColumn());

			createFactTable(inputTable, outputFactTable, idColumnFactTable);

			List<Variable> variables = entity.getVariables();
			for (Variable variable : variables) {
				// Add columns for variables not found in input schema
				if ( !variable.isInput() ) {
					String valueColumn = PsqlBuilder.quote(variable.getValueColumn());
					if ( variable instanceof CategoricalVariable ) {
						String valueIdColumn = PsqlBuilder.quote(((CategoricalVariable) variable).getCategoryIdColumn());
						addCategoryValueColumn(outputFactTable, valueColumn);
						addCategoryIdColumn(outputFactTable, valueIdColumn);
					} else {
						addQuantityColumn(outputFactTable, valueColumn);						
					}
				} else if( variable instanceof CategoricalVariable && !variable.isDegenerateDimension() ) {
					CategoricalVariable catvar = (CategoricalVariable) variable;
					// CHANGE THE VALUES FROM THE ORIGINAL_ID TO THE INTERNAL ID OF THE CATEGORICAL DIMENSION TABLE
					String dimensionTable = catvar.getDimensionTable();
					String categoryIdColumn = catvar.getCategoryIdColumn();
					
					if( variable instanceof BinaryVariable ){
						addReferenceToDimensionTable(outputFactTable, categoryIdColumn);
						updateReferenceToDimensionTable(outputFactTable, dimensionTable, categoryIdColumn, catvar.getId() );
					}else{
						updateDimensionIdColumn(outputFactTable, dimensionTable, categoryIdColumn);
					}
					
					// ADD FK relationship
					addDimensionTableFK(outputFactTable, dimensionTable, categoryIdColumn);
				}
				
				applyDefaultVariableValue(outputFactTable, variable);
			}
		}
	}

	private void applyDefaultVariableValue(String outputFactTable, Variable variable) {
		if(  variable instanceof QuantitativeVariable &&  ( (QuantitativeVariable)variable).getDefaultValue() != null ){
			QuantitativeVariable quantitativeVariable = (QuantitativeVariable)variable;
			String valueColumn = PsqlBuilder.quote(variable.getValueColumn());
			Double defaultValue = quantitativeVariable.getDefaultValue();
			
			psql().update( outputFactTable )
				.set( valueColumn + " = ? ")
				.where( valueColumn ).isNull()
				.execute( defaultValue);
			
		}else if ( variable instanceof CategoricalVariable &&  ( (CategoricalVariable)variable).getDefaultValue() != null  ){
			
			CategoricalVariable categoricalVariable = (CategoricalVariable)variable;
			String valueColumn = PsqlBuilder.quote(variable.getValueColumn());
			String idColumn =  PsqlBuilder.quote( categoricalVariable.getCategoryIdColumn());
			Category defaultValue = categoricalVariable.getDefaultValue();
			
			psql().update( outputFactTable )
				.set( valueColumn + " = ?, " + idColumn + " = " + defaultValue.getId())
				.where( valueColumn ).isNull()
				.or( idColumn ).isNull()
				.execute( defaultValue.getCode()  );
		}
	}

	private void addReferenceToDimensionTable(String outputFactTable,
			String categoryIdColumn) {
		psql().alterTable(outputFactTable).addColumn( categoryIdColumn, PsqlBuilder.INTEGER).execute();
	}

	private void updateReferenceToDimensionTable(String outputFactTable, String dimensionTable, String categoryIdColumn, Integer variableId ) {
		String nameBinaryValueColumn = categoryIdColumn.substring(0, categoryIdColumn.indexOf(DIMENSION_CODE_ID_SUFFIX));
		
		psql()
			.update( outputFactTable)
			.set(categoryIdColumn + " = " + CALC_CATEGORY_ID )
			.from(CALC_CATEGORY_TABLE)
			.where(CALC_CATEGORY_VALUE + " = " + nameBinaryValueColumn + "::integer")
			.and(CALC_CATEGORY_VARIABLE_ID + " = ? ")
			.execute( variableId );
	}


	private void addDimensionTableFK(String outputFactTable,
			String dimensionTable, String categoryColumn) {
		psql()
			.alterTable(outputFactTable)
			.addForeignKey( categoryColumn, dimensionTable, DIMENSION_TABLE_ID_COLUMN)
			.execute();
	}

	private void updateDimensionIdColumn(String outputFactTable,
			String dimensionTable, String categoryColumn) {
		psql()
			.update( outputFactTable )
			.set(categoryColumn  + "= " + dimensionTable+ "."+ DIMENSION_TABLE_ID_COLUMN )
			.from( dimensionTable  )
			.where( outputFactTable+"."+categoryColumn + " = " + dimensionTable + "." + DIMENSION_TABLE_ORIGINAL_ID_COLUMN )
			.execute();
	}
	
	private void createFactTable(String inputTable, String outputTable, String idColumn) {
		PsqlBuilder select = new PsqlBuilder()
		.select("*")
		.from(inputTable);

		psql().createTable(outputTable).as(select).execute();

		if ( idColumn != null ) {
			psql().alterTable(outputTable).addPrimaryKey(idColumn).execute();
		}
		
		// Add _stratum_id column
		psql().alterTable( outputTable).addColumn(STRATUM_ID, PsqlBuilder.INTEGER).execute();
	}

	private void addQuantityColumn(String outputTable, String valueColumn) {
		psql()
		.alterTable(outputTable)
		.addColumn(valueColumn, PsqlBuilder.FLOAT8)
		.execute();
	}

	private void addCategoryValueColumn(String outputTable, String valueColumn) {
		psql()
		.alterTable(outputTable)
		.addColumn(valueColumn, PsqlBuilder.VARCHAR, 255)
		.execute();
	}

	private void addCategoryIdColumn(String outputTable, String valueIdColumn) {
		psql()
		.alterTable(outputTable)
		.addColumn(valueIdColumn, PsqlBuilder.INTEGER)
		.execute();
	}
}