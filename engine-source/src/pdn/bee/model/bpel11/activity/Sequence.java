/**
 * 
 */
package pdn.bee.model.bpel11.activity;
import java.util.List;
/**
 * @author umanga
 *
 */
public interface Sequence extends Activity {
	
	public List getActivities();
	public void setActivities(List activities);
	public void addActivity(Activity act);
	


}
