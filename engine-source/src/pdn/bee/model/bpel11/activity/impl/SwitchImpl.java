package pdn.bee.model.bpel11.activity.impl;

import java.util.List;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.elements.Case;

public class SwitchImpl extends ActivityImpl implements
		pdn.bee.model.bpel11.activity.Switch {
	private List cases=null;
	private Activity otherwise=null;
	
	private void init()
	{
		cases=new java.util.ArrayList();
	}
	public SwitchImpl() {
		super();
		init();		
	}
	
	

	public SwitchImpl(String name, String joincond, String suppressjoin) {
		super(name, joincond, suppressjoin);
		// 
		init();
	}
	public void addCase(Case acase) {
		// 
		cases.add(acase);

	}

	public List getCases() {
		// 
		return this.cases;
	}

	public Activity getOtherwise() {
		// 
		return this.otherwise;
	}

	public void setCases(List cases) {
		// 
		this.cases=cases;

	}

	public void setOtherwise(Activity activity) {
		// 
		this.otherwise=activity;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}
	
//	this is called by digester instead of addActivity - common for all activities
	public void setActivity(Activity addnew) {
	
		
	}

}
