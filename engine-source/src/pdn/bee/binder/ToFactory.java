package pdn.bee.binder;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.xml.sax.Attributes;

import pdn.bee.model.BPELElementFactory;
import pdn.bee.model.bpel11.elements.BPELRoot;
import pdn.bee.model.bpel11.elements.To;
import pdn.bee.model.bpel11.process.BPELProcess;

public class ToFactory extends AbstractObjectCreationFactory {

	@Override
	public Object createObject(Attributes attrs) throws Exception {
		// 
		BPELProcess bpelproc=(BPELProcess)this.getDigester().getRoot();
		
		BPELElementFactory fac=BPELElementFactory.getInstance(bpelproc);
		String variable=attrs.getValue(BPELRoot.VARIABLE);
		String part=attrs.getValue(BPELRoot.PART);
		String query=attrs.getValue(BPELRoot.QUERY);
		String prop=attrs.getValue(BPELRoot.PROPERTY);
		String plink=attrs.getValue(BPELRoot.PARTNER_LINK);
		
		To to=fac.createTo(variable, part, query, prop, plink);
		return to;
	}

}
