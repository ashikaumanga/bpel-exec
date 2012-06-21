
package pdn.bee.test;

import pdn.bee.binder.BPELProcessFactory;
import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessEngineImpl;
import pdn.bee.model.bpel11.process.BPELProcess;
import pdn.bee.model.bpel11.process.Process;
import java.util.ArrayList;
import java.util.List;

import javax.wsdl.Definition;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

public class Test {
	private javax.wsdl.xml.WSDLReader wsdlreader=null;
	public static void main(String a[])
	{
		Test cl=new Test();
		cl.run();
	}
	public void run()
	{
	 //QName qn=pdn.bee.utils.BeeUtils.stringToQName("tns:TravelMsg");
	// System.out.println("local:"+qn.getLocalPart());
	// System.out.println("pre:"+qn.getPrefix());
	 
		//if(1==1) return;
		
		String bpelfile="/home/umanga/BookTravel.bpel";
	 BPELProcess bproc=null;
	 Process proc; //=bproc.getProcess();
	 String b[]=new String[1];
	 b[0]="/home/umanga/TravelService.wsdl";
	 bproc=deploy(bpelfile,"/home/umanga/BookTravel.wsdl",b);
	 bproc.setSync(true);
	 proc=bproc.getProcess();
	 pdn.bee.core.ProcessInstance theInstance=new pdn.bee.core.ProcessInstance();
	 theInstance.setProcess(bproc);
	 
	 ProcessEngine eng=new ProcessEngineImpl();
	 
	 try {
	 eng.process(bproc.getProcess(),theInstance );
	 
	 } catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	}
	
	public BPELProcess deploy(String bpelfile,String procDef,String partnerLinks[])
	{
		try {
		wsdlreader=javax.wsdl.factory.WSDLFactory.newInstance().newWSDLReader();
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		
		BPELProcess bproc=null;
		bproc=BPELProcessFactory.getInstance().createBPELProcess(bpelfile);
		
		bproc.setSync(true); //not defaults
		//set BPELPRocess's WSDL definition
		try {
		bproc.setDefinition(getProcessDefinition(procDef));
		} catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		//
		List pls=null;
		try {
		pls=getPartnerLinkWSDLs(partnerLinks);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		bproc.setPartnerWSDL(pls);
		return bproc;
	}
	
	
	private Definition getProcessDefinition(String defWSDLFile) throws Exception
	{
		Definition def=null;
		DocumentBuilderFactory fac=DocumentBuilderFactory.newInstance();
		Document doc=null;
		
		 DocumentBuilder builder=fac.newDocumentBuilder();
		 doc=builder.parse(defWSDLFile);
		 
		 def=wsdlreader.readWSDL(null, defWSDLFile);
			
		return def;
	}
	
	private List getPartnerLinkWSDLs(String partnerLinksWSDL[]) throws Exception
	{
		Document doc=null;
		Definition def=null;
		List partnerLinks=new ArrayList();
		DocumentBuilderFactory fac=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=fac.newDocumentBuilder();
		String wsdlFile=null;
		for(int i=0;i<partnerLinksWSDL.length;i++)
		{
			wsdlFile=(String)partnerLinksWSDL[i];
			doc=builder.parse(wsdlFile);
			def=wsdlreader.readWSDL(null,wsdlFile);
			partnerLinks.add(def);
			
		}
	  return partnerLinks;
	}

}
