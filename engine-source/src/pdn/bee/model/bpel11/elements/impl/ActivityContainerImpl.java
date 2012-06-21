package pdn.bee.model.bpel11.elements.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.elements.ActivityContainer;

public class ActivityContainerImpl extends BPELRootImpl implements
		ActivityContainer {

	private Activity act=null;
	public Activity getActivity() {
		// TODO Auto-generated method stub
		return this.act;
	}

	public void setActivity(Activity activity) {
		// 
		this.act=activity;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		//engine.process(this, instance);
	}

}
