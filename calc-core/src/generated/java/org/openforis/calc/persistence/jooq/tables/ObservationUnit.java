/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.6.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings("all")
public class ObservationUnit extends org.jooq.impl.UpdatableTableImpl<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord> {

	private static final long serialVersionUID = 817935776;

	/**
	 * The singleton instance of calc.observation_unit
	 */
	public static final org.openforis.calc.persistence.jooq.tables.ObservationUnit OBSERVATION_UNIT = new org.openforis.calc.persistence.jooq.tables.ObservationUnit();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord> getRecordType() {
		return org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord.class;
	}

	/**
	 * The table column <code>calc.observation_unit.obs_unit_id</code>
	 * <p>
	 * This column is part of the table's PRIMARY KEY
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, java.lang.Integer> OBS_UNIT_ID = createField("obs_unit_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.observation_unit.survey_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT observation_unit__obs_unit_survey_fkey
	 * FOREIGN KEY (survey_id)
	 * REFERENCES calc.survey (survey_id)
	 * </pre></code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, java.lang.Integer> SURVEY_ID = createField("survey_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.observation_unit.obs_unit_name</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, java.lang.String> OBS_UNIT_NAME = createField("obs_unit_name", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * The table column <code>calc.observation_unit.obs_unit_type</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, java.lang.String> OBS_UNIT_TYPE = createField("obs_unit_type", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * The table column <code>calc.observation_unit.obs_unit_parent_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT observation_unit__obs_unit_parent_fkey
	 * FOREIGN KEY (obs_unit_parent_id)
	 * REFERENCES calc.observation_unit (obs_unit_id)
	 * </pre></code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, java.lang.Integer> OBS_UNIT_PARENT_ID = createField("obs_unit_parent_id", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The table column <code>calc.observation_unit.obs_unit_description</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, java.lang.String> OBS_UNIT_DESCRIPTION = createField("obs_unit_description", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * The table column <code>calc.observation_unit.obs_unit_label</code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, java.lang.String> OBS_UNIT_LABEL = createField("obs_unit_label", org.jooq.impl.SQLDataType.VARCHAR, this);

	/**
	 * The table column <code>calc.observation_unit.taxonomic_checklist_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT observation_unit__obs_unit_taxonomic_checklist_fkey
	 * FOREIGN KEY (taxonomic_checklist_id)
	 * REFERENCES calc.taxonomic_checklist (checklist_id)
	 * </pre></code>
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, java.lang.Integer> TAXONOMIC_CHECKLIST_ID = createField("taxonomic_checklist_id", org.jooq.impl.SQLDataType.INTEGER, this);

	public ObservationUnit() {
		super("observation_unit", org.openforis.calc.persistence.jooq.Calc.CALC);
	}

	public ObservationUnit(java.lang.String alias) {
		super(alias, org.openforis.calc.persistence.jooq.Calc.CALC, org.openforis.calc.persistence.jooq.tables.ObservationUnit.OBSERVATION_UNIT);
	}

	@Override
	public org.jooq.Identity<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, java.lang.Integer> getIdentity() {
		return org.openforis.calc.persistence.jooq.Keys.IDENTITY_OBSERVATION_UNIT;
	}

	@Override
	public org.jooq.UniqueKey<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord> getMainKey() {
		return org.openforis.calc.persistence.jooq.Keys.OBSERVATION_UNIT_PKEY;
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.UniqueKey<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord>>asList(org.openforis.calc.persistence.jooq.Keys.OBSERVATION_UNIT_PKEY, org.openforis.calc.persistence.jooq.Keys.OBSERVATION_UNIT_UKEY);
	}

	@Override
	@SuppressWarnings("unchecked")
	public java.util.List<org.jooq.ForeignKey<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.openforis.calc.persistence.jooq.tables.records.ObservationUnitRecord, ?>>asList(org.openforis.calc.persistence.jooq.Keys.OBSERVATION_UNIT__OBS_UNIT_SURVEY_FKEY, org.openforis.calc.persistence.jooq.Keys.OBSERVATION_UNIT__OBS_UNIT_PARENT_FKEY, org.openforis.calc.persistence.jooq.Keys.OBSERVATION_UNIT__OBS_UNIT_TAXONOMIC_CHECKLIST_FKEY);
	}

	@Override
	public org.openforis.calc.persistence.jooq.tables.ObservationUnit as(java.lang.String alias) {
		return new org.openforis.calc.persistence.jooq.tables.ObservationUnit(alias);
	}
}