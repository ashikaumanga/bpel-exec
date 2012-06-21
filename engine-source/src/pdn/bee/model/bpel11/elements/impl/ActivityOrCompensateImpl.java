package pdn.bee.model.bpel11.elements.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Compensate;
import pdn.bee.model.bpel11.elements.ActivityOrCompensateContainer;

public class ActivityOrCompensateImpl extends BPELRootImpl implements
		ActivityOrCompensateContainer {

	private Activity act=null;
	private Compensate comp=null;
	public Activity getActivity() {
		// 
		return this.act;
	}

	public Compensate getCompensate() {
		// 
		return this.comp;
	}

	public void setActivity(Activity act) {
		// 
		this.act=act;

	}

	public void setCompensate(Compensate compensate) {
		// 
		this.comp=compensate;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		//engine.process(this, instance);
	}

}
