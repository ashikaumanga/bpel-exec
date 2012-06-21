package pdn.bee.model.bpel11.elements.impl;

import javax.xml.namespace.QName;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.From;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.Roles;
import pdn.bee.model.bpel11.elements.Variable;

public class FromImpl extends BPELRootImpl implements From {

	private Roles epr=null;
	private String exp;
	private boolean opaque;
	private String part;
	private PartnerLink partnerlink=null;
	private QName prop=null;
	private String query;
	private Variable var=null;
	
	public Roles getEndpointReference() {
		// 
		return this.epr;
	}

	public String getExpression() {
		// 
		return this.exp;
	}

	public boolean getOpaque() {
		// 
		return this.opaque;
	}

	public String getPart() {
		// 
		return this.part;
	}

	public PartnerLink getPartnerLink() {
		// 
		return this.partnerlink;
	}

	public QName getProperty() {
		// 
		return this.prop;
	}

	public String getQuery() {
		// 
		return this.query;
	}

	public Variable getVariable() {
		// 
		return this.var;
	}

	public void setEndpointReference(Roles endopint) {
		// 
		this.epr=endopint;

	}

	public void setExpression(String expression) {
		// 
		this.exp=expression;
	}

	public void setOpaque(boolean isOpaque) {
		// 
		this.opaque=isOpaque;

	}

	public void setPart(String part) {
		// 
		this.part=part;

	}

	public void setPartnerLink(PartnerLink partnerlink) {
		// 
		this.partnerlink=partnerlink;

	}

	public void setProperty(QName prop) {
		// 
		this.prop=prop;

	}

	public void setQuery(String query) {
		// 
		this.query=query;

	}

	public void setVariable(Variable var) {
		// 
		this.var=var;
	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}

}
