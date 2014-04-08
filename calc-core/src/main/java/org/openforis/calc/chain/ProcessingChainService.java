package org.openforis.calc.chain;

import java.util.List;

import org.openforis.calc.engine.Workspace;
import org.openforis.calc.engine.WorkspaceService;
import org.openforis.calc.metadata.QuantitativeVariable;
import org.openforis.calc.persistence.jooq.Sequences;
import org.openforis.calc.persistence.jooq.tables.daos.CalculationStepDao;
import org.openforis.calc.persistence.jooq.tables.daos.ProcessingChainDao;
import org.openforis.calc.psql.Psql;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Manages {@link CalculationStep} instances
 * 
 * 
 * @author S. Ricci
 * @author Mino Togna
 */
@Service
public class ProcessingChainService {
	
	@Autowired
	private WorkspaceService workspaceService;
	
	@Autowired
	private ProcessingChainDao processingChainDao;
	
	@Autowired
	private CalculationStepDao calculationStepDao;
	
	@Autowired
	private Psql psql;
	
	@Transactional
	public void saveProcessingChain(ProcessingChain chain) {
		if ( chain.getId() == null ) {
			Long nextval = psql.nextval( Sequences.PROCESSING_CHAIN_ID_SEQ );
			chain.setId( nextval.intValue() );
			
			processingChainDao.insert(chain);
		} else {
			processingChainDao.update(chain);
		}
	}
	
	@Transactional
	public void createDefaultProcessingChain(Workspace ws) {
		ProcessingChain chain = new ProcessingChain();
		chain.setCaption(Workspace.DEFAULT_CHAIN_CAPTION);
		ws.addProcessingChain(chain);
		
		saveProcessingChain( chain );
	}
	
	@Transactional
	public void saveCalculationStep(ProcessingChain chain, CalculationStep step) {
		if ( step.getId() == null ) {
			chain.addCalculationStep(step);
			
			Long nextval = psql.nextval( Sequences.CALCULATION_STEP_ID_SEQ );
			step.setId( nextval.intValue() );
			
			calculationStepDao.insert(step);
		} else {
			calculationStepDao.update(step);
		}
	}
	
	/**
	 * Delete the step with given stepId 
	 * Returns the output variable id if it has been removed because it's used only by the deleted calculation step
	 *   
	 * @param stepId
	 */
	@Transactional
	public Integer deleteCalculationStep(CalculationStep step) {
		Integer deletedVariable = null;
		QuantitativeVariable outputVariable = (QuantitativeVariable) step.getOutputVariable();
		calculationStepDao.delete(step);
		ProcessingChain processingChain = step.getProcessingChain();
		List<CalculationStep> steps = processingChain.getCalculationSteps();
		for (CalculationStep calculationStep : steps) {
			Integer stepNo = calculationStep.getStepNo();
			if ( stepNo > step.getStepNo() ) {
				calculationStep.setStepNo(stepNo - 1);
				calculationStepDao.update(calculationStep);
			}
		}
		if ( outputVariable.isUserDefined() ) {
			Workspace ws = processingChain.getWorkspace();
			if ( ws.getCalculationStepsByVariable(outputVariable.getId()).isEmpty() ) {
				deletedVariable = outputVariable.getId();
				workspaceService.deleteOutputVariable(outputVariable, true);
			}
		}
		return deletedVariable;
	}
	
	@Transactional
	public void shiftCalculationStep(CalculationStep step, int index) {
		ProcessingChain processingChain = step.getProcessingChain();
		processingChain.shiftStep(step, index);
		for (CalculationStep calculationStep : processingChain.getCalculationSteps()) {
			calculationStepDao.update(calculationStep);
		}
	}

}
