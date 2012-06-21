package pdn.bee.model.bpel11.elements.impl;

import java.util.List;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.ActivityOrCompensateContainer;
import pdn.bee.model.bpel11.elements.Catch;
import pdn.bee.model.bpel11.elements.FaultHandlers;

public class FaultHandlersImpl implements FaultHandlers {

	private List catches=null;
	private ActivityOrCompensateContainer catchall=null;
	
	public void addCatch(Catch acatch) {
		// 
		catches.add(acatch);

	}

	public ActivityOrCompensateContainer getCatchAll() {
		// 
		return this.getCatchAll();
	}

	public List getCatches() {
		// 
		return this.catches;
	}

	public void setCatchAll(ActivityOrCompensateContainer aocc) {
		// 
		this.catchall=aocc;

	}

	public void setCatches(List catches) {
		// 
		this.catches=catches;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		//engine.process(this, instance);
	}

}
