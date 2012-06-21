package pdn.bee.loader;

import javax.xml.namespace.QName;
import java.util.List;


public class XSDConstants {
	//"http://www.w3.org/2001/XMLSchema";
    private static XSDConstants me=null;
	public static List xsd=new java.util.ArrayList();
    
	public static final String URI_DEFAULT_SCHEMA_XSD = "http://www.w3.org/2001/XMLSchema";
	
    XSDConstants()
    {
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "string")); 
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "boolean"));
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "double"));
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "float"));
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "int"));
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "integer"));
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "long"));
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "long"));
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "short"));
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "byte"));
    	xsd.add(new QName(URI_DEFAULT_SCHEMA_XSD, "decimal"));
    	
    }
    public static boolean isInSimpleTypes(QName xsdelement)
    {
    	if(me==null)
    		me=new XSDConstants();
    	return xsd.contains(xsdelement);
    	
    }
   
    
}
