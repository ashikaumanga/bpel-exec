package pdn.bee.model.bpel11.elements;
import pdn.bee.model.bpel11.expression.*;
public interface OnAlarm extends ActivityContainer {
	public DurationExpression getFor();
	public void setFor(DurationExpression dexp);
	public DeadlineExpression getUntil();
	public void setUntil(DeadlineExpression deadlineexp);
	
	

}
