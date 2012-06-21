package pdn.bee.model.bpel11.activity.impl;

import java.util.List;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Flow;
import pdn.bee.model.bpel11.elements.Links;

public class FlowImpl extends ActivityImpl implements Flow {

	private List activities=null;
	private Links links=null;
	
	
	private void  init()
	{
		activities=new java.util.ArrayList();
	}
	public FlowImpl() {
		super();		
	}
	
	

	public FlowImpl(String name, String joincond, String suppressjoin) {
		super(name, joincond, suppressjoin);
		// 
		init();
	}
	public void addActivity(Activity activity) {
		//
		activities.add(activity);


	}

	public List getActivities() {
		// 
		return this.activities;
	}

	public Links getLinks() {
		// 
		return this.links;
	}

	public void setActivities(List activities) {
		// 
		this.activities=activities;

	}

	public void setLinks(Links links) {
		// 
		this.links=links;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}
	//this is called by digester instead of addActivity - common for all activities
	public void setActivity(Activity addnew) {
	this.addActivity(addnew);
		
	}
	

}
