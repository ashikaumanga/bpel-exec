/**
 * 
 */
package pdn.bee.core;


import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.wsdl.Binding;
import javax.wsdl.Definition;
import javax.wsdl.Port;
import javax.wsdl.extensions.ExtensibilityElement;
import javax.wsdl.extensions.soap.SOAPAddress;
import javax.xml.namespace.QName;

import org.apache.axiom.om.*;
import org.apache.commons.logging.Log;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import javax.xml.namespace.QName;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.activity.Assign;
import pdn.bee.model.bpel11.activity.Flow;
import pdn.bee.model.bpel11.activity.Invoke;
import pdn.bee.model.bpel11.activity.Recieve;
import pdn.bee.model.bpel11.activity.Reply;
import pdn.bee.model.bpel11.activity.Sequence;
import pdn.bee.model.bpel11.activity.Switch;
import pdn.bee.model.bpel11.elements.Case;
import pdn.bee.model.bpel11.elements.Copy;
import pdn.bee.model.bpel11.elements.From;
import pdn.bee.model.bpel11.elements.Link;
import pdn.bee.model.bpel11.elements.Links;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.PartnerLinks;
import pdn.bee.model.bpel11.elements.Source;
import pdn.bee.model.bpel11.elements.Target;
import pdn.bee.model.bpel11.elements.To;
import pdn.bee.model.bpel11.elements.Variable;
import pdn.bee.model.bpel11.elements.Variables;
import pdn.bee.model.bpel11.elements.While;
import pdn.bee.model.bpel11.process.BPELProcess;
import pdn.bee.model.bpel11.process.Process;
import org.apache.commons.logging.LogFactory;

import com.ibm.wsdl.extensions.soap12.SOAP12AddressImpl;
import javax.wsdl.extensions.soap12.SOAP12Address;
import javax.wsdl.extensions.soap.SOAPAddress;

/**
 * @author umanga
 *
 */
