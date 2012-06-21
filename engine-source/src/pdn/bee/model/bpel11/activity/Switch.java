/**
 * 
 */
package pdn.bee.model.bpel11.activity;
import pdn.bee.model.bpel11.elements.Case;
import pdn.bee.model.bpel11.elements.ActivityContainer;
import java.util.List;
/**
 * @author umanga
 *
 */
public interface Switch extends Activity {
	
	public List getCases();
	public void setCases(List cases);
	public void addCase(Case acase);
	
	public Activity getOtherwise();
	public void setOtherwise(Activity activity);

}
