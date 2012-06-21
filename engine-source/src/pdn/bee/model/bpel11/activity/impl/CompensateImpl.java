package pdn.bee.model.bpel11.activity.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Compensate;
import pdn.bee.model.bpel11.activity.Scope;

public class CompensateImpl extends ActivityImpl implements Compensate {

	private Scope scope;
	public Scope getScope() {
		// 
		return this.scope;
	}

	public void setScopt(Scope scope) {
		// 
		this.scope=scope;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		//
	}
	public void setActivity(Activity addnew) {
		// TODO Auto-generated method stub
		
	}
	

}
