/**
 * 
 */
package pdn.bee.model.bpel11.activity;
import pdn.bee.model.bpel11.elements.Variables;
import pdn.bee.model.bpel11.elements.CorrelationSets;
import pdn.bee.model.bpel11.elements.FaultHandlers;
import pdn.bee.model.bpel11.elements.CompensationHandler;
import pdn.bee.model.bpel11.elements.EventHandlers;
/**
 * @author umanga
 *
 */
public interface Scope extends Activity {
	
	public Variables getVariables();
	public void setVariables(Variables vars);
	
	public CorrelationSets getCorrelationSets();
	public void setCorrelationSets(CorrelationSets correlationsets);
	
	public FaultHandlers getFaultHandlers();
	public void setFaultHandlers(FaultHandlers fhandles);
	
	public CompensationHandler getCompensationHandler();
	public void setCompensationHandler(CompensationHandler comphndlrs);
	
	public EventHandlers getEventHandlers();
	public void setEventHandlers(EventHandlers evnthndlrs);
	
	public boolean getVariableAccessSerializable();
	public void setVariableAccessSerializable(boolean varsr);
	

}
