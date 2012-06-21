package pdn.bee.binder;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.xml.sax.Attributes;

import pdn.bee.model.BPELElementFactory;
import pdn.bee.model.bpel11.elements.BPELRoot;
import pdn.bee.model.bpel11.elements.From;
import pdn.bee.model.bpel11.process.BPELProcess;

public class FromFactory extends AbstractObjectCreationFactory {

	@Override
	public Object createObject(Attributes attrs) throws Exception {
		// 
		BPELProcess bpelproc=(BPELProcess)this.getDigester().getRoot();
		
		BPELElementFactory fac=BPELElementFactory.getInstance(bpelproc);
		//String name=attrs.getValue(BPELRoot.NAME);
		//String joincond=attrs.getValue(BPELRoot.JOIN_CONDITION);
		//String supp=attrs.getValue(BPELRoot.SUPPRESS_JOIN_FAILURE);
		String variable=attrs.getValue(BPELRoot.VARIABLE);
		String part=attrs.getValue(BPELRoot.PART);
		String query=attrs.getValue(BPELRoot.QUERY);
		String property=attrs.getValue(BPELRoot.PROPERTY);
		String partnerlink=attrs.getValue(BPELRoot.PARTNER_LINK);
		String endpointref=attrs.getValue(BPELRoot.ENDPOINT_REFERENCE);
		String expression=attrs.getValue(BPELRoot.EXPRESSION);
		String opaque=attrs.getValue(BPELRoot.OPAQUE);
		
		From from=fac.createFrom(variable, part, query, property, 
				partnerlink, endpointref, expression, opaque);
		return from;
	}

}
