package pdn.bee.model.bpel11.elements;
import javax.xml.namespace.QName;
public interface Variable extends BPELRoot {
	
	public String getName();
	public void setName(String name);
	
	public QName getMessageType();
	public void setMessageType(QName msgType);
	
	public QName getType();
	public void setType(QName stype);
	
	public QName getElement();
	public void setElement(QName elmnt);
	
	public String getTargetNamespace();
	public void setTargetNamespace(String tns);
	
	
	

}
