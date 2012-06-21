package pdn.bee.model.bpel11.elements.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.Partner;
import pdn.bee.model.bpel11.elements.PartnerLinks;

public class PartnerImpl implements Partner {

	private String name;
	private PartnerLinks plinks=null;
	
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	public PartnerLinks getPartnerLinks() {
		// TODO Auto-generated method stub
		return this.plinks;
	}

	public void setName(String name) {
		// 
		this.name=name;

	}

	public void setPartnerLinks(PartnerLinks plinks) {
		// 
		this.plinks=plinks;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		//engine.process(this, instance);
	}

}
