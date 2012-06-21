package pdn.bee.core;

import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import pdn.bee.model.bpel11.activity.Activity;

public class FlowActivity extends Thread {
	
	private ProcessEngine engine;
	private ProcessInstance instance;
	private Activity activity;
	private Log logger=LogFactory.getLog("[Thread]"+this.getClass());
	public FlowActivity(ProcessEngine engine,ProcessInstance instance,Activity activity)
	{
		this.engine=engine;
		this.instance=instance;
		this.activity=activity;
	}
	
	public void run()
	{
		try {
			logger.info("[Thread]Running thread activity");
			activity.accept(engine, instance);
			
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
