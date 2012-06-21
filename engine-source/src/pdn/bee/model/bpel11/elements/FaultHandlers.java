package pdn.bee.model.bpel11.elements;
import java.util.List;
public interface FaultHandlers extends BPELRoot{

	public List getCatches();
	public ActivityOrCompensateContainer getCatchAll();
	
	public void addCatch(Catch acatch);
	public void setCatches(List catches);
	public void setCatchAll(ActivityOrCompensateContainer aocc);
}
