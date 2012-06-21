/**
 * 
 */
package pdn.bee.model.bpel11.activity;
import java.util.List;

import javax.xml.namespace.QName;
import pdn.bee.model.bpel11.elements.ActivityOrCompensateContainer;
import pdn.bee.model.bpel11.elements.Catch;
import pdn.bee.model.bpel11.elements.CompensationHandler;
import pdn.bee.model.bpel11.elements.CorrelationsWithPattern;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.Variable;
/**
 * @author umanga
 *
 */
public interface Invoke extends Activity {
	
	public CorrelationsWithPattern getCorrelations();
	public void setCorrelations(CorrelationsWithPattern correlations);
	
	public List getCatches();
	public void setCatches(List catches);
	public void addCatch(Catch ncatch);
	
	public CompensationHandler getCompensationHandler();
	public void setCompensationHandler(CompensationHandler comphandle);
	
	public PartnerLink getPartnerLink();
	public void setPartnerLink(PartnerLink parnerlink);
	
	public QName getPortType();
	public void setPortType(QName porttype);
	
	public String getOperation();
	public void setOperation(String operation);
	
	public Variable getInputVariable();
	public void setInputVariable(Variable invar);
	
	public ActivityOrCompensateContainer getCatchAll();
	public void setCatchAll(ActivityOrCompensateContainer catchall);
	
	public Variable getOutputVariable();
	public void setOutputVariable(Variable outvar);
	

}
