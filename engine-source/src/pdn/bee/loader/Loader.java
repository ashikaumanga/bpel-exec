package pdn.bee.loader;

import java.util.ArrayList;
import java.util.List;

import javax.wsdl.Definition;
import javax.wsdl.xml.WSDLReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import pdn.bee.binder.BPELProcessFactory;
import pdn.bee.model.bpel11.process.BPELProcess;

public class Loader {
	
	private WSDLReader wsdlreader=null;
	WSDLProcessor wsdlProc=new WSDLProcessor();
	BPELProcess bproc=null;
	java.util.Map allschemaTypes;
	java.util.Map messageTypes;
	
	public BPELProcess loadFromIO(String bpelfile,String procDef,String partnerLinks[])
	{
		allschemaTypes=new java.util.Hashtable();
		messageTypes=new java.util.Hashtable();
		try {
		wsdlreader=javax.wsdl.factory.WSDLFactory.newInstance().newWSDLReader();
		
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		
		bproc=BPELProcessFactory.getInstance().createBPELProcess(bpelfile);
		
		bproc.setSync(true); //not defaults
		
		
		
		if(partnerLinks==null)
		{
			System.err.println("Partnerlinks null");
			return bproc;
		}		
		
		
		
		
		
		
		//Process PartnerLinks WSDL
		List pls=null;
		try {
		pls=getPartnerLinkWSDLs(partnerLinks);
		} catch (Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		
//		Process BPELs WSDL 
		Definition bpelDef=null;
		try {		
			bpelDef=pdn.bee.utils.WSDLUtils.loadWSDLDefinition(procDef);
			wsdlProc.retrieveSchemaTypes(bpelDef, messageTypes,allschemaTypes);
			//wsdlProc.retrieveSchemaTypes(, bproc.getMessagePartsOMElementMap(),bproc.getSchemaTypes());
		} catch (Exception e)
		{
			
			e.printStackTrace();
			return null;
		}
		
        bproc=BPELProcessFactory.getInstance().createBPELProcess(bpelfile);		
		bproc.setSync(true); //not defaults
		
		bproc.setMessagePartsOMElementMap(this.messageTypes);
		bproc.setSchemaTypes(this.allschemaTypes);
		bproc.setPartnerWSDL(pls);
		bproc.setDefinition(bpelDef);
		bproc.setPartnerWSDL(pls);
		
		return bproc;
	}
	
	/*private Definition getProcessDefinition(String defWSDLFile) throws Exception
	{
		Definition def=null;
		DocumentBuilderFactory fac=DocumentBuilderFactory.newInstance();
		Document doc=null;
		
		 DocumentBuilder builder=fac.newDocumentBuilder();
		 doc=builder.parse(defWSDLFile);
		 
		 def=wsdlreader.readWSDL(null, defWSDLFile);
			
		return def;
	}*/
	
	private List getPartnerLinkWSDLs(String partnerLinksWSDL[]) throws Exception
	{
		//Document doc=null;
		Definition def=null;
		List partnerLinks=new ArrayList();
		//DocumentBuilderFactory fac=DocumentBuilderFactory.newInstance();
		//DocumentBuilder builder=fac.newDocumentBuilder();
		String wsdlFile=null;
		
		for(int i=0;i<partnerLinksWSDL.length;i++)
		{
			wsdlFile=(String)partnerLinksWSDL[i];
			System.out.println("WSDL:"+wsdlFile+" SIZE:"+partnerLinksWSDL.length);
			//TODO WSDLProcessor should come here
			//wsdlProc.retrieveSchemaTypes(wsdlFile, bproc.getMessagePartsOMElementMap(),bproc.getSchemaTypes());
			
			def=pdn.bee.utils.WSDLUtils.loadWSDLDefinition(wsdlFile);
			wsdlProc.retrieveSchemaTypes(def, this.messageTypes,this.allschemaTypes);
			partnerLinks.add(def);
			
		}
	  return partnerLinks;
	}


}
