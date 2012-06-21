/**
 * 
 */
package pdn.bee.model.bpel11.elements;

import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.expression.DurationExpression;
import pdn.bee.model.bpel11.expression.DeadlineExpression;
/**
 * @author umanga
 *
 */
public interface Wait extends Activity {
	
	public DurationExpression getFor();
	public void setFor(DurationExpression sfor);
	
	public DeadlineExpression getUntil();
	public void setUntil(DeadlineExpression suntil);

}
