/**
 * 
 */
package pdn.bee.model.bpel11.activity.impl;

import java.util.List;

import javax.xml.namespace.QName;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Invoke;
import pdn.bee.model.bpel11.elements.ActivityOrCompensateContainer;
import pdn.bee.model.bpel11.elements.Catch;
import pdn.bee.model.bpel11.elements.CompensationHandler;
import pdn.bee.model.bpel11.elements.CorrelationsWithPattern;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.Variable;

/**
 * @author umanga
 *
 */
public class InvokeImpl extends ActivityImpl implements Invoke {

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#addCatch(pdn.bee.model.bpel11.elements.Catch)
	 */
	private List catches=null;
	private CorrelationsWithPattern correlations=null;
	private ActivityOrCompensateContainer catchAll;	
	private QName portType;
	private String operation;
	private Variable inputVar=null;
	private Variable outputVar=null;
	private CompensationHandler compensationHandler;
	private PartnerLink partnerLink=null;
	private void init()
	{
		catches = new java.util.ArrayList();
	}
	
	public InvokeImpl() {
	init();		
	}
	

	public InvokeImpl(String name, String joincond, String suppressjoin) {
		super(name, joincond, suppressjoin);
		// 
		init();
	}

	public ActivityOrCompensateContainer getCatchAll() {
		
		return catchAll;
	}

	public void setCatchAll(ActivityOrCompensateContainer catchall) {
		this.catchAll=catchall;
		
	}

	public void addCatch(Catch ncatch) {
		catches.add(ncatch);

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#getCatches()
	 */
	public List getCatches() {
		
		return catches;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#getCompensationHandler()
	 */
	public CompensationHandler getCompensationHandler() {
		
		return compensationHandler;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#getCorrelations()
	 */
	public CorrelationsWithPattern getCorrelations() {
		
		return correlations;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#getInputVariable()
	 */
	public Variable getInputVariable() {
		
		return inputVar;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#getOperation()
	 */
	public String getOperation() {
		
		return operation;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#getOutputVariable()
	 */
	public Variable getOutputVariable() {
		
		return outputVar;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#getPartnerLink()
	 */
	public PartnerLink getPartnerLink() {
		
		return partnerLink;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#getPortType()
	 */
	public QName getPortType() {
		
		return portType;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#setCatches(java.util.List)
	 */
	public void setCatches(List catches) {
		this.catches=catches;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#setCompensationHandler(pdn.bee.model.bpel11.elements.CompensationHandler)
	 */
	public void setCompensationHandler(CompensationHandler comphandle) {
		this.compensationHandler=comphandle;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#setCorrelations(pdn.bee.model.bpel11.elements.CorrelationsWithPattern)
	 */
	public void setCorrelations(CorrelationsWithPattern correlations) {
		this.correlations=correlations;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#setInputVariable(pdn.bee.model.bpel11.elements.Variable)
	 */
	public void setInputVariable(Variable invar) {
		this.inputVar=invar;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#setOperation(java.lang.String)
	 */
	public void setOperation(String operation) {
		this.operation=operation; 

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#setOutputVariable(pdn.bee.model.bpel11.elements.Variable)
	 */
	public void setOutputVariable(Variable outvar) {
		this.outputVar=outvar;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#setPartnerLink(pdn.bee.model.bpel11.elements.PartnerLink)
	 */
	public void setPartnerLink(PartnerLink parnerlink) {
		this.partnerLink=parnerlink;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.activity.Invoke#setPortType(javax.xml.namespace.QName)
	 */
	public void setPortType(QName porttype) {
		this.portType=porttype;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}
	
//	this is called by digester instead of addActivity - common for all activities
	public void setActivity(Activity addnew) {
	 //no use here
		
	}

}
