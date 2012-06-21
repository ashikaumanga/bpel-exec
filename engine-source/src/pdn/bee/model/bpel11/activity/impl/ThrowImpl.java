/**
 * 
 */
package pdn.bee.model.bpel11.activity.impl;

import javax.xml.namespace.QName;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Throw;
import pdn.bee.model.bpel11.elements.Variable;

/**
 * @author umanga
 *
 */
public class ThrowImpl extends ActivityImpl implements Throw {

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Throw#getFaultName()
	 */
	private QName faultName=null;
	private Variable faultVariable;
	public QName getFaultName() {
		// 
		return this.faultName;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Throw#getFaultVariable()
	 */
	public Variable getFaultVariable() {
		// 
		return this.faultVariable;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Throw#setFaultName(javax.xml.namespace.QName)
	 */
	public void setFaultName(QName fname) {
		// 
		this.faultName=fname;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Throw#setFaultVariable(pdn.bee.model.bpel11.elements.Variable)
	 */
	public void setFaultVariable(Variable fvar) {
		// 
		this.faultVariable=fvar;

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
