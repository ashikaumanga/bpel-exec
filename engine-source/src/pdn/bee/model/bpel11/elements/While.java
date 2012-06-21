/**
 * 
 */
package pdn.bee.model.bpel11.elements;

import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.expression.BooleanExpression;
/**
 * @author umanga
 *
 */
public interface While extends Activity {
	
	public Activity getActivity();
	public void setActivity(Activity activity);
	
	public BooleanExpression getCondition();
	public void setCondition(BooleanExpression condition);

}
