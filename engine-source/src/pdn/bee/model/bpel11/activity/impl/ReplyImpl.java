/**
 * 
 */
package pdn.bee.model.bpel11.activity.impl;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Reply;
import pdn.bee.model.bpel11.elements.Correlations;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.Variable;

/**
 * @author umanga
 *
 */
public class ReplyImpl extends ActivityImpl implements Reply {

	/**
	 * 
	 */
	private void init()
	{
		correlations=new ArrayList();
	}
	private List correlations=null;
	private PartnerLink partnerlink=null;
	private QName porttype=null;
	private String operation;
	private Variable variable;
	private QName faultname;
	
	public ReplyImpl() {
		// 
		init();
	}

	/**
	 * @param name
	 * @param joincond
	 * @param suppressjoin
	 */
	public ReplyImpl(String name, String joincond, String suppressjoin) {
		super(name, joincond, suppressjoin);
		// 
		init();
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#addCorrelations(pdn.bee.model.bpel11.elements.Correlations)
	 */
	public void addCorrelations(Correlations corelations) {
		// 
		correlations.add(corelations);

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#getCorrelations()
	 */
	public List getCorrelations() {
		// 
		return this.correlations;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#getFaultName()
	 */
	public QName getFaultName() {
		// 
		return this.faultname;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#getOperation()
	 */
	public String getOperation() {
		// 
		return this.operation;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#getPartnerLink()
	 */
	public PartnerLink getPartnerLink() {
		// 
		return this.partnerlink;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#getPortType()
	 */
	public QName getPortType() {
		// 
		return this.porttype;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#getVariable()
	 */
	public Variable getVariable() {
		// 
		return this.variable;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#setCorrelations(java.util.List)
	 */
	public void setCorrelations(List corelations) {
		// 
		this.correlations=corelations;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#setFaultName(javax.xml.namespace.QName)
	 */
	public void setFaultName(QName faultname) {
		// 
		this.faultname=faultname;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#setOperation(java.lang.String)
	 */
	public void setOperation(String operation) {
		// 
		this.operation=operation;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#setPartnerLink(pdn.bee.model.bpel11.elements.PartnerLink)
	 */
	public void setPartnerLink(PartnerLink pl) {
		// 
		this.partnerlink=pl;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#setPortType(javax.xml.namespace.QName)
	 */
	public void setPortType(QName porttype) {
		// 
		this.porttype=porttype;

	}
	

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Reply#setVariable(pdn.bee.model.bpel11.elements.Variable)
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
