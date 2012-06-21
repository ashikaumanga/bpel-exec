package pdn.bee.model.bpel11.elements.impl;

import java.util.List;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.PartnerLinks;

public class PartnerLinksImpl implements PartnerLinks {
	
	private List plinks=null;
	
	public PartnerLinksImpl() {
		super();
		plinks=new java.util.ArrayList();
	}

	public void addPartnerLink(PartnerLink plink) {
		// 
		plinks.add(plink);

	}

	public List getPartnerLinks() {
		// 
		return this.plinks;
	}

	public void setPartnerLinks(List links) {
		// 
		this.plinks=links;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}

}
