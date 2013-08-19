package org.openforis.calc.chain.pre;

import org.openforis.calc.engine.Task;
import org.openforis.calc.engine.Workspace;
import org.openforis.calc.persistence.postgis.PsqlBuilder;

/**
 * Recreates the output schema and sets it as the default schema for operations.  
 * Fails if output schema already exists.
 * 
 * @author G. Miceli
 * @author A. Sanchez-Paus Diaz 
 */
public final class CreateOutputSchemaTask extends Task {

	@Override
	protected void execute() throws Throwable {
		Workspace workspace = getWorkspace();
		String outputSchemaName = PsqlBuilder.quote(workspace.getOutputSchema());
		psql().createSchema(outputSchemaName).execute();
		setDefaultSchemaSearchPath();
		
	}
}