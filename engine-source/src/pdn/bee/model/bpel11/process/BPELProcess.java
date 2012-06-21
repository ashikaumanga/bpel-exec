/**
 * 
 */
package pdn.bee.model.bpel11.process;
import java.util.List;
import java.util.Map;

import javax.wsdl.Definition;

/**
 * @author umanga
 *
 */
public interface BPELProcess {
	
	public Process getProcess();
	public void setProcess(Process proc);
	public Definition getDefinition();
	public void setDefinition(Definition def);
	public List getPartnerWDSL();
	public void setPartnerWSDL(List wsdls);
	public boolean isSync();
	public void setSync(boolean sync);
	public void setTargetNamespace(String ns);
	public String getTargetNamespace();
	public void setSchemaTypes(Map schemaTypes);
	public Map getSchemaTypes();
	public void setMessagePartsOMElementMap(Map msgparts);
	public Map getMessagePartsOMElementMap();
	

}
