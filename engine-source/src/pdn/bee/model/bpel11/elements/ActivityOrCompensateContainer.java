package pdn.bee.model.bpel11.elements;

import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Compensate;

public interface ActivityOrCompensateContainer extends BPELRoot {
	
	public Activity getActivity();
	public void setActivity(Activity act);
	
	public Compensate getCompensate();
	public void setCompensate(Compensate compensate);
	
	

}
