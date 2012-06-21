package pdn.bee.binder;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.xml.sax.Attributes;

import pdn.bee.model.BPELElementFactory;
import pdn.bee.model.bpel11.activity.Sequence;
import pdn.bee.model.bpel11.elements.BPELRoot;
import pdn.bee.model.bpel11.process.BPELProcess;

public class SequenceFactory extends AbstractObjectCreationFactory {

	@Override
	public Object createObject(Attributes attrs) throws Exception {
		// TODO Auto-generated method stub
		BPELProcess bpelproc=(BPELProcess)this.getDigester().getRoot();
		
		BPELElementFactory fac=BPELElementFactory.getInstance(bpelproc);
		String name=attrs.getValue(BPELRoot.NAME);
		String joincond=attrs.getValue(BPELRoot.JOIN_CONDITION);
		String supp=attrs.getValue(BPELRoot.SUPPRESS_JOIN_FAILURE);
		
		Sequence seq=fac.createSequence(name, joincond, supp);
		return seq;
	}

}
