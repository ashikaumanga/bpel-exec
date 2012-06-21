package pdn.bee.test;

import java.util.Hashtable;
import java.util.List;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;

import pdn.bee.core.BeeEngineMessage;
import pdn.bee.core.Dispatcher;
import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessEngineImpl;
import pdn.bee.loader.WSDLProcessor;
import pdn.bee.model.bpel11.process.Process;

public class Test2 {
	
	
	public static void main(String al[])
	{

		
		
		 //create the input WSDL Message for BEE Message
		Hashtable msg=new Hashtable();
		
		setPayload2(msg);
		BeeEngineMessage BeeMsg=new BeeEngineMessage();
		BeeMsg.setInputWSDLMessage(msg);
		BeeMsg.setService("orderService");
		
		//Create a new instance of Dispatcher with created Bee Engine Message
		Dispatcher dispatcher=new Dispatcher(BeeMsg);
		try {
		Object result=dispatcher.dispatch();
		System.out.println("Result:"+result);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		
		System.out.println();
	}
   
	
	public static void setPayload2(Hashtable msg)
   {
	   OMFactory fac = OMAbstractFactory.getOMFactory();
       
	   
	   OMNamespace omNs = fac.createOMNamespace(
	       		"http://service.bee.pdn/xsd", "ns0");
	   
       OMElement crd = fac.createOMElement("getCreditLimit", omNs);        
       OMElement userid=fac.createOMElement("userid",omNs);
       //OMElement param1=fac.createOMElement("param1", null);
       userid.setText("umanga");
       
       OMElement inv = fac.createOMElement("getItemPrice", omNs);        
       OMElement invid=fac.createOMElement("itemId",omNs);
       //OMElement param1=fac.createOMElement("param1", null);
       invid.setText("benz");
       
       inv.addChild(invid);
       
       crd.addChild(userid);
       
       
       msg.put("part1",crd); 
       msg.put("part2",inv);
   }
   public static void setPayload1(Hashtable msg)
   {
	   OMFactory fac = OMAbstractFactory.getOMFactory();
       OMNamespace omNs = fac.createOMNamespace(
       		"http://ws.apache.org/axis2/xsd", "ns0");
       OMElement add = fac.createOMElement("add", omNs);        
       OMElement param0=fac.createOMElement("param0",null);
       OMElement param1=fac.createOMElement("param1", null);
       param0.setText("8");
       param1.setText("9");
       add.addChild(param0);
       add.addChild(param1);
       
       msg.put("part1", add);  
   }
}
