/**
 * 
 */
package pdn.bee.model.bpel11.elements;

/**
 * @author umanga
 *
 */
public interface Catch extends ActivityOrCompensateContainer {
	
	public String getFaultName();
	public String getFaultVariable();
	
	public void setFaultName(String fn);
	public void setFaultVariable(String svr);

}
