/**
 * 
 */
package pdn.bee.model.bpel11.elements;

/**
 * @author umanga
 *
 */
import pdn.bee.model.bpel11.elements.Link;

public interface Target extends BPELRoot {
	
	public Link getLink();
	public void setLink(Link mylink);
	

}
