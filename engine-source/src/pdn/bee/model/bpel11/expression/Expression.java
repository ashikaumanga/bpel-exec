/**
 * 
 */
package pdn.bee.model.bpel11.expression;

import pdn.bee.model.bpel11.elements.BPELRoot;

/**
 * @author umanga
 *
 */
public interface Expression {
	
	public String getExpression();
	public void setExpression(String exp);
	
	public boolean evaluate();

}
