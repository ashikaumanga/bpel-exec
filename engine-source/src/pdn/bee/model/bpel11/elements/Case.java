/**
 * 
 */
package pdn.bee.model.bpel11.elements;
import pdn.bee.model.bpel11.expression.BooleanExpression;
/**
 * @author umanga
 *
 */
public interface Case extends BPELRoot {
	
	public BooleanExpression getCondition();
	public void setCondition(BooleanExpression boolexpr);

}
