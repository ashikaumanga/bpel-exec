/**
 * 
 */
package pdn.bee.model.bpel11.activity;
import pdn.bee.model.bpel11.elements.Copy;

import java.util.List;
/**
 * @author umanga
 *
 */
public interface Assign extends Activity {
	
	public List getAllCopy();
	public void setAllCopy(List copys);
	public void addCopy(Copy acopy);
	
	

}
