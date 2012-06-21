/**
 * represents BPEL process element 
 */
package pdn.bee.model.bpel11.process;

import pdn.bee.model.bpel11.elements.BPELRoot;
import pdn.bee.model.bpel11.elements.PartnerLinks;
import pdn.bee.model.bpel11.elements.Partners;
import pdn.bee.model.bpel11.elements.Variables;
import pdn.bee.model.bpel11.elements.CorrelationSets;
import pdn.bee.model.bpel11.elements.FaultHandlers;
import pdn.bee.model.bpel11.elements.CompensationHandler;
import pdn.bee.model.bpel11.elements.EventHandlers;
import pdn.bee.model.bpel11.activity.Activity;
/**
 * @author umanga
 *
 */
public interface Process extends BPELRoot {
	
	//xml elements
	public PartnerLinks getPartnerLinks();
	public void setPartnerLinks(PartnerLinks partnerlinks);
	
	public Partners getPartners();
	public void setPartners(Partners partners);
	
	public Variables getVariables();
	public void setVariables(Variables vars);
	
	public CorrelationSets getCorrelationSets();
	public void setCorrelationSets(CorrelationSets corrsets);
	
	public FaultHandlers getFaultHandlers();
	public void setFaultHandlers(FaultHandlers fh);
	
	public CompensationHandler getCompensationHandler();
	public void setCompensationHandler(CompensationHandler comhndlr);
	
	public EventHandlers getEventHandlers();
	public void setEventHandlers(EventHandlers evnthndlrs);
	
	//xml attributes
	public String getName();
	public void setName(String name);
	
	public String getTargetNamespace();
	public void setTargetNamespace(String ns);
	
	public String getQueryLanguage();
	public void setQueryLanguage(String lang);
	
	public String getExpressionLanguage();
	public void setExpressionLanguage(String lang);
	
	public boolean isSuppressJoinFailure();
	public void setIsSuppressJoinFailure(boolean isjoinfail);
	
	public boolean isEnableInstanceCompensation();
	public void setIsEnableInstanceCompensation(boolean iscomp);
	
	public boolean isAbstractProcess();
	public void setIsAbstractProcess(boolean isabs);
	
	public Activity getActivity();
	public void setActivity(Activity act);
	

}
