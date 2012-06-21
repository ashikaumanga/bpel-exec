package pdn.bee.loader;

import java.util.Iterator;
import java.util.Map;

import javax.wsdl.Definition;
import javax.wsdl.Message;
import javax.wsdl.Part;
import javax.wsdl.WSDLException;
import javax.wsdl.extensions.schema.Schema;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;
import javax.xml.namespace.QName;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;



public class WSDLProcessor {
	
	private Map tmpNameAndType ;
	private Map messageNTypeMap;
	

	private Log logger= LogFactory.getLog(this.getClass());
	
	public  void retrieveSchemaTypes(Definition def,Map messagePartsTypeMap,Map allTypesMap)
	{
		
		
		//Definition def=pdn.bee.utils.WSDLUtils.loadWSDLDefinition(wsdlURI);
		this.tmpNameAndType=allTypesMap;
		this.messageNTypeMap=messagePartsTypeMap;
		  retrieveAll(def);
		  Map msgs=def.getMessages();
		  Iterator msgIterator = msgs.values().iterator();
		  
		  Map messageParts; //map for store part of a message
		  
		  //Loop for every message
		  while (msgIterator.hasNext())
		  {
		      Message msg = (Message)msgIterator.next();
		      if (!msg.isUndefined())
		      {
		    	  
		    	 Map parts=msg.getParts();
		    	 //logger.info(" "msg.getQName().getLocalPart());
		    	 //process Parts
		    	    Iterator partsIte=parts.values().iterator();
		    	    
		    	    messageParts=new java.util.Hashtable();
		    	    
		    	    //Loop for every Part
		    	    while (partsIte.hasNext())
		    	    {
		    	    	Part part=(Part)partsIte.next();
	    	    	    QName partElement =part.getElementName();
		    	    	
	    	    	    OMElement om=null;
	    	    	    if (partElement==null) 
	    	    	    	partElement=part.getTypeName();
	    	    	    
		    	  	if(XSDConstants.isInSimpleTypes(partElement)) //if its a simple type
		    	    	{
		    	    	 	//
		    	  		System.out.println("simple");
		    	    		OMFactory omFac= OMAbstractFactory.getOMFactory();
		    	        	org.apache.axiom.om.OMNamespace ns=omFac.createOMNamespace(partElement.getNamespaceURI(), null);
		    	        	om=omFac.createOMElement(part.getName()  , ns);
		    	    		
		    	    		
		    	    	} else //if its not a simple type
		    	    	{
		    	    		System.out.println("complex");
		    	    		om=(OMElement)tmpNameAndType.get(partElement);
		    	    		//System.out.println("ALLTYPESSSS:"+tmpNameAndType);
		    	    	}
	    	    	    
		    	    	//System.out.println(XSDConstants.isInSimpleTypes(partElement) );
		    	    	//OMElement om2=om.cloneOMElement();
		    	    	//org.apache.axiom.om.OMAbstractFactory a;
		    	   // System.out.println("MSGPARTS"+messageParts+" var "+part.getName()+" pe "+partElement);	
		    	  	
		    	  	messageParts.put(part.getName() , om);
		    	    	
		    	    }
		    	   
		    	 //end of processing Parts		    	    
		    	    System.out.println("BEFORE **** MSGPARTS"+messageNTypeMap);
		    	    if(!messageNTypeMap.containsKey(msg.getQName().getLocalPart()))
		    	    messageNTypeMap.put(msg.getQName().getLocalPart(), messageParts);
		    	    //System.out.println("AFTER **** MSGPARTS"+messageNTypeMap);
		       
		      }
		  
		  }
		
		
	}
	
	
   private void retrieveAll(Definition def)
	{
		//Definition def = reader.readWSDL(null, "sample.wsdl");
		
		
		javax.wsdl.Types types=def.getTypes();
		if(types==null) return;
		
		Schema sch=(Schema) def.getTypes().getExtensibilityElements().get(0);
		Element elm=sch.getElement();
		String tns=sch.getElement().getAttribute("targetNamespace");
		
		NodeList nl=elm.getChildNodes();		
		Element elmnt;
		nsInc++;
		for(int i=0;i<nl.getLength();i++)
		{
			
			if (checkElementName(nl.item(i), "element" ))
			{
				elmnt=(Element)(nl.item(i));
								
				OMElement omm=	createOMFromSchema((Element)nl.item(i),tns);
								
				QName qname=new QName(tns,elmnt.getAttribute("name"));//omm.getNamespace().getPrefix());				
				
				tmpNameAndType.put(qname, omm);	
				
				
			}
			
		}
		
		
		
			
		
	}
    
	/*  
	/@see check the Nodes name with given string
	*/
	private boolean checkElementName(Node node,String name)
	{
	 String ename=node.getLocalName();
	 if (ename==null) return false;
	 if (ename.toLowerCase().equals(name))
	  return true;
	  else 
     return false;
	}
	
	
	/*
	 *create OMElemeny node according to the structure of schema
	 */
	private static int nsInc;
	public OMElement createOMFromSchema(Element elmnt,String namespace)
      {
    	//    	
		String OMRootName=elmnt.getAttributeNS(null,"name");
    	
    	OMFactory omFac= OMAbstractFactory.getOMFactory();
    	OMNamespace ns=omFac.createOMNamespace(namespace, "myns"+nsInc);
    	OMElement OMRoot=omFac.createOMElement(OMRootName, ns);
		
		Element seq=null;
    	  if(elmnt.hasChildNodes()==false) //no child elements
    	  {
    	   // TODO if this referes another type...
    	   return OMRoot;
    	  }
    	  seq=this.findFirstChildElement(elmnt, "complextype");
    	  if (seq==null) return null;
    	  seq=this.findFirstChildElement(seq, "sequence");
    	  
    	  NodeList childList=seq.getChildNodes();
    	  
    	  for(int i=0;i<childList.getLength();i++)
    	  {
    		  Node childNode=childList.item(i);
    		  OMElement OMChildNode=null;
    		  if (this.checkElementName(childNode, "element"))//ok this is element
    		  {
    			Element childE = (Element)childNode;
    			String partName=childE.getAttributeNS(null, "name");
    			
    			OMChildNode=omFac.createOMElement(partName, ns);
    			OMRoot.addChild(OMChildNode);
    			
    		  }
    	  }             
    	    	  
    	  return OMRoot;
      }
	
	private Element findFirstChildElement(Element elt,String childname)
	{
	  Element retval=null;
	     NodeList list=elt.getChildNodes();
	     for(int i=0;i<list.getLength();i++)
	     {
	    	 Node node=list.item(i);
	    	 if (this.checkElementName(node, childname))
	    	 {
	    		return (Element)node; 
	    	 }
	     }
	  return retval;
	}

}
