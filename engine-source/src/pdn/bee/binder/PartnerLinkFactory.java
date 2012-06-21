package pdn.bee.binder;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.xml.sax.Attributes;

import pdn.bee.model.BPELElementFactory;
import pdn.bee.model.bpel11.elements.BPELRoot;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.process.BPELProcess;

public class PartnerLinkFactory extends AbstractObjectCreationFactory {

	@Override
	public Object createObject(Attributes attrs) throws Exception {
		// 
		BPELProcess bpelproc=(BPELProcess)getDigester().getRoot();
		
		String name=attrs.getValue(BPELRoot.NAME);
		String ptype=attrs.getValue(BPELRoot.PARTNER_LINK_TYPE);
		String myrole=attrs.getValue(BPELRoot.MY_ROLE);
		String partnerrole=attrs.getValue(BPELRoot.PARTNER_ROLE);
		
		BPELElementFactory fac=BPELElementFactory.getInstance(bpelproc);
		PartnerLink plink= fac.createParnerLink(name, ptype, myrole, partnerrole);
		
		return plink;
	}

}
