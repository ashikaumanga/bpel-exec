package pdn.bee.model.bpel11.activity.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.elements.Wait;
import pdn.bee.model.bpel11.expression.DeadlineExpression;
import pdn.bee.model.bpel11.expression.DurationExpression;

public class WaitImpl extends ActivityImpl implements Wait {

	private DurationExpression forexp=null;
	private DeadlineExpression untilexp=null;
	
	public DurationExpression getFor() {
		// 
		return this.forexp;
	}

	public DeadlineExpression getUntil() {
		// 
		return this.untilexp;
	}

	public void setFor(DurationExpression sfor) {
		// 
		this.forexp=sfor;

	}

	public void setUntil(DeadlineExpression suntil) {
		// 
		this.untilexp=suntil;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		//
	}
	
//	this is called by digester instead of addActivity - common for all activities
	public void setActivity(Activity addnew) {
	
		
	}

}
