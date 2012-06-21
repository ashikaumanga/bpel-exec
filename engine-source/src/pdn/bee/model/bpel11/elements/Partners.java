package pdn.bee.model.bpel11.elements;
import java.util.List;
public interface Partners extends BPELRoot {
	public void addPartner(Partner partner);
	public List getPartners();
	public void setPartners(List partners);
	

}
