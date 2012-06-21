/**
 * 
 */
package pdn.bee.model.bpel11.elements;
import pdn.bee.model.bpel11.activity.Activity;
import javax.xml.namespace.QName;
/**
 * @author umanga
 *
 */
public interface OnMessage extends BPELRoot {

	public Correlations getCorrelations();
	public void setCorrelations(Correlations correlations);
	public Activity getActivity();
	public void setActivity(Activity activity);
	public void setPartnerLink(PartnerLink plink);
	public PartnerLink getPartnerLink();
	public QName getPortType();
	public void setPortType(QName porttype);
	public void setOperation(String operation);
	public String getOperation();
	public void setVariable(Variable var);
	public Variable getVariable();
	
	
	
	
}
