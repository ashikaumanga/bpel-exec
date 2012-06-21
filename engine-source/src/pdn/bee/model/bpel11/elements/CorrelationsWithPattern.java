package pdn.bee.model.bpel11.elements;
import java.util.List;
public interface CorrelationsWithPattern extends BPELRoot {
	
	public List getCorrelations();
	public void setCorrelations(List correlations);
	
	public void addCorrelation(Correlation correlation);

}
