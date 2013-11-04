package org.openforis.calc.psql;

import org.apache.commons.lang.StringUtils;
import org.jooq.Field;
import org.jooq.Table;
import org.jooq.UniqueKey;

/**
 * 
 * @author G. Miceli
 * @author M. Togna
 * 
 */
public class AlterTableStep extends ExecutablePsqlPart {

	AlterTableStep(Psql psql, Table<?> table) {
		super(psql);
		append("alter table ");
		append(table);
	}

	public AddPrimaryKeyStep addPrimaryKey(UniqueKey<?> key) {
		return new AddPrimaryKeyStep(key);
	}

	public AddColumnStep addColumn(Field<?> field) {
		return addColumn(field, true);
	}

	public AddColumnStep addColumn(Field<?> field, boolean nullable) {
		return new AddColumnStep(field, nullable);
	}

	public DropColumnStep dropColumn(Field<?> field) {
		return dropColumn(field, false);
	}

	public DropColumnStep dropColumn(Field<?> field, boolean cascade) {
		return new DropColumnStep(field, cascade);
	}

	public class AddPrimaryKeyStep extends ExecutablePsqlPart {
		AddPrimaryKeyStep(UniqueKey<?> key) {
			super(AlterTableStep.this);
			append("add primary key (");
			append(StringUtils.join(Psql.names(key.getFieldsArray()), ", "));
			append(")");
		}
	}

	public class AddColumnStep extends ExecutablePsqlPart {
		AddColumnStep(Field<?> field, boolean nullable) {
			super(AlterTableStep.this);
			append("add column ");
			append(field.getName());
			append(" ");
			append(field.getDataType().getTypeName());
			if (!nullable) {
				append(" not null");
			}
		}
	}

	public class DropColumnStep extends ExecutablePsqlPart {
		DropColumnStep(Field<?> field, boolean cascade) {
			super(AlterTableStep.this);
			append("drop column ");
			append(field.getName());
			if (cascade) {
				append(" ");
				append("cascade");
			}
		}
	}
}
