/**
 * 
 */
package pdn.bee.model.bpel11.expression.impl;

/**
 * @author umanga
 *
 */
public abstract class ExpressionImpl implements
		pdn.bee.model.bpel11.expression.Expression {

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.expression.Expression#evaluate()
	 */
	private String exp;
	public boolean evaluate() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.expression.Expression#getExpression()
	 */
	public String getExpression() {
		// TODO Auto-generated method stub
		return this.exp;
	}

	/* (non-Javadoc)
	 * @see pdn.bee.model.bpel11.expression.Expression#setExpression(java.lang.String)
	 */
	public void setExpression(String exp) {
		// 
		this.exp=exp;

	}

}
