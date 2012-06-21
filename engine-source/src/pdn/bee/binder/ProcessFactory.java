package pdn.bee.binder;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.xml.sax.Attributes;

import pdn.bee.model.BPELElementFactory;
import pdn.bee.model.bpel11.elements.BPELRoot;
import pdn.bee.model.bpel11.process.BPELProcess;
import pdn.bee.model.bpel11.process.Process;

public class ProcessFactory extends AbstractObjectCreationFactory {

	@Override
	public Object createObject(Attributes arg0) throws Exception {
		// TODO Auto-generated method stub
		BPELProcess bpelproc=(BPELProcess)getDigester().getRoot();
		BPELElementFactory fac=BPELElementFactory.getInstance(bpelproc);
		
		String name=arg0.getValue(BPELRoot.NAME);
		String namespace=arg0.getValue(BPELRoot.TARGET_NAMESPACE);
		String querylang=arg0.getValue(BPELRoot.QUERY_LANGUAGE);
		String explang=arg0.getValue(BPELRoot.EXPRESSION_LANGUAGE);
		String joinfail=arg0.getValue(BPELRoot.SUPPRESS_JOIN_FAILURE);
		String enblcompensation=arg0.getValue(BPELRoot.ENABLE_INSTANCE_COMPESATION);
		String absractprocess=arg0.getValue(BPELRoot.ABSTRACT_PROCESS);
		
		Map namespaces=new Hashtable();
		String attr=null;
		for(int i=0;i<arg0.getLength();i++)
		{
			attr=arg0.getQName(i);
			int ind=attr.indexOf(":");
			if(ind!=-1)
			{
				namespaces.put(attr.substring(ind+1), arg0.getValue(i));
			}
			
		}
		
		
		Process proc=fac.createProcess(name, namespace, querylang, explang, joinfail, enblcompensation, absractprocess, namespaces);
		return proc;
	}

}
