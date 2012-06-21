package pdn.bee.utils;

import javax.wsdl.Definition;
import javax.wsdl.factory.WSDLFactory;
import javax.wsdl.xml.WSDLReader;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WSDLUtils {
	//private static Log logger= LogFactory.getLog(this.getClass());
	public static Definition loadWSDLDefinition(String wsdlURI)
	{
		Definition def=null;
		if(wsdlURI==null) { 
		//.error("No WSDL file defined ");
		return null;
		}		
		
		WSDLFactory factory=null;
		WSDLReader reader =null;
		
		try
		{
		 factory = WSDLFactory.newInstance();
		 reader = factory.newWSDLReader();
		 reader.setFeature("javax.wsdl.verbose", true);
	     reader.setFeature("javax.wsdl.importDocuments", true);
	     def=reader.readWSDL(wsdlURI);
	     //return def;
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return def;
		
	}
	
}
