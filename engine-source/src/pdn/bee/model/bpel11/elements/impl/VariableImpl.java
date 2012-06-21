package pdn.bee.model.bpel11.elements.impl;

import javax.xml.namespace.QName;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.Variable;

public class VariableImpl extends BPELRootImpl implements Variable {

	private QName element=null;
	private QName msgtype=null;
	private QName type=null;
	private String tns=null;
	private String name;
	
	public VariableImpl()
	{
		//javax.swing.JOptionPane.showMessageDialog(null,"var set");
	}
	public QName getElement() {
		// 
		return this.element;
	}

	public QName getMessageType() {
		// TODO Auto-generated method stub
		return this.msgtype;
	}

	public String getName() {
		// 
		return this.name;
	}

	public QName getType() {
		// 
		return this.type;
	}

	public void setElement(QName elmnt) {
		// 
		this.element=elmnt;

	}

	public void setMessageType(QName msgType) {
		// 
		this.msgtype=msgType;

	}

	public void setName(String name) {
		// 
		this.name=name;

	}

	public void setType(QName stype) {
		// 
		this.type=stype;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}
	public String getTargetNamespace() {
		// 
		return tns;
	}
	public void setTargetNamespace(String tns) {
		// 
		this.tns=tns;
		
	}
	
	public String toString()
	{
	return this.name;
	}
	
	

}
