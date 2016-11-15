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
import org.openforis.calc.persistence.jooq.CalcSchema;
import org.openforis.calc.persistence.jooq.Keys;
import org.openforis.calc.persistence.jooq.tables.records.StratumRecord;


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
public class StratumTable extends TableImpl<StratumRecord> {

	private static final long serialVersionUID = 168637667;

	/**
	 * The reference instance of <code>calc.stratum</code>
	 */
	public static final StratumTable STRATUM = new StratumTable();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<StratumRecord> getRecordType() {
		return StratumRecord.class;
	}

	/**
	 * The column <code>calc.stratum.id</code>.
	 */
	public final TableField<StratumRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaulted(true), this, "");

	/**
	 * The column <code>calc.stratum.workspace_id</code>.
	 */
	public final TableField<StratumRecord, Integer> WORKSPACE_ID = createField("workspace_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>calc.stratum.stratum_no</code>.
	 */
	public final TableField<StratumRecord, Integer> STRATUM_NO = createField("stratum_no", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>calc.stratum.caption</code>.
	 */
	public final TableField<StratumRecord, String> CAPTION = createField("caption", org.jooq.impl.SQLDataType.VARCHAR.length(255), this, "");

	/**
	 * The column <code>calc.stratum.description</code>.
	 */
	public final TableField<StratumRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.VARCHAR.length(1024), this, "");

	/**
	 * Create a <code>calc.stratum</code> table reference
	 */
	public StratumTable() {
		this("stratum", null);
	}

	/**
	 * Create an aliased <code>calc.stratum</code> table reference
	 */
	public StratumTable(String alias) {
		this(alias, STRATUM);
	}

	private StratumTable(String alias, Table<StratumRecord> aliased) {
		this(alias, aliased, null);
	}

	private StratumTable(String alias, Table<StratumRecord> aliased, Field<?>[] parameters) {
		super(alias, CalcSchema.CALC, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Identity<StratumRecord, Integer> getIdentity() {
		return Keys.IDENTITY_STRATUM;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<StratumRecord> getPrimaryKey() {
		return Keys.STRATUM_PKEY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<StratumRecord>> getKeys() {
		return Arrays.<UniqueKey<StratumRecord>>asList(Keys.STRATUM_PKEY, Keys.STRATUM_STRATUM_NO_WORKSPACE_ID_KEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<StratumRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<StratumRecord, ?>>asList(Keys.STRATUM__STRATUM_WORKSPACE_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public StratumTable as(String alias) {
		return new StratumTable(alias, this);
	}

	/**
	 * Rename this table
	 */
	public StratumTable rename(String name) {
		return new StratumTable(name, null);
	}
}
