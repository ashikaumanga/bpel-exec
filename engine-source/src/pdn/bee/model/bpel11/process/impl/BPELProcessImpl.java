/**
 * 
 */
package pdn.bee.model.bpel11.process.impl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.wsdl.Definition;

import pdn.bee.model.bpel11.process.Process;

/**
 * @author umanga
 *
 */
public class BPELProcessImpl implements pdn.bee.model.bpel11.process.BPELProcess {

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.process.BPELProcess#getDefinition()
	 */
	private Definition wsdl=null;
	private List partners=null;
	private Process process=null;
	private boolean sync;
	private String tns=null;
	private Map allSchemaTypes=null;
	private Map msgParts=null;
	
	
	public BPELProcessImpl() {
		partners=new ArrayList();
		allSchemaTypes=new Hashtable();
		msgParts=new Hashtable();
		
	}

	public Definition getDefinition() {
		// 
		return this.wsdl;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.process.BPELProcess#getPartnerWDSL()
	 */
	public List getPartnerWDSL() {
		// 
		return this.partners;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.process.BPELProcess#getProcess()
	 */
	public Process getProcess() {
		// 
		return this.process;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.process.BPELProcess#isSync()
	 */
	public boolean isSync() {
		// 
		return this.sync;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.process.BPELProcess#setDefinition(javax.wsdl.Definition)
	 */
	public void setDefinition(Definition def) {
		// TODO 
		this.wsdl=def;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.process.BPELProcess#setPartnerWSDL(java.util.List)
	 */
	public void setPartnerWSDL(List wsdls) {
		// 
		this.partners=wsdls;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.process.BPELProcess#setProcess(pdn.bee.model.bpel11.process.Process)
	 */
	public void setProcess(Process proc) {
		//		
		this.process=proc;

	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.process.BPELProcess#setSync(boolean)
	 */
	public void setSync(boolean sync) {
		// 
		this.sync=sync;

	}

	public String getTargetNamespace() {
		
		return tns;
	}

	public void setTargetNamespace(String ns) {
		tns=ns;
		
	}

	public Map getMessagePartsOMElementMap() {
		// 
		return msgParts;
	}

	public Map getSchemaTypes() {
		// 
		return allSchemaTypes;
	}

	public void setMessagePartsOMElementMap(Map msgparts) {
		// 
        this.msgParts=msgparts; 
		
	}

	public void setSchemaTypes(Map schemaTypes) {
		// 
		this.allSchemaTypes=schemaTypes;
		
	}
	

}
