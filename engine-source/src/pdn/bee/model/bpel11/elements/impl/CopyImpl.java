package pdn.bee.model.bpel11.elements.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.Copy;
import pdn.bee.model.bpel11.elements.From;
import pdn.bee.model.bpel11.elements.To;

public class CopyImpl extends BPELRootImpl implements Copy {

	private From from=null;
	private To to=null;
	
	public From getFrom() {
		// 
		return this.from;
	}

	public To getTo() {
		// 
		return this.to;
	}

	public void setFrom(From frm) {
		// 
		
		this.from=frm;

	}

	public void setTo(To to) {
		// 
		
		this.to=to;

	}
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}

}
