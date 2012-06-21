/**
 * 
 */
package pdn.bee.model.bpel11.activity;
import pdn.bee.model.bpel11.elements.Links;
import java.util.List;
/**
 * @author umanga
 *
 */
public interface Flow extends Activity {
	
	public Links getLinks();
	public void setLinks(Links links);
	
	public List getActivities();
	public void setActivities(List activities);
	public void addActivity(Activity activity);
	

}
