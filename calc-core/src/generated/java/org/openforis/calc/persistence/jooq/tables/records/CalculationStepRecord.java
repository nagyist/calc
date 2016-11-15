/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record15;
import org.jooq.Row15;
import org.jooq.impl.UpdatableRecordImpl;
import org.openforis.calc.chain.CalculationStep.Type;
import org.openforis.calc.engine.ParameterMap;
import org.openforis.calc.persistence.jooq.tables.CalculationStepTable;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CalculationStepRecord extends UpdatableRecordImpl<CalculationStepRecord> implements Record15<Integer, Integer, Integer, String, String, String, String, ParameterMap, String, String, Integer, Type, Long, ParameterMap, Boolean> {

	private static final long serialVersionUID = 962089185;

	/**
	 * Setter for <code>calc.calculation_step.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>calc.calculation_step.chain_id</code>.
	 */
	public void setChainId(Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.chain_id</code>.
	 */
	public Integer getChainId() {
		return (Integer) getValue(1);
	}

	/**
	 * Setter for <code>calc.calculation_step.step_no</code>.
	 */
	public void setStepNo(Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.step_no</code>.
	 */
	public Integer getStepNo() {
		return (Integer) getValue(2);
	}

	/**
	 * Setter for <code>calc.calculation_step.module_name</code>.
	 */
	public void setModuleName(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.module_name</code>.
	 */
	public String getModuleName() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>calc.calculation_step.module_version</code>.
	 */
	public void setModuleVersion(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.module_version</code>.
	 */
	public String getModuleVersion() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>calc.calculation_step.operation_name</code>.
	 */
	public void setOperationName(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.operation_name</code>.
	 */
	public String getOperationName() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>calc.calculation_step.script</code>.
	 */
	public void setScript(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.script</code>.
	 */
	public String getScript() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>calc.calculation_step.parameters</code>.
	 */
	public void setParameters(ParameterMap value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.parameters</code>.
	 */
	public ParameterMap getParameters() {
		return (ParameterMap) getValue(7);
	}

	/**
	 * Setter for <code>calc.calculation_step.caption</code>.
	 */
	public void setCaption(String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.caption</code>.
	 */
	public String getCaption() {
		return (String) getValue(8);
	}

	/**
	 * Setter for <code>calc.calculation_step.description</code>.
	 */
	public void setDescription(String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.description</code>.
	 */
	public String getDescription() {
		return (String) getValue(9);
	}

	/**
	 * Setter for <code>calc.calculation_step.output_variable_id</code>.
	 */
	public void setOutputVariableId(Integer value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.output_variable_id</code>.
	 */
	public Integer getOutputVariableId() {
		return (Integer) getValue(10);
	}

	/**
	 * Setter for <code>calc.calculation_step.type</code>.
	 */
	public void setType(Type value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.type</code>.
	 */
	public Type getType() {
		return (Type) getValue(11);
	}

	/**
	 * Setter for <code>calc.calculation_step.equation_list_id</code>.
	 */
	public void setEquationListId(Long value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.equation_list_id</code>.
	 */
	public Long getEquationListId() {
		return (Long) getValue(12);
	}

	/**
	 * Setter for <code>calc.calculation_step.aggregate_parameters</code>.
	 */
	public void setAggregateParameters(ParameterMap value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.aggregate_parameters</code>.
	 */
	public ParameterMap getAggregateParameters() {
		return (ParameterMap) getValue(13);
	}

	/**
	 * Setter for <code>calc.calculation_step.active</code>.
	 */
	public void setActive(Boolean value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.active</code>.
	 */
	public Boolean getActive() {
		return (Boolean) getValue(14);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Record1<Integer> key() {
		return (Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record15 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row15<Integer, Integer, Integer, String, String, String, String, ParameterMap, String, String, Integer, Type, Long, ParameterMap, Boolean> fieldsRow() {
		return (Row15) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row15<Integer, Integer, Integer, String, String, String, String, ParameterMap, String, String, Integer, Type, Long, ParameterMap, Boolean> valuesRow() {
		return (Row15) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return CalculationStepTable.CALCULATION_STEP.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field2() {
		return CalculationStepTable.CALCULATION_STEP.CHAIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field3() {
		return CalculationStepTable.CALCULATION_STEP.STEP_NO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return CalculationStepTable.CALCULATION_STEP.MODULE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return CalculationStepTable.CALCULATION_STEP.MODULE_VERSION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return CalculationStepTable.CALCULATION_STEP.OPERATION_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return CalculationStepTable.CALCULATION_STEP.SCRIPT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<ParameterMap> field8() {
		return CalculationStepTable.CALCULATION_STEP.PARAMETERS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field9() {
		return CalculationStepTable.CALCULATION_STEP.CAPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field10() {
		return CalculationStepTable.CALCULATION_STEP.DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field11() {
		return CalculationStepTable.CALCULATION_STEP.OUTPUT_VARIABLE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Type> field12() {
		return CalculationStepTable.CALCULATION_STEP.TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Long> field13() {
		return CalculationStepTable.CALCULATION_STEP.EQUATION_LIST_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<ParameterMap> field14() {
		return CalculationStepTable.CALCULATION_STEP.AGGREGATE_PARAMETERS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Boolean> field15() {
		return CalculationStepTable.CALCULATION_STEP.ACTIVE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value2() {
		return getChainId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value3() {
		return getStepNo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getModuleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getModuleVersion();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getOperationName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getScript();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ParameterMap value8() {
		return getParameters();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value9() {
		return getCaption();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value10() {
		return getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Integer value11() {
		return getOutputVariableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Type value12() {
		return getType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long value13() {
		return getEquationListId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ParameterMap value14() {
		return getAggregateParameters();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean value15() {
		return getActive();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value2(Integer value) {
		setChainId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value3(Integer value) {
		setStepNo(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value4(String value) {
		setModuleName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value5(String value) {
		setModuleVersion(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value6(String value) {
		setOperationName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value7(String value) {
		setScript(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value8(ParameterMap value) {
		setParameters(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value9(String value) {
		setCaption(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value10(String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value11(Integer value) {
		setOutputVariableId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value12(Type value) {
		setType(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value13(Long value) {
		setEquationListId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value14(ParameterMap value) {
		setAggregateParameters(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value15(Boolean value) {
		setActive(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord values(Integer value1, Integer value2, Integer value3, String value4, String value5, String value6, String value7, ParameterMap value8, String value9, String value10, Integer value11, Type value12, Long value13, ParameterMap value14, Boolean value15) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		value10(value10);
		value11(value11);
		value12(value12);
		value13(value13);
		value14(value14);
		value15(value15);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached CalculationStepRecord
	 */
	public CalculationStepRecord() {
		super(CalculationStepTable.CALCULATION_STEP);
	}

	/**
	 * Create a detached, initialised CalculationStepRecord
	 */
	public CalculationStepRecord(Integer id, Integer chainId, Integer stepNo, String moduleName, String moduleVersion, String operationName, String script, ParameterMap parameters, String caption, String description, Integer outputVariableId, Type type, Long equationListId, ParameterMap aggregateParameters, Boolean active) {
		super(CalculationStepTable.CALCULATION_STEP);

		setValue(0, id);
		setValue(1, chainId);
		setValue(2, stepNo);
		setValue(3, moduleName);
		setValue(4, moduleVersion);
		setValue(5, operationName);
		setValue(6, script);
		setValue(7, parameters);
		setValue(8, caption);
		setValue(9, description);
		setValue(10, outputVariableId);
		setValue(11, type);
		setValue(12, equationListId);
		setValue(13, aggregateParameters);
		setValue(14, active);
	}
}
