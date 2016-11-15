/**
 * This class is generated by jOOQ
 */
package org.openforis.calc.persistence.jooq.tables;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;
import org.openforis.calc.engine.ParameterMap;
import org.openforis.calc.persistence.jooq.CalcSchema;
import org.openforis.calc.persistence.jooq.Keys;
import org.openforis.calc.persistence.jooq.ParameterMapConverter;
import org.openforis.calc.persistence.jooq.tables.records.SamplingDesignRecord;


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
public class SamplingDesignTable extends TableImpl<SamplingDesignRecord> {

	private static final long serialVersionUID = 817865746;

	/**
	 * The reference instance of <code>calc.sampling_design</code>
	 */
	public static final SamplingDesignTable SAMPLING_DESIGN = new SamplingDesignTable();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<SamplingDesignRecord> getRecordType() {
		return SamplingDesignRecord.class;
	}

	/**
	 * The column <code>calc.sampling_design.id</code>.
	 */
	public final TableField<SamplingDesignRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>calc.sampling_design.sampling_unit_id</code>.
	 */
	public final TableField<SamplingDesignRecord, Integer> SAMPLING_UNIT_ID = createField("sampling_unit_id", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>calc.sampling_design.workspace_id</code>.
	 */
	public final TableField<SamplingDesignRecord, Integer> WORKSPACE_ID = createField("workspace_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>calc.sampling_design.srs</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> SRS = createField("srs", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>calc.sampling_design.systematic</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> SYSTEMATIC = createField("systematic", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>calc.sampling_design.two_phases</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> TWO_PHASES = createField("two_phases", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>calc.sampling_design.stratified</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> STRATIFIED = createField("stratified", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>calc.sampling_design.cluster</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> CLUSTER = createField("cluster", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>calc.sampling_design.phase1_join_settings</code>.
	 */
	public final TableField<SamplingDesignRecord, ParameterMap> PHASE1_JOIN_SETTINGS = createField("phase1_join_settings", org.jooq.impl.SQLDataType.VARCHAR.length(1020), this, "", new ParameterMapConverter());

	/**
	 * The column <code>calc.sampling_design.stratum_join_settings</code>.
	 */
	public final TableField<SamplingDesignRecord, ParameterMap> STRATUM_JOIN_SETTINGS = createField("stratum_join_settings", org.jooq.impl.SQLDataType.VARCHAR.length(1020), this, "", new ParameterMapConverter());

	/**
	 * The column <code>calc.sampling_design.cluster_column_settings</code>.
	 */
	public final TableField<SamplingDesignRecord, ParameterMap> CLUSTER_COLUMN_SETTINGS = createField("cluster_column_settings", org.jooq.impl.SQLDataType.VARCHAR.length(1020), this, "", new ParameterMapConverter());

	/**
	 * The column <code>calc.sampling_design.aoi_join_settings</code>.
	 */
	public final TableField<SamplingDesignRecord, ParameterMap> AOI_JOIN_SETTINGS = createField("aoi_join_settings", org.jooq.impl.SQLDataType.VARCHAR.length(1020), this, "", new ParameterMapConverter());

	/**
	 * The column <code>calc.sampling_design.sampling_unit_weight_script</code>.
	 */
	public final TableField<SamplingDesignRecord, String> SAMPLING_UNIT_WEIGHT_SCRIPT = createField("sampling_unit_weight_script", org.jooq.impl.SQLDataType.CLOB, this, "");

	/**
	 * The column <code>calc.sampling_design.two_stages</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> TWO_STAGES = createField("two_stages", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>calc.sampling_design.two_stages_settings</code>.
	 */
	public final TableField<SamplingDesignRecord, ParameterMap> TWO_STAGES_SETTINGS = createField("two_stages_settings", org.jooq.impl.SQLDataType.VARCHAR.length(1020), this, "", new ParameterMapConverter());

	/**
	 * The column <code>calc.sampling_design.apply_area_weighted</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> APPLY_AREA_WEIGHTED = createField("apply_area_weighted", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>calc.sampling_design.stratum_aoi</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> STRATUM_AOI = createField("stratum_aoi", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>calc.sampling_design.cluster2</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> CLUSTER2 = createField("cluster2", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * The column <code>calc.sampling_design.cluster_original_id</code>.
	 */
	public final TableField<SamplingDesignRecord, Long> CLUSTER_ORIGINAL_ID = createField("cluster_original_id", org.jooq.impl.SQLDataType.BIGINT, this, "");

	/**
	 * The column <code>calc.sampling_design.apply_cluster_only_error</code>.
	 */
	public final TableField<SamplingDesignRecord, Boolean> APPLY_CLUSTER_ONLY_ERROR = createField("apply_cluster_only_error", org.jooq.impl.SQLDataType.BOOLEAN, this, "");

	/**
	 * Create a <code>calc.sampling_design</code> table reference
	 */
	public SamplingDesignTable() {
		this("sampling_design", null);
	}

	/**
	 * Create an aliased <code>calc.sampling_design</code> table reference
	 */
	public SamplingDesignTable(String alias) {
		this(alias, SAMPLING_DESIGN);
	}

	private SamplingDesignTable(String alias, Table<SamplingDesignRecord> aliased) {
		this(alias, aliased, null);
	}

	private SamplingDesignTable(String alias, Table<SamplingDesignRecord> aliased, Field<?>[] parameters) {
		super(alias, CalcSchema.CALC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<SamplingDesignRecord, Integer> getIdentity() {
		return Keys.IDENTITY_SAMPLING_DESIGN;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<SamplingDesignRecord> getPrimaryKey() {
		return Keys.PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<SamplingDesignRecord>> getKeys() {
		return Arrays.<UniqueKey<SamplingDesignRecord>>asList(Keys.PKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<SamplingDesignRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<SamplingDesignRecord, ?>>asList(Keys.SAMPLING_DESIGN__SAMPLING_DESIGN_SAMPLING_UNIT_FKEY, Keys.SAMPLING_DESIGN__SAMPLING_DESIGN_WORKPSACE_FK);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SamplingDesignTable as(String alias) {
		return new SamplingDesignTable(alias, this);
	}

	/**
	 * Rename this table
	 */
	public SamplingDesignTable rename(String name) {
		return new SamplingDesignTable(name, null);
	}
}
