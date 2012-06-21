package pdn.bee.model.bpel11.elements.impl;

import javax.xml.namespace.QName;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.PartnerLink;

public class PartnerLinkImpl implements PartnerLink {

	private String myRole;
	private String name;
	private String partnerRole;
	private QName partnerLinkType;
	public void setMyRole(String myr) {
		// 
		this.myRole=myr;
		
	}

	public void setPartnerLinkType(QName plt) {
		// 
		this.partnerLinkType=plt;
		
	}

	public void setPartnerRole(String pr) {
		// 
		this.partnerRole=pr;
		
	}

	public String getMyRole() {
		// 
		return this.myRole;
	}

	public String getName() {
		// 
		return this.name;
	}

	public String getPartnerRole() {
		// 
		return this.partnerRole;
	}

	public QName partnerLinkType() {
		// 
		return this.partnerLinkType;
	}

	public void setName(String name) {
		// 
		this.name=name;
	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}

}
