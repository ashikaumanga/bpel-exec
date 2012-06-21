/**
 * 
 */
package pdn.bee.model.bpel11.activity;

import pdn.bee.model.bpel11.elements.BPELRoot;
import pdn.bee.model.bpel11.elements.Target;
import pdn.bee.model.bpel11.elements.Source;
import pdn.bee.model.bpel11.expression.BooleanExpression;
import java.util.List;
/**
 * @author umanga
 *
 */
public interface Activity extends BPELRoot {
	
	public List getTargets();
	public void setTargets(List targets);
	public void addTarget(Target target);
	
	public List getSources();
	public void setSources(List sources);
	public void addSource(Source source);
	
	public String getName();
	public void setName(String name);
	
	public BooleanExpression getJoinCondiion();
	public void setJoinCondition(BooleanExpression boolexp);
	
	public boolean getSuppressJoinFailure();
	public void setSuppressJoinFailure(boolean joinfail);
	
	//method to use add activities to Digester objects,this method is called by digester
	public void setActivity(Activity addnew);
		
	

}
