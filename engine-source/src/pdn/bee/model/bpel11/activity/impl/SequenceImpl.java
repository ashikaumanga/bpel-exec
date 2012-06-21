package pdn.bee.model.bpel11.activity.impl;

import java.util.List;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Sequence;

public class SequenceImpl extends ActivityImpl implements Sequence {

	private List activities=null;
	
	private void init()
	{
		activities=new java.util.ArrayList();
	}
	public SequenceImpl() {
		super();
		javax.swing.JOptionPane.showMessageDialog(null,"sequeuence set");
	}
    
	public SequenceImpl(String name, String joincond, String suppressjoin) {
		super(name, joincond, suppressjoin);
		init();
	}
	public void addActivity(Activity act) {
		// 
		activities.add(act);

	}

	public List getActivities() {
		// 
		return this.activities;
	}

	public void setActivities(List activities) {
		// 
		this.activities=activities;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}
	
//	this is called by digester instead of addActivity - common for all activities
	public void setActivity(Activity addnew) {
	this.addActivity(addnew);
		
	}

}
