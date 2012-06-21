package pdn.bee.model.bpel11.process.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.elements.CompensationHandler;
import pdn.bee.model.bpel11.elements.CorrelationSets;
import pdn.bee.model.bpel11.elements.EventHandlers;
import pdn.bee.model.bpel11.elements.FaultHandlers;
import pdn.bee.model.bpel11.elements.PartnerLinks;
import pdn.bee.model.bpel11.elements.Partners;
import pdn.bee.model.bpel11.elements.Variables;
import pdn.bee.model.bpel11.process.Process;

public class ProcessImpl implements Process {

	private CompensationHandler compsentaionH=null;
	private CorrelationSets correlationSets=null;
	private EventHandlers eventH=null;
	private String expLang;
	private FaultHandlers faultH=null;
	private String name;
	private PartnerLinks partnerLinks=null;
	private Partners partners=null;
	private String queryLang;
	private String targetNS;
	private Variables vars;
	private boolean isAbs;
	private boolean isEnableInstanceComp;
	private boolean isSuppJoinFail;
	private Activity activity;	
	
	public CompensationHandler getCompensationHandler() {
		// 
		return this.compsentaionH;
	}

	public CorrelationSets getCorrelationSets() {
		// 
		return this.correlationSets;
	}

	public EventHandlers getEventHandlers() {
		// 
		return this.eventH;
	}

	public String getExpressionLanguage() {
		// 
		return this.expLang;
	}

	public FaultHandlers getFaultHandlers() {
		// 
		return this.faultH;
	}

	public String getName() {
		// 
		return this.name;
	}

	public PartnerLinks getPartnerLinks() {
		// 
		return this.partnerLinks;
	}

	public Partners getPartners() {
		// 
		return this.partners;
	}

	public String getQueryLanguage() {
		// 
		return this.queryLang;
	}

	public String getTargetNamespace() {
		// 
		return this.targetNS;
	}

	public Variables getVariables() {
		// 
		return this.vars;
	}

	public boolean isAbstractProcess() {
		// 
		return this.isAbs;
	}

	public boolean isEnableInstanceCompensation() {
		// 
		return this.isEnableInstanceComp;
	}

	public boolean isSuppressJoinFailure() {
		// 
		return this.isSuppJoinFail;
	}

	public void setCompensationHandler(CompensationHandler comhndlr) {
		// 
		this.compsentaionH=comhndlr;

	}

	public void setCorrelationSets(CorrelationSets corrsets) {
		// 
		this.correlationSets=corrsets;

	}

	public void setEventHandlers(EventHandlers evnthndlrs) {
		// 
		this.eventH=evnthndlrs;

	}

	public void setExpressionLanguage(String lang) {
		// 
		this.expLang=lang;

	}

	public void setFaultHandlers(FaultHandlers fh) {
		// 
		this.faultH=fh;

	}

	public void setIsAbstractProcess(boolean isabs) {
		// 
		this.isAbs=isabs;

	}

	public void setIsEnableInstanceCompensation(boolean iscomp) {
		// 
		this.isEnableInstanceComp=iscomp;

	}

	public void setIsSuppressJoinFailure(boolean isjoinfail) {
		// 
		this.isSuppJoinFail=isjoinfail;

	}

	public void setName(String name) {
		// 
		this.name=name;

	}

	public void setPartnerLinks(PartnerLinks partnerlinks) {
		// 
		this.partnerLinks=partnerlinks;		

	}

	public void setPartners(Partners partners) {
		// 
		this.partners=partners;

	}

	public void setQueryLanguage(String lang) {
		// 
		this.queryLang=lang;

	}

	public void setTargetNamespace(String ns) {
		// 
		this.targetNS=ns;

	}

	public void setVariables(Variables vars) {
		// 
		this.vars=vars;

	}

	public Activity getActivity() {
		// 
		return this.activity;
	}

	public void setActivity(Activity act) {
		// 
		this.activity=act;
		
	}
	
	//visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}
	
}
