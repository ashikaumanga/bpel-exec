package pdn.bee.model.bpel11.elements;
import java.util.List;
public interface Correlations extends BPELRoot {
	public List getCorrelations();
	public void addCorrelation(Correlation correlation);
	public void setCorrelations(List correlations);
	
	
	

}
