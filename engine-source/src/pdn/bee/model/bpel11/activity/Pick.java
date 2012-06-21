/**
 * 
 */
package pdn.bee.model.bpel11.activity;
import pdn.bee.model.bpel11.elements.OnMessage;
import pdn.bee.model.bpel11.elements.OnAlarm;
/**
 * @author umanga
 *
 */
public interface Pick extends Activity {
	
	public OnMessage getOnMessage();
	public void setOnMessage(OnMessage onmsg);
	
	public OnAlarm getOnAlarm();
	public void setOnAlarm(OnAlarm onalarm);
	
	

}
