/**
 * 
 */
package pdn.bee.model.bpel11.activity;
import pdn.bee.model.bpel11.elements.Variable;
import javax.xml.namespace.QName;
/**
 * @author umanga
 *
 */
public interface Throw extends Activity {
	
	public QName getFaultName();
	public void setFaultName(QName fname);
	
	public Variable getFaultVariable();
	public void setFaultVariable(Variable fvar);
	
	
	

}
