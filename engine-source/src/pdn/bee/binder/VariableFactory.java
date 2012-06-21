package pdn.bee.binder;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.xml.sax.Attributes;

import pdn.bee.model.BPELElementFactory;
import pdn.bee.model.bpel11.elements.BPELRoot;
import pdn.bee.model.bpel11.elements.Variable;
import pdn.bee.model.bpel11.process.BPELProcess;

public class VariableFactory extends AbstractObjectCreationFactory {

	@Override
	public Object createObject(Attributes attrs) throws Exception {
		// 
		BPELProcess bpelproc=(BPELProcess) this.getDigester().getRoot();
		
		String name=attrs.getValue(BPELRoot.NAME);
		String msgtype=attrs.getValue(BPELRoot.MESSAGE_TYPE);
		String type=attrs.getValue(BPELRoot.TYPE);
		String element=attrs.getValue(BPELRoot.ELEMENT);		
		
		BPELElementFactory fac=BPELElementFactory.getInstance(bpelproc);
		Variable var=fac.createVariable(name, msgtype, type, element);		
		return var;
	}

}
