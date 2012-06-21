package pdn.bee.model.bpel11.elements;

public interface Roles extends BPELRoot {

	public static String MY_ROLE="myRole";
	public static String PARTNER_ROLE="partnerRole";
	public void setRole(String role);
	public String getRole();
}
