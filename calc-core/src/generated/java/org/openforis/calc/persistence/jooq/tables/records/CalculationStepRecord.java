/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CalculationStepRecord extends org.jooq.impl.UpdatableRecordImpl<org.openforis.calc.persistence.jooq.tables.records.CalculationStepRecord> implements org.jooq.Record15<java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.openforis.calc.engine.ParameterMap, java.lang.String, java.lang.String, java.lang.Integer, org.openforis.calc.chain.CalculationStep.Type, java.lang.Long, org.openforis.calc.engine.ParameterMap, java.lang.Boolean> {

	private static final long serialVersionUID = -2051033333;

	/**
	 * Setter for <code>calc.calculation_step.id</code>.
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.id</code>.
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>calc.calculation_step.chain_id</code>.
	 */
	public void setChainId(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.chain_id</code>.
	 */
	public java.lang.Integer getChainId() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>calc.calculation_step.step_no</code>.
	 */
	public void setStepNo(java.lang.Integer value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.step_no</code>.
	 */
	public java.lang.Integer getStepNo() {
		return (java.lang.Integer) getValue(2);
	}

	/**
	 * Setter for <code>calc.calculation_step.module_name</code>.
	 */
	public void setModuleName(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.module_name</code>.
	 */
	public java.lang.String getModuleName() {
		return (java.lang.String) getValue(3);
	}

	/**
	 * Setter for <code>calc.calculation_step.module_version</code>.
	 */
	public void setModuleVersion(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.module_version</code>.
	 */
	public java.lang.String getModuleVersion() {
		return (java.lang.String) getValue(4);
	}

	/**
	 * Setter for <code>calc.calculation_step.operation_name</code>.
	 */
	public void setOperationName(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.operation_name</code>.
	 */
	public java.lang.String getOperationName() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>calc.calculation_step.script</code>.
	 */
	public void setScript(java.lang.String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.script</code>.
	 */
	public java.lang.String getScript() {
		return (java.lang.String) getValue(6);
	}

	/**
	 * Setter for <code>calc.calculation_step.parameters</code>.
	 */
	public void setParameters(org.openforis.calc.engine.ParameterMap value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.parameters</code>.
	 */
	public org.openforis.calc.engine.ParameterMap getParameters() {
		return (org.openforis.calc.engine.ParameterMap) getValue(7);
	}

	/**
	 * Setter for <code>calc.calculation_step.caption</code>.
	 */
	public void setCaption(java.lang.String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.caption</code>.
	 */
	public java.lang.String getCaption() {
		return (java.lang.String) getValue(8);
	}

	/**
	 * Setter for <code>calc.calculation_step.description</code>.
	 */
	public void setDescription(java.lang.String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.description</code>.
	 */
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(9);
	}

	/**
	 * Setter for <code>calc.calculation_step.output_variable_id</code>.
	 */
	public void setOutputVariableId(java.lang.Integer value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.output_variable_id</code>.
	 */
	public java.lang.Integer getOutputVariableId() {
		return (java.lang.Integer) getValue(10);
	}

	/**
	 * Setter for <code>calc.calculation_step.type</code>.
	 */
	public void setType(org.openforis.calc.chain.CalculationStep.Type value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.type</code>.
	 */
	public org.openforis.calc.chain.CalculationStep.Type getType() {
		return (org.openforis.calc.chain.CalculationStep.Type) getValue(11);
	}

	/**
	 * Setter for <code>calc.calculation_step.equation_list_id</code>.
	 */
	public void setEquationListId(java.lang.Long value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.equation_list_id</code>.
	 */
	public java.lang.Long getEquationListId() {
		return (java.lang.Long) getValue(12);
	}

	/**
	 * Setter for <code>calc.calculation_step.aggregate_parameters</code>.
	 */
	public void setAggregateParameters(org.openforis.calc.engine.ParameterMap value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.aggregate_parameters</code>.
	 */
	public org.openforis.calc.engine.ParameterMap getAggregateParameters() {
		return (org.openforis.calc.engine.ParameterMap) getValue(13);
	}

	/**
	 * Setter for <code>calc.calculation_step.active</code>.
	 */
	public void setActive(java.lang.Boolean value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>calc.calculation_step.active</code>.
	 */
	public java.lang.Boolean getActive() {
		return (java.lang.Boolean) getValue(14);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record15 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row15<java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.openforis.calc.engine.ParameterMap, java.lang.String, java.lang.String, java.lang.Integer, org.openforis.calc.chain.CalculationStep.Type, java.lang.Long, org.openforis.calc.engine.ParameterMap, java.lang.Boolean> fieldsRow() {
		return (org.jooq.Row15) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row15<java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.openforis.calc.engine.ParameterMap, java.lang.String, java.lang.String, java.lang.Integer, org.openforis.calc.chain.CalculationStep.Type, java.lang.Long, org.openforis.calc.engine.ParameterMap, java.lang.Boolean> valuesRow() {
		return (org.jooq.Row15) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.CHAIN_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field3() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.STEP_NO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.MODULE_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.MODULE_VERSION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field6() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.OPERATION_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field7() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.SCRIPT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<org.openforis.calc.engine.ParameterMap> field8() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.PARAMETERS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field9() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.CAPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field10() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field11() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.OUTPUT_VARIABLE_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<org.openforis.calc.chain.CalculationStep.Type> field12() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Long> field13() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.EQUATION_LIST_ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<org.openforis.calc.engine.ParameterMap> field14() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.AGGREGATE_PARAMETERS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field15() {
		return org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP.ACTIVE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getChainId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value3() {
		return getStepNo();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getModuleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getModuleVersion();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value6() {
		return getOperationName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value7() {
		return getScript();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.openforis.calc.engine.ParameterMap value8() {
		return getParameters();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value9() {
		return getCaption();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value10() {
		return getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value11() {
		return getOutputVariableId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.openforis.calc.chain.CalculationStep.Type value12() {
		return getType();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Long value13() {
		return getEquationListId();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.openforis.calc.engine.ParameterMap value14() {
		return getAggregateParameters();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value15() {
		return getActive();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value1(java.lang.Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value2(java.lang.Integer value) {
		setChainId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value3(java.lang.Integer value) {
		setStepNo(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value4(java.lang.String value) {
		setModuleName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value5(java.lang.String value) {
		setModuleVersion(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value6(java.lang.String value) {
		setOperationName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value7(java.lang.String value) {
		setScript(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value8(org.openforis.calc.engine.ParameterMap value) {
		setParameters(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value9(java.lang.String value) {
		setCaption(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value10(java.lang.String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value11(java.lang.Integer value) {
		setOutputVariableId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value12(org.openforis.calc.chain.CalculationStep.Type value) {
		setType(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value13(java.lang.Long value) {
		setEquationListId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value14(org.openforis.calc.engine.ParameterMap value) {
		setAggregateParameters(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord value15(java.lang.Boolean value) {
		setActive(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public CalculationStepRecord values(java.lang.Integer value1, java.lang.Integer value2, java.lang.Integer value3, java.lang.String value4, java.lang.String value5, java.lang.String value6, java.lang.String value7, org.openforis.calc.engine.ParameterMap value8, java.lang.String value9, java.lang.String value10, java.lang.Integer value11, org.openforis.calc.chain.CalculationStep.Type value12, java.lang.Long value13, org.openforis.calc.engine.ParameterMap value14, java.lang.Boolean value15) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached CalculationStepRecord
	 */
	public CalculationStepRecord() {
		super(org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP);
	}

	/**
	 * Create a detached, initialised CalculationStepRecord
	 */
	public CalculationStepRecord(java.lang.Integer id, java.lang.Integer chainId, java.lang.Integer stepNo, java.lang.String moduleName, java.lang.String moduleVersion, java.lang.String operationName, java.lang.String script, org.openforis.calc.engine.ParameterMap parameters, java.lang.String caption, java.lang.String description, java.lang.Integer outputVariableId, org.openforis.calc.chain.CalculationStep.Type type, java.lang.Long equationListId, org.openforis.calc.engine.ParameterMap aggregateParameters, java.lang.Boolean active) {
		super(org.openforis.calc.persistence.jooq.tables.CalculationStepTable.CALCULATION_STEP);

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
