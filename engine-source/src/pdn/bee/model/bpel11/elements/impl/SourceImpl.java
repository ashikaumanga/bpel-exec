package pdn.bee.model.bpel11.elements.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.Link;
import pdn.bee.model.bpel11.elements.Source;

public class SourceImpl extends BPELRootImpl implements Source {

	private Link lnk=null;
	private boolean transcond;
	
	public Link getLink() {
		// 
		return lnk;
	}

	public boolean getTransitionCondition() {
		// 
		return transcond;
	}

	public void setLink(Link link) {
		// 
		this.lnk=link;

	}

	public void setTransitionCondition(boolean transcond) {
		// 
		this.transcond=transcond;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}

}
