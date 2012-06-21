package pdn.bee.model.bpel11.activity.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.elements.While;
import pdn.bee.model.bpel11.expression.BooleanExpression;

public class WhileImpl extends ActivityImpl implements While {

	private Activity act=null;
	private BooleanExpression cond=null;
	public Activity getActivity() {
		// 
		return this.act;
	}

	public BooleanExpression getCondition() {
		// 
		return this.cond;
	}

	public void setActivity(Activity activity) {
		// 
		this.act=activity;

	}

	public void setCondition(BooleanExpression condition) {
		// 
		this.cond=condition;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}

}
