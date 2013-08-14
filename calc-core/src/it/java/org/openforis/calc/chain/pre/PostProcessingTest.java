package org.openforis.calc.chain.pre;

import javax.sql.DataSource;

import org.junit.Test;
import org.openforis.calc.chain.post.AggregateSamplingUnitsTask;
import org.openforis.calc.engine.Job;
import org.openforis.calc.engine.TaskManager;
import org.openforis.calc.engine.Workspace;
import org.openforis.calc.engine.WorkspaceDao;
import org.openforis.calc.engine.WorkspaceLockedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * 
 * @author G. Miceli
 * 
 */
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class PostProcessingTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private TaskManager taskManager;
	@Autowired
	private WorkspaceDao workspaceDao;
	@Autowired
	private DataSource userDataSource;
	
	@Test
	public void testRun() throws WorkspaceLockedException {
		Workspace ws = workspaceDao.find(1);
		Job job = taskManager.createUserJob(ws);
//		job.addTask(AddMissingAggregateColumnsTask.class);
//		job.addTask(CalculateExpansionFactorsTask.class);
//		job.addTask(AggregateSamplingUnitsTask.class);
//		job.addTask(CalculateExpansionFactorsTask.class);
//		job.addTask(AggregateSamplingUnitsTask.class);
//		job.addTask(GenerateRolapSchemaTask.class);
		taskManager.startJob(job);
		job.waitFor(5000);
	}
}
