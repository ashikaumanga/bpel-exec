package pdn.bee.model.bpel11.elements.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.Link;
import pdn.bee.model.bpel11.elements.Target;

public class TargetImpl extends BPELRootImpl implements Target {

	private Link lnk=null;
	public Link getLink() {
		// 
		return this.lnk;
	}

	public void setLink(Link mylink) {
		// 
		this.lnk=mylink;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}

}
