package pdn.bee.model.bpel11.elements;
import java.util.List;
import javax.xml.namespace.QName;
public interface CorrelationSet extends BPELRoot {
	
	public  List getProperties();
	public String getName();
	
	public void setProperties(List props);
	public void addPropertie(QName prop);
	public void setName(String name);

}
