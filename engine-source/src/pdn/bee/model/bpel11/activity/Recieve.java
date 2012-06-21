/**
 * 
 */
package pdn.bee.model.bpel11.activity;
import pdn.bee.model.bpel11.elements.Correlations;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.Variable;
import javax.xml.namespace.QName;


/**
 * @author umanga
 *
 */
public interface Recieve extends Activity {
	
	public Correlations getCorrelations();
	public void setCorrelations(Correlations correlations);
	
	public PartnerLink getPartnerLink();
	public void setPartnerLink(PartnerLink partnerlink);
	
	public QName getPortType();
	public void setPortType(QName porttype);
	
	public String getOperation();
	public void setOperation(String operation);
	
	public Variable getVarible();
	public void setVariable(Variable var);
	
	public boolean isCreateInstance();
	public void setIsCreateInstance(boolean creatinst);

}
