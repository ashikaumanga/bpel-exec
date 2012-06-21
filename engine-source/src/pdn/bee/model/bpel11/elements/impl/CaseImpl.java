/**
 * 
 */
package pdn.bee.model.bpel11.elements.impl;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;
import pdn.bee.model.bpel11.elements.Case;
import pdn.bee.model.bpel11.expression.BooleanExpression;

/**
 * @author umanga
 *
 */
public class CaseImpl extends BPELRootImpl implements Case {

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.elements.Case#getBooleanExpression()
	 */
	private BooleanExpression condition=null;
	public BooleanExpression getCondition() {
		// 
		return this.condition;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.elements.Case#setBooleanExpression(pdn.bee.model.bpel11.expression.BooleanExpression)
	 */
	public void setCondition(BooleanExpression boolexpr) {
		// 
		this.condition=boolexpr;

	}
	
//	visitor pattern accept method
	public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception
	{
		engine.process(this, instance);
	}
	

}
