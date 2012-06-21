package pdn.bee.model.bpel11.elements;
import java.util.List;

public interface PartnerLinks extends BPELRoot {
	
	public void addPartnerLink(PartnerLink plink);
	public List getPartnerLinks();
	public void setPartnerLinks(List links);

}
