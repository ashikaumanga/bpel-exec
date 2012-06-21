/**
 * interface represents BPEL PartnerLink element
 */
package pdn.bee.model.bpel11.elements;

import javax.xml.namespace.QName;

/**
 * @author umanga
 *
 */
public interface PartnerLink extends BPELRoot {
	
	
	public String getName();
	public void setName(String name);
	public QName partnerLinkType();
	public String getMyRole();
	public String getPartnerRole();
	
	public void setPartnerLinkType(QName plt);
	public void setMyRole(String myr);
	public void setPartnerRole(String pr);
	

}
