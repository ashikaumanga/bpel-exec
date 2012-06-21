package pdn.bee.model.bpel11.elements;
import java.util.List;
public interface EventHandlers extends BPELRoot {
	
	public List getOnMessages();
	public void addOnMessage(OnMessage onmessage);
	public void setOnMessages(List onmessages);
	
	public List getOnAlarms();
	public void addOnAlarm(OnAlarm onalarm);
	public void setOnAlarms(List onalarms);
	
	
	

}
