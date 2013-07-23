/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "2.6.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings("all")
public class AoiRecord extends org.jooq.impl.UpdatableRecordImpl<org.openforis.calc.persistence.jooq.tables.records.AoiRecord> {

	private static final long serialVersionUID = 2108050119;

	/**
	 * The table column <code>calc.aoi.id</code>
	 * <p>
	 * This column is part of the table's PRIMARY KEY
	 */
	public void setId(java.lang.Integer value) {
		setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.ID, value);
	}

	/**
	 * The table column <code>calc.aoi.id</code>
	 * <p>
	 * This column is part of the table's PRIMARY KEY
	 */
	public java.lang.Integer getId() {
		return getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.ID);
	}

	/**
	 * The table column <code>calc.aoi.id</code>
	 * <p>
	 * This column is part of the table's PRIMARY KEY
	 */
	public java.util.List<org.openforis.calc.persistence.jooq.tables.records.AoiRecord> fetchAoiTableList() {
		return create()
			.selectFrom(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI)
			.where(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.PARENT_AOI_ID.equal(getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.ID)))
			.fetch();
	}

	/**
	 * The table column <code>calc.aoi.id</code>
	 * <p>
	 * This column is part of the table's PRIMARY KEY
	 */
	public java.util.List<org.openforis.calc.persistence.jooq.tables.records.SamplingUnitAoiRecord> fetchSamplingUnitAoiTableList() {
		return create()
			.selectFrom(org.openforis.calc.persistence.jooq.tables.SamplingUnitAoiTable.SAMPLING_UNIT_AOI)
			.where(org.openforis.calc.persistence.jooq.tables.SamplingUnitAoiTable.SAMPLING_UNIT_AOI.AOI_ID.equal(getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.ID)))
			.fetch();
	}

	/**
	 * The table column <code>calc.aoi.aoi_level_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT aoi__aoi_level_fkey
	 * FOREIGN KEY (aoi_level_id)
	 * REFERENCES calc.aoi_level (id)
	 * </pre></code>
	 */
	public void setAoiLevelId(java.lang.Integer value) {
		setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.AOI_LEVEL_ID, value);
	}

	/**
	 * The table column <code>calc.aoi.aoi_level_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT aoi__aoi_level_fkey
	 * FOREIGN KEY (aoi_level_id)
	 * REFERENCES calc.aoi_level (id)
	 * </pre></code>
	 */
	public java.lang.Integer getAoiLevelId() {
		return getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.AOI_LEVEL_ID);
	}

	/**
	 * Link this record to a given {@link org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord 
	 * AoiLevelRecord}
	 */
	public void setAoiLevelId(org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord value) {
		if (value == null) {
			setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.AOI_LEVEL_ID, null);
		}
		else {
			setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.AOI_LEVEL_ID, value.getValue(org.openforis.calc.persistence.jooq.tables.AoiLevelTable.AOI_LEVEL.ID));
		}
	}

	/**
	 * The table column <code>calc.aoi.aoi_level_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT aoi__aoi_level_fkey
	 * FOREIGN KEY (aoi_level_id)
	 * REFERENCES calc.aoi_level (id)
	 * </pre></code>
	 */
	public org.openforis.calc.persistence.jooq.tables.records.AoiLevelRecord fetchAoiLevelTable() {
		return create()
			.selectFrom(org.openforis.calc.persistence.jooq.tables.AoiLevelTable.AOI_LEVEL)
			.where(org.openforis.calc.persistence.jooq.tables.AoiLevelTable.AOI_LEVEL.ID.equal(getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.AOI_LEVEL_ID)))
			.fetchOne();
	}

	/**
	 * The table column <code>calc.aoi.parent_aoi_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT aoi__parent_aoi_fkey
	 * FOREIGN KEY (parent_aoi_id)
	 * REFERENCES calc.aoi (id)
	 * </pre></code>
	 */
	public void setParentAoiId(java.lang.Integer value) {
		setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.PARENT_AOI_ID, value);
	}

	/**
	 * The table column <code>calc.aoi.parent_aoi_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT aoi__parent_aoi_fkey
	 * FOREIGN KEY (parent_aoi_id)
	 * REFERENCES calc.aoi (id)
	 * </pre></code>
	 */
	public java.lang.Integer getParentAoiId() {
		return getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.PARENT_AOI_ID);
	}

	/**
	 * Link this record to a given {@link org.openforis.calc.persistence.jooq.tables.records.AoiRecord 
	 * AoiRecord}
	 */
	public void setParentAoiId(org.openforis.calc.persistence.jooq.tables.records.AoiRecord value) {
		if (value == null) {
			setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.PARENT_AOI_ID, null);
		}
		else {
			setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.PARENT_AOI_ID, value.getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.ID));
		}
	}

	/**
	 * The table column <code>calc.aoi.parent_aoi_id</code>
	 * <p>
	 * This column is part of a FOREIGN KEY: <code><pre>
	 * CONSTRAINT aoi__parent_aoi_fkey
	 * FOREIGN KEY (parent_aoi_id)
	 * REFERENCES calc.aoi (id)
	 * </pre></code>
	 */
	public org.openforis.calc.persistence.jooq.tables.records.AoiRecord fetchAoiTable() {
		return create()
			.selectFrom(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI)
			.where(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.ID.equal(getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.PARENT_AOI_ID)))
			.fetchOne();
	}

	/**
	 * The table column <code>calc.aoi.code</code>
	 */
	public void setCode(java.lang.String value) {
		setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.CODE, value);
	}

	/**
	 * The table column <code>calc.aoi.code</code>
	 */
	public java.lang.String getCode() {
		return getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.CODE);
	}

	/**
	 * The table column <code>calc.aoi.name</code>
	 */
	public void setName(java.lang.String value) {
		setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.NAME, value);
	}

	/**
	 * The table column <code>calc.aoi.name</code>
	 */
	public java.lang.String getName() {
		return getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.NAME);
	}

	/**
	 * The table column <code>calc.aoi.shape</code>
	 * <p>
	 * The SQL type of this item (USER-DEFINED, geometry) could not be mapped.<br/>
	 * Deserialising this field might not work!
	 */
	public void setShape(java.lang.Object value) {
		setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.SHAPE, value);
	}

	/**
	 * The table column <code>calc.aoi.shape</code>
	 * <p>
	 * The SQL type of this item (USER-DEFINED, geometry) could not be mapped.<br/>
	 * Deserialising this field might not work!
	 */
	public java.lang.Object getShape() {
		return getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.SHAPE);
	}

	/**
	 * The table column <code>calc.aoi.total_area</code>
	 */
	public void setTotalArea(java.math.BigDecimal value) {
		setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.TOTAL_AREA, value);
	}

	/**
	 * The table column <code>calc.aoi.total_area</code>
	 */
	public java.math.BigDecimal getTotalArea() {
		return getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.TOTAL_AREA);
	}

	/**
	 * The table column <code>calc.aoi.land_area</code>
	 */
	public void setLandArea(java.math.BigDecimal value) {
		setValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.LAND_AREA, value);
	}

	/**
	 * The table column <code>calc.aoi.land_area</code>
	 */
	public java.math.BigDecimal getLandArea() {
		return getValue(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI.LAND_AREA);
	}

	/**
	 * Create a detached AoiRecord
	 */
	public AoiRecord() {
		super(org.openforis.calc.persistence.jooq.tables.AoiTable.AOI);
	}
}
