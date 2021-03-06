package org.openforis.calc.psql;

import org.jooq.Table;

/**
 * 
 * @author G. Miceli
 *
 */
public class DropTableStep extends ExecutablePsqlPart {

	DropTableStep(Psql psql, boolean ifExists, Table<?> table) {
		super(psql);
		append("drop table ");
		if ( ifExists ) {
			append("if exists ");
		}
		append(table);
	}

	public CascadeStep cascade() {
		return new CascadeStep();
	}
	
	public class CascadeStep extends ExecutablePsqlPart {

		CascadeStep() {
			super(DropTableStep.this);
			append(" cascade");
		}
	}
}
