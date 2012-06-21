package pdn.bee.model.bpel11.elements;
import pdn.bee.model.bpel11.activity.Activity;
public interface ActivityContainer extends BPELRoot {
	public Activity getActivity();
	public void setActivity(Activity activity);
	
}
