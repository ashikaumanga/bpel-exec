package pdn.bee.model.bpel11.activity.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Pick;
import pdn.bee.model.bpel11.elements.OnAlarm;
import pdn.bee.model.bpel11.elements.OnMessage;

public class PickImpl extends ActivityImpl implements Pick {

	
	public OnAlarm getOnAlarm() {
		// TODO Auto-generated method stub
		return null;
	}

	public OnMessage getOnMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setOnAlarm(OnAlarm onalarm) {
		// TODO Auto-generated method stub

	}

	public void setOnMessage(OnMessage onmsg) {
		// TODO Auto-generated method stub

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
