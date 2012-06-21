/**
 * 
 */
package pdn.bee.model.bpel11.activity.impl;

import java.util.List;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Assign;
import pdn.bee.model.bpel11.elements.Copy;

/**
 * @author umanga
 *
 */
public class AssignImpl extends ActivityImpl implements Assign {

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Assign#addCopy(pdn.bee.model.bpel11.elements.Copy)
	 */
	private List copies=null;
	
	private void init()
	{
		copies=new java.util.ArrayList();
	}
	
	public AssignImpl() {
		super();
		init();
	}
	
	

	public AssignImpl(String name, String joincond, String suppressjoin) {
		super(name, joincond, suppressjoin);
		init();
	}

	public void addCopy(Copy acopy) {
		copies.add(acopy);		

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Assign#getAllCopy()
	 */
	public List getAllCopy() {
		// 
		return this.copies;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Assign#setAllCopy(java.util.List)
	 */
	public void setAllCopy(List copys) {
		// 
		this.copies=copys;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}

	public void setActivity(Activity addnew) {
		// no use of adding here hah?
		
	}
	

}
