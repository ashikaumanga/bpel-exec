package pdn.bee.model.bpel11.elements;
import java.util.List;
public interface CorrelationSets extends BPELRoot {
	
	public List getCorrelationSets();
	public void addCorrelationSet(CorrelationSet correlationset);
	
	public void setCorrelationSets(List correlationsets);

}
