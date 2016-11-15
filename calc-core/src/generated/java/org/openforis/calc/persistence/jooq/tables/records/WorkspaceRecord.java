/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.records;


import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record9;
import org.jooq.Row9;
import org.jooq.impl.UpdatableRecordImpl;
import org.openforis.calc.persistence.jooq.tables.WorkspaceTable;


/**
 * One cycle of an inventory.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.2"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class WorkspaceRecord extends UpdatableRecordImpl<WorkspaceRecord> implements Record9<Integer, String, String, String, String, String, String, Boolean, String> {

	private static final long serialVersionUID = -614705819;

	/**
	 * Setter for <code>calc.workspace.id</code>.
	 */
	public void setId(Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>calc.workspace.id</code>.
	 */
	public Integer getId() {
		return (Integer) getValue(0);
	}

	/**
	 * Setter for <code>calc.workspace.name</code>.
	 */
	public void setName(String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>calc.workspace.name</code>.
	 */
	public String getName() {
		return (String) getValue(1);
	}

	/**
	 * Setter for <code>calc.workspace.collect_survey_uri</code>.
	 */
	public void setCollectSurveyUri(String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>calc.workspace.collect_survey_uri</code>.
	 */
	public String getCollectSurveyUri() {
		return (String) getValue(2);
	}

	/**
	 * Setter for <code>calc.workspace.input_schema</code>.
	 */
	public void setInputSchema(String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>calc.workspace.input_schema</code>.
	 */
	public String getInputSchema() {
		return (String) getValue(3);
	}

	/**
	 * Setter for <code>calc.workspace.output_schema</code>.
	 */
	public void setOutputSchema(String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>calc.workspace.output_schema</code>.
	 */
	public String getOutputSchema() {
		return (String) getValue(4);
	}

	/**
	 * Setter for <code>calc.workspace.caption</code>.
	 */
	public void setCaption(String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>calc.workspace.caption</code>.
	 */
	public String getCaption() {
		return (String) getValue(5);
	}

	/**
	 * Setter for <code>calc.workspace.description</code>.
	 */
	public void setDescription(String value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>calc.workspace.description</code>.
	 */
	public String getDescription() {
		return (String) getValue(6);
	}

	/**
	 * Setter for <code>calc.workspace.active</code>.
	 */
	public void setActive(Boolean value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>calc.workspace.active</code>.
	 */
	public Boolean getActive() {
		return (Boolean) getValue(7);
	}

	/**
	 * Setter for <code>calc.workspace.phase1_plot_table</code>.
	 */
	public void setPhase1PlotTable(String value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>calc.workspace.phase1_plot_table</code>.
	 */
	public String getPhase1PlotTable() {
		return (String) getValue(8);
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
	// Record9 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, String, String, String, String, String, Boolean, String> fieldsRow() {
		return (Row9) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Row9<Integer, String, String, String, String, String, String, Boolean, String> valuesRow() {
		return (Row9) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Integer> field1() {
		return WorkspaceTable.WORKSPACE.ID;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field2() {
		return WorkspaceTable.WORKSPACE.NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field3() {
		return WorkspaceTable.WORKSPACE.COLLECT_SURVEY_URI;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field4() {
		return WorkspaceTable.WORKSPACE.INPUT_SCHEMA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field5() {
		return WorkspaceTable.WORKSPACE.OUTPUT_SCHEMA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field6() {
		return WorkspaceTable.WORKSPACE.CAPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field7() {
		return WorkspaceTable.WORKSPACE.DESCRIPTION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<Boolean> field8() {
		return WorkspaceTable.WORKSPACE.ACTIVE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Field<String> field9() {
		return WorkspaceTable.WORKSPACE.PHASE1_PLOT_TABLE;
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
	public String value2() {
		return getName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value3() {
		return getCollectSurveyUri();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value4() {
		return getInputSchema();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value5() {
		return getOutputSchema();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value6() {
		return getCaption();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value7() {
		return getDescription();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Boolean value8() {
		return getActive();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String value9() {
		return getPhase1PlotTable();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord value1(Integer value) {
		setId(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord value2(String value) {
		setName(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord value3(String value) {
		setCollectSurveyUri(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord value4(String value) {
		setInputSchema(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord value5(String value) {
		setOutputSchema(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord value6(String value) {
		setCaption(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord value7(String value) {
		setDescription(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord value8(Boolean value) {
		setActive(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord value9(String value) {
		setPhase1PlotTable(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public WorkspaceRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, String value7, Boolean value8, String value9) {
		value1(value1);
		value2(value2);
		value3(value3);
		value4(value4);
		value5(value5);
		value6(value6);
		value7(value7);
		value8(value8);
		value9(value9);
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached WorkspaceRecord
	 */
	public WorkspaceRecord() {
		super(WorkspaceTable.WORKSPACE);
	}

	/**
	 * Create a detached, initialised WorkspaceRecord
	 */
	public WorkspaceRecord(Integer id, String name, String collectSurveyUri, String inputSchema, String outputSchema, String caption, String description, Boolean active, String phase1PlotTable) {
		super(WorkspaceTable.WORKSPACE);

		setValue(0, id);
		setValue(1, name);
		setValue(2, collectSurveyUri);
		setValue(3, inputSchema);
		setValue(4, outputSchema);
		setValue(5, caption);
		setValue(6, description);
		setValue(7, active);
		setValue(8, phase1PlotTable);
	}
}
