/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AoiLevelTable extends org.jooq.impl.TableImpl<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord> {

	private static final long serialVersionUID = 349258291;

	/**
	 * The singleton instance of <code>calc.aoi_level</code>
	 */
	public static final org.openforis.calc.persistence.jooq.tables.AoiLevelTable AOI_LEVEL = new org.openforis.calc.persistence.jooq.tables.AoiLevelTable();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord> getRecordType() {
		return org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord.class;
	}

	/**
	 * The column <code>calc.aoi_level.id</code>.
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>calc.aoi_level.aoi_hierarchy_id</code>.
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord, java.lang.Integer> AOI_HIERARCHY_ID = createField("aoi_hierarchy_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>calc.aoi_level.name</code>.
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord, java.lang.String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>calc.aoi_level.caption</code>.
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord, java.lang.String> CAPTION = createField("caption", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>calc.aoi_level.rank</code>.
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord, java.lang.Integer> RANK = createField("rank", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>calc.aoi_level.description</code>.
	 */
	public final org.jooq.TableField<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord, java.lang.String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(1024).defaulted(true), this, "");

	/**
	 * Create a <code>calc.aoi_level</code> table reference
	 */
	public AoiLevelTable() {
		this("aoi_level", null);
	}

	/**
	 * Create an aliased <code>calc.aoi_level</code> table reference
	 */
	public AoiLevelTable(java.lang.String alias) {
		this(alias, org.openforis.calc.persistence.jooq.tables.AoiLevelTable.AOI_LEVEL);
	}

	private AoiLevelTable(java.lang.String alias, org.jooq.Table<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord> aliased) {
		this(alias, aliased, null);
	}

	private AoiLevelTable(java.lang.String alias, org.jooq.Table<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, org.openforis.calc.persistence.jooq.CalcSchema.CALC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord, java.lang.Integer> getIdentity() {
		return org.openforis.calc.persistence.jooq.Keys.IDENTITY_AOI_LEVEL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord> getPrimaryKey() {
		return org.openforis.calc.persistence.jooq.Keys.AOI_HIERARCHY_LEVEL_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord>>asList(org.openforis.calc.persistence.jooq.Keys.AOI_HIERARCHY_LEVEL_PKEY, org.openforis.calc.persistence.jooq.Keys.AOI_LEVEL_HIERARCHY_NAME_KEY, org.openforis.calc.persistence.jooq.Keys.AOI_LEVEL_HIERARCHY_RANK_KEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord, ?>>asList(org.openforis.calc.persistence.jooq.Keys.AOI_LEVEL__AOI_LEVEL_HIERARCHY_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.openforis.calc.persistence.jooq.tables.AoiLevelTable as(java.lang.String alias) {
		return new org.openforis.calc.persistence.jooq.tables.AoiLevelTable(alias, this);
	}

	/**
	 * Rename this table
	 */
	public org.openforis.calc.persistence.jooq.tables.AoiLevelTable rename(java.lang.String name) {
		return new org.openforis.calc.persistence.jooq.tables.AoiLevelTable(name, null);
	}
}