package pdn.bee.model.bpel11.elements.impl;

import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Compensate;
import pdn.bee.model.bpel11.elements.Catch;

public class CatchImpl extends ActivityOrCompensateImpl implements Catch {

	private String faultname;
	private String faultvar;
	public String getFaultName() {
		
		return this.faultname;
	}

	public String getFaultVariable() {
		// 
		return this.faultvar;
	}

	public void setFaultName(String fn) {
		// 
		this.faultname=fn;

	}

	public void setFaultVariable(String svr) {
		// 
		this.faultvar=svr;

	}

	

	

}
