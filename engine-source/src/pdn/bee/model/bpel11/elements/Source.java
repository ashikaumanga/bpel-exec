/**
 * 
 */
package pdn.bee.model.bpel11.elements;

/**
 * @author umanga
 *
 */
public interface Source extends BPELRoot {
	
	public Link getLink();
	public void setLink(Link link);
	
	public boolean getTransitionCondition();
	public void setTransitionCondition(boolean transcond);
	

}
