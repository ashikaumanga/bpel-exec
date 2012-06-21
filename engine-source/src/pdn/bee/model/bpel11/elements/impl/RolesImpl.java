package pdn.bee.model.bpel11.elements.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.Roles;

public class RolesImpl implements Roles {

	private String role;
	public String getRole() {
		// 
		return role;
	}

	public void setRole(String role) {
		// 
		this.role=role;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		//engine.process(this, instance);
	}

}
