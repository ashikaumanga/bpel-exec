/**
 * 
 */
package pdn.bee.model.bpel11.activity.impl;

import javax.xml.namespace.QName;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Recieve;
import pdn.bee.model.bpel11.elements.Correlations;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.Variable;

/**
 * @author umanga
 *
 */
public class RecieveImpl extends ActivityImpl implements Recieve {

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#getCorrelations()
	 */
	private Correlations correlations=null;
	private PartnerLink partnerlink=null;
	private QName portType=null;
	private String operation;
	private Variable variable=null;
	private QName faultName=null;
	private boolean createInstance;
	
	
	public RecieveImpl(String name, String joincond, String suppressjoin) {
		super(name, joincond, suppressjoin);
		 
	}

	public Correlations getCorrelations() {
		
		return this.correlations;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#getOperation()
	 */
	public String getOperation() {
		// 
		return this.operation;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#getPartnerLink()
	 */
	public PartnerLink getPartnerLink() {
		// 
		return this.partnerlink;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#getPortType()
	 */
	public QName getPortType() {
		
		return this.portType;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#getVarible()
	 */
	public Variable getVarible() {
		// 
		return this.variable;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#isCreateInstance()
	 */
	public boolean isCreateInstance() {
		// 
		return this.createInstance;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#setCorrelations(pdn.bee.model.bpel11.elements.Correlations)
	 */
	public void setCorrelations(Correlations correlations) {
		// 
		this.correlations=correlations;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#setIsCreateInstance(boolean)
	 */
	public void setIsCreateInstance(boolean creatinst) {
		// 
		this.createInstance=creatinst;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#setOperation(java.lang.String)
	 */
	public void setOperation(String operation) {
		// 
		this.operation=operation;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#setPartnerLink(pdn.bee.model.bpel11.elements.PartnerLink)
	 */
	public void setPartnerLink(PartnerLink partnerlink) {
		// 
		this.partnerlink=partnerlink;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#setPortType(javax.xml.namespace.QName)
	 */
	public void setPortType(QName porttype) {
		// 
		this.portType=porttype;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Recieve#setVariable(pdn.bee.model.bpel11.elements.Variable)
	 */
	public void setVariable(Variable var) {
		// 
		this.variable=var;

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
