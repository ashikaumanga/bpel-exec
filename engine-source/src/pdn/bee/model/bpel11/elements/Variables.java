package pdn.bee.model.bpel11.elements;
import java.util.List;
public interface Variables extends BPELRoot {

	public List getVariables();
	public void addVariable(Variable var);
	public void setVariables(List vars);
	
	
}
