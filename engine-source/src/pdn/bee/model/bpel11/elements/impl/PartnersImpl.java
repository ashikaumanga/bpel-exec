package pdn.bee.model.bpel11.elements.impl;

import java.util.List;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.Partner;
import pdn.bee.model.bpel11.elements.Partners;

public class PartnersImpl implements Partners {

	private List partners=null;
	public PartnersImpl() {
		super();
		partners=new java.util.ArrayList();
	}

	public void addPartner(Partner partner) {
		// 
		partners.add(partner);

	}

	public List getPartners() {
		// 
		return this.partners;
	}

	public void setPartners(List partners) {
		// 
		this.partners=partners;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		//engine.process(this, instance);
	}

}