//private interface CommonSOAPAddress implements javax.wsdl.extensions.soap.SOAPAddress,
//javax.wsdl.extensions.soap12.SOAP12Address {}
public class ProcessEngineImpl implements ProcessEngine {

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.process.Process, pdn.bee.core.ProcessInstance)
	 */
	
	private Log logger= LogFactory.getLog(this.getClass());
		
	public void process(Process process, ProcessInstance instance)
			throws Exception {
		// 
		logger.info("Processing <process> ");
		PartnerLinks plinks=process.getPartnerLinks();
		if(plinks==null)
		{
			throw new Exception("No Partnerlinks");
		}
		plinks.accept(this, instance);
		
		Variables vars=process.getVariables();
		if(plinks==null)
		{
			throw new Exception("No Variables");
		}
		vars.accept(this, instance);
		
		Activity rootactivity=process.getActivity();
		if(rootactivity==null)
		{
			throw new Exception("No Root Activity");
		}
		
		
		rootactivity.accept(this, instance);
		//System.out.println("END OF PROCESS");
		//instance.getContext().notifyAll();
	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.PartnerLinks, pdn.bee.core.ProcessInstance)
	 */
	public void process(PartnerLinks plinks, ProcessInstance instance)
			throws Exception {
		// 
		logger.info("Process <parnterlinks>");
		List ptlinks =plinks.getPartnerLinks();
		for(int i=0;i<ptlinks.size();i++)
		{
			PartnerLink pl=(PartnerLink)ptlinks.get(i);
			pl.accept(this, instance);
		}

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.PartnerLink, pdn.bee.core.ProcessInstance)
	 */
	public void process(PartnerLink plink, ProcessInstance instance)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("  Processing <partnerlink>:"+plink.getName());

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.Variables, pdn.bee.core.ProcessInstance)
	 */
	public void process(Variables vars, ProcessInstance instance)
			throws Exception {
		// 
		logger.info("Processing <variables>");
		List v=vars.getVariables();
		if(v!=null)
		for(int i=0;i<v.size();i++)
		{
			Variable var=(Variable)v.get(i);
			var.accept(this, instance);
		}
	

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.Variable, pdn.bee.core.ProcessInstance)
	 */
	public void process(Variable var, ProcessInstance instance)
			throws Exception {
		// 
		logger.info("Instantiating <variable> "+var.getName());
		/*OMFactory fac= OMAbstractFactory.getOMFactory();
		String nspace=var.getMessageType().getNamespaceURI();
		System.out.println("variale ns:"+var.getMessageType());
		OMNamespace ns= fac.createOMNamespace("", nspace);
		OMElement omvar=fac.createOMElement(var.getMessageType().getLocalPart(),ns);
		instance.getContext().addVariable(var.getName(), omvar);*/
		
		Map msgtypes=instance.getProcess().getMessagePartsOMElementMap();
		
		Hashtable varparts=(Hashtable)msgtypes.get(var.getMessageType().getLocalPart());
		//System.out.println("PROCESS.VARIABLE msgtypes"+msgtypes);
		if(varparts==null) return;
	    java.util.Iterator keys=varparts.keySet().iterator();
	   // System.out.println(var.getMessageType().getNamespaceURI());
	    Hashtable varobjmap=new Hashtable();
	    OMElement varobj=null;
	    OMElement varclass=null;
	    
	    while(keys.hasNext())
	    {
	    	String keyname=(String)keys.next();
	    	varclass=(OMElement)varparts.get(keyname);
	    	varobj=varclass.cloneOMElement(); //clone variable from template
	    	varobjmap.put(keyname, varclass);
	    }
		//System.out.println("PRCESS.VARIABEL var name: "+var.getName()+" MAP "+keys);
		instance.getContext().addVariable(var,varobjmap);
		

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.activity.Sequence, pdn.bee.core.ProcessInstance)
	 */
	public void process(Sequence seq, ProcessInstance instance)
			throws Exception {
		// 
		logger.info("Processing <sequence>");
		List acts=seq.getActivities();
		if(acts!=null)
			for(int i=0;i<acts.size();i++)
			{
				Activity act=(Activity)acts.get(i);
				act.accept(this, instance);
			}
			
		

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.activity.Flow, pdn.bee.core.ProcessInstance)
	 */
	public void process(Flow flow, ProcessInstance instance) throws Exception {
		// Create threas for each activity and run them independently
		logger.info("Processing <flow>");
		List acts=flow.getActivities();
		if(acts.size()>0)
		{
		 Thread threads[]=new Thread[acts.size()]; //create thread for each activity
		 
		 for(int i=0;i<acts.size();i++) //assign activity and run the thread
		 {
			 Activity act=(Activity)acts.get(i);
			 threads[i]=new FlowActivity(this,instance,act);
			 threads[i].start();
		 }
		
		 //wait untils all acitivities are finished
		 for(int i=0;i<acts.size();i++)
			 threads[i].join();
		
		}

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.activity.Recieve, pdn.bee.core.ProcessInstance)
	 */
	public void process(Recieve rec, ProcessInstance instance) throws Exception {
		
        logger.info(rec);	
        java.util.Hashtable wsdlMsgParts=instance.getContext().getMessage().getInputWSDLMessage();
       
        Variable toVar=rec.getVarible();
        // String toPart=toVar.get
        Hashtable toParts=(Hashtable)instance.getContext().getVariable(toVar);
    	instance.getContext().addVariable(toVar,wsdlMsgParts);     	
           	  
    	    
        
	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.activity.Reply, pdn.bee.core.ProcessInstance)
	 */
	public void process(Reply reply, ProcessInstance instance) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.Links, pdn.bee.core.ProcessInstance)
	 */
	public void process(Links links, ProcessInstance instance) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.Link, pdn.bee.core.ProcessInstance)
	 */
	public void process(Link link, ProcessInstance instance) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.activity.Assign, pdn.bee.core.ProcessInstance)
	 */
	public void process(Assign assign, ProcessInstance instance) throws Exception
			{
		// 
        logger.info("<Assign>");
		Iterator allcopy=assign.getAllCopy().iterator();
        Copy copy=null;
        To to=null;
        From from=null;
        while (allcopy.hasNext())
        {
        	copy=(Copy)allcopy.next();
        	from=copy.getFrom();
        	to=copy.getTo();        			
            //System.out.println(from+" "+to);
        	assignVariables(from, to, instance);
        	/*
        	Variable fromVar=from.getVariable();
        	String fromPart=from.getPart();
        	
        	Variable toVar=to.getVariable();
        	String toPart=to.getPart();
        	
        	Hashtable fromParts=(Hashtable)instance.getContext().getVariable(fromVar);
        	Hashtable toParts=(Hashtable)instance.getContext().getVariable(toVar);
        	if(fromParts==null)
        	  throw new Exception("variable "+fromVar.getName()+" not found");
        	  
        	if(toParts==null)
        	  throw new Exception("variable "+toVar.getName()+" not found");
        	  
        	  
        	if(!fromParts.contains(fromPart))       	
        		throw new Exception("part not found in From var");
        	
        	if(!toParts.contains(toPart))
        	    throw new Exception("part not found in To var");
        	    
        	    
        	    OMElement sourceOM=((OMElement)fromParts.get(fromPart)).cloneOMElement();
        	    toParts.put(toPart, sourceOM);
        	    
        	    
        	*/
        	
        	
        	
        	//System.out.println("COPY "+copy);
        }

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.Copy, pdn.bee.core.ProcessInstance)
	 */
	public void process(Copy copy, ProcessInstance instance) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.From, pdn.bee.core.ProcessInstance)
	 */
	public void process(From from, ProcessInstance instance) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.To, pdn.bee.core.ProcessInstance)
	 */
	public void process(To to, ProcessInstance instance) throws Exception {
		// TODO Auto-generated method stub
		

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.Source, pdn.bee.core.ProcessInstance)
	 */
	public void process(Source source, ProcessInstance instance)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.activity.Switch, pdn.bee.core.ProcessInstance)
	 */
	public void process(Switch aswitch, ProcessInstance instance)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.Case, pdn.bee.core.ProcessInstance)
	 */
	public void process(Case acase, ProcessInstance instance) throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.activity.Invoke, pdn.bee.core.ProcessInstance)
	 */
	public void process(Invoke invoke, ProcessInstance instance)
			throws Exception {
	   logger.info("Invoking partnerlink "+invoke.getPartnerLink().getName()+ " operation "+invoke.getOperation());
       Variable invar=invoke.getInputVariable();
       Variable outvar=invoke.getOutputVariable();
       Hashtable varparts=(Hashtable)instance.getContext().getVariable(invar);
       
       OMElement payload=(OMElement)varparts.values().iterator().next();
       String operation=invoke.getOperation();
        //operation.
       
       
       QName porttype=invoke.getPortType();
       
       
       Definition def=findWSDL(porttype, instance.getProcess());
       Binding binding=findBinding(def,porttype);
       javax.wsdl.Port port=this.findPort(def, binding);
       Object soapaddr=this.findSOAPAddress(port);
       String epr=null; //=soapaddr.getLocationURI();
       SOAPAddress sa1;
       SOAP12Address sa2;
       
       //System.out.println(operation+ " ***  "+porttype.getLocalPart() +port);
       if (soapaddr instanceof SOAPAddress) 
       {   sa1 =( SOAPAddress)soapaddr;
       epr=sa1.getLocationURI();
         }
       else if(soapaddr instanceof SOAP12Address)
       {         sa2=(SOAP12Address)soapaddr;
       epr=sa2.getLocationURI();
       }
        
     
      	int n1=epr.indexOf("9090");
      	if(n1>0) {
      	String bp=(epr.substring(n1+4));
      	String ap=(epr.substring(0, n1));
      	String eprn=ap+"8080"+bp;
      	epr=eprn;}
      	
          
	                 	
       
       System.out.println("Invkoing service at "+ epr+" with payload: "+payload );
       
       //Call the service using dynamic invocation
       Options options = new Options();
       options.setTo(new EndpointReference(epr));
      
       options.setAction("urn:"+operation);
       ServiceClient sender = new ServiceClient();
       sender.setOptions(options);
       OMElement result = sender.sendReceive(payload);
       
       System.out.println("recieve OMElement :"+result );
      
       //TODO assign to output varialbes
       
       if(outvar==null) return;
        String soutvar=outvar.getName();
        //TODO not good , improvethis
        
        Hashtable outvarparts=(Hashtable)instance.getContext().getVariable(outvar);
        
        String outvarpart=(String) outvarparts.keySet().iterator().next();
        outvarparts.put(outvarpart, result);
        
        //System.out.println("Output variable part:"+outvarpart);
        //System.out.println(outvarparts.get("part1"));
       
       

	}
    
	public void assignVariables(From from,To to,ProcessInstance instance) throws Exception
	{
		//System.out.println(from+" "+to);
		Variable fromVar=from.getVariable();
    	String fromPart=from.getPart();
    	
    	Variable toVar=to.getVariable();
    	String toPart=to.getPart();
    			
    	Hashtable fromParts=(Hashtable)instance.getContext().getVariable(fromVar);
    	Hashtable toParts=(Hashtable)instance.getContext().getVariable(toVar);
    	if(fromParts==null)
    	  throw new Exception("variable "+fromVar.getName()+" not found");
    	  
    	if(toParts==null)
    	  throw new Exception("variable "+toVar.getName()+" not found");
    	 
    	
    	 
    	if(!fromParts.containsKey(fromPart))       	
    		throw new Exception("part not found in From var");
    	
    	if(!toParts.containsKey(toPart))
    	    throw new Exception("part not found in To var");
    	    
    	    
    	    OMElement sourceOM=((OMElement)fromParts.get(fromPart)).cloneOMElement();
    	    System.out.println("ASSIGN SOURCE OM"+sourceOM);
    	    toParts.put(toPart, sourceOM);
	}
	/* (non-Javadoc)
 	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.While, pdn.bee.core.ProcessInstance)
	 */
	public void process(While awhile, ProcessInstance instance)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#process(pdn.bee.model.bpel11.elements.Target, pdn.bee.core.ProcessInstance)
	 */
	public void process(Target target, ProcessInstance instance)
			throws Exception {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see pdn.bee.core.ProcessEngine#processMessage(pdn.bee.core.BeeEngineMessage, pdn.bee.core.ProcessInstance)
	 */
	public void processMessage(BeeEngineMessage msg, ProcessInstance instance)
			throws Exception {
		// TODO Auto-generated method stub

	}
	
	
	//traverse through partnerlink WSDLs and look for required Definition
	private Definition findWSDL(QName PortTypeName, BPELProcess bproc)
	{
		Binding binding=null;
		Definition def=null;
		
		Collection wsdls=bproc.getPartnerWDSL();
		
		mainloop:
			for(Iterator iterator=wsdls.iterator();iterator.hasNext();)
			{ //loop for definitions
				def=(Definition)iterator.next();
				Collection bindings=def.getBindings().values();
				
				for(Iterator it2=bindings.iterator();it2.hasNext();)
				{//loop for bindings
					binding=(Binding)it2.next();
				
			//	System.out.println("**"+binding.getPortType().getQName().getNamespaceURI()+
				//		" "+PortTypeName.getNamespaceURI()+"***");
					if (binding.getPortType().getQName().equals(PortTypeName))
						{break mainloop;}
				}
				
			}
		
		
		return def;
	}
	
	private Binding findBinding(Definition def,QName PTName)
	{
		Collection bindings=def.getBindings().values();
		Binding binding=null;
		for(Iterator it2=bindings.iterator();it2.hasNext();)
		{//loop for bindings
			binding=(Binding)it2.next();
			
			if (binding.getPortType().getQName().equals(PTName))
				break;
		}
		return binding;
	}
	
	private Port findPort(Definition definition, Binding binding) {

        Port port = null;

        Collection services = definition.getServices().values();
        for (Iterator iterator = services.iterator(); iterator.hasNext();) {
            javax.wsdl.Service service = (javax.wsdl.Service) iterator.next();
            Collection portTypes = service.getPorts().values();
            for (Iterator iter2 = portTypes.iterator(); iter2.hasNext();) {
                port = (Port) iter2.next();
                if (port.getBinding().equals(binding)) {
                    break;
                }
            }
        }
        return port;
    }
	
	 private Object findSOAPAddress(Port port) {

	        SOAPAddress soapAddress = null;
	        Object sa=null;
	        // find and return the location
	        //
	        Collection extElems = port.getExtensibilityElements();
	        
	        for (Iterator iter = extElems.iterator(); iter.hasNext();) {
	            ExtensibilityElement element = (ExtensibilityElement) iter.next();
	               
	            if (element instanceof SOAPAddress || 
	              element instanceof SOAP12Address) {        	
	                 	sa = element;
	                    
	               
	                break;
	            }
	        }
	       // System.out.println(sa);
	        return sa;
	    }
	
}
