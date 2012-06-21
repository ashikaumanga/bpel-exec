package pdn.bee.model.bpel11.activity;

import java.util.List;

import javax.xml.namespace.QName;

import pdn.bee.model.bpel11.elements.Correlations;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.Variable;

public interface Reply {
	
	public List getCorrelations();
	public void setCorrelations(List corelations);
	public void addCorrelations(Correlations corelations);
	
	public PartnerLink getPartnerLink();
	public QName getPortType();
	public String getOperation();
	public Variable getVariable();
	public QName getFaultName();
	
	public void setPartnerLink(PartnerLink pl);
	public void setPortType(QName porttype);
	public void setOperation(String operation);
	public void setVariable(Variable var);
	public void setFaultName(QName faultname);
	
	

}
