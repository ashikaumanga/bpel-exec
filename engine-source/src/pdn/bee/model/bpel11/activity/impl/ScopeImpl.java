package pdn.bee.model.bpel11.activity.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Scope;
import pdn.bee.model.bpel11.elements.CompensationHandler;
import pdn.bee.model.bpel11.elements.CorrelationSets;
import pdn.bee.model.bpel11.elements.EventHandlers;
import pdn.bee.model.bpel11.elements.FaultHandlers;
import pdn.bee.model.bpel11.elements.Variables;

public class ScopeImpl extends ActivityImpl implements Scope {

	private CompensationHandler compensationHndlr=null;
	private CorrelationSets correlationSets=null;
	private EventHandlers eventHndlrs=null;
	private FaultHandlers faultHndlrs=null;
	private Variables vars=null;
	private boolean serializable;
	
	public CompensationHandler getCompensationHandler() {
		// 
		return this.compensationHndlr;
	}

	public CorrelationSets getCorrelationSets() {
		// 
		return this.correlationSets;
	}

	public EventHandlers getEventHandlers() {
		// 
		return this.eventHndlrs;
	}

	public FaultHandlers getFaultHandlers() {
		// 
		return this.faultHndlrs;
	}

	public boolean getVariableAccessSerializable() {
		// 
		return this.serializable;
	}

	public Variables getVariables() {
		// 
		return this.vars;
	}

	public void setCompensationHandler(CompensationHandler comphndlrs) {
		// 
		this.compensationHndlr=comphndlrs;

	}

	public void setCorrelationSets(CorrelationSets correlationsets) {
		// 
		this.correlationSets=correlationsets;		

	}

	public void setEventHandlers(EventHandlers evnthndlrs) {
		// 
		this.eventHndlrs=evnthndlrs;

	}

	public void setFaultHandlers(FaultHandlers fhandles) {
		// 
		this.faultHndlrs=fhandles;

	}

	public void setVariableAccessSerializable(boolean varsr) {
		// 
		this.serializable=varsr;

	}

	public void setVariables(Variables vars) {
		// 
		this.vars=vars;

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
