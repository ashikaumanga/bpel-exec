package pdn.bee.model.bpel11.elements.impl;

import java.util.List;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.Variable;
import pdn.bee.model.bpel11.elements.Variables;

public class VariablesImpl extends BPELRootImpl implements Variables {

	private List vars=null;
	
	public VariablesImpl() {
		super();
		vars=new java.util.ArrayList();		
	}

	public void addVariable(Variable var) {
		// 
		vars.add(var);

	}

	public List getVariables() {
		// 
		return this.vars;
	}

	public void setVariables(List vars) {
		// 
		this.vars=vars;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}

}
