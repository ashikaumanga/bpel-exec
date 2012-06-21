package pdn.bee.model.bpel11.elements;

public interface Partner extends BPELRoot {
	
	public String getName();
	public void setName(String name);
	public PartnerLinks getPartnerLinks();
	public void setPartnerLinks(PartnerLinks plinks);

}
