package pdn.bee.utils;

import javax.xml.namespace.QName;

public class BeeUtils {
	
	public static boolean stringYesNoToBoolean(String yesno)
	{
		if(yesno==null) return false;
		if(yesno.equalsIgnoreCase("YES")) 
			return true;
		else
			return false;
	}
	
	public static QName stringToQName(String nsnlocalpart)
	{
		QName qqn=null;
		if(nsnlocalpart==null) return new QName("","");
		String parts[]=nsnlocalpart.split(":");
		if(parts.length==1)
		{
			qqn=new QName("",parts[0],"");
			
		}
		else
		{
			qqn=new QName("",parts[1],parts[0]);
		}
		
		return qqn;
	}
	public static boolean stringNullOrEmply(String str)
	{
	 if(str==null || str.equals("")) return true;
	 else
		 return false;
	}
}
