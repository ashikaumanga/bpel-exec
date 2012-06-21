package pdn.bee.binder;

import java.io.FileInputStream;

import org.apache.commons.digester.xmlrules.DigesterLoader;

import pdn.bee.model.bpel11.process.BPELProcess;
import pdn.bee.model.bpel11.process.impl.BPELProcessImpl;

public class BPELProcessFactory {
	private static BPELProcessFactory factory=null;
	
	public static BPELProcessFactory getInstance()
	{
		if(factory==null)
			factory=new BPELProcessFactory();
		return factory;
	}
	
	public BPELProcess createBPELProcess(String bpelfile)
	{
		BPELProcess rootprocess=new BPELProcessImpl();
		BPELProcess bpelprocess=null;
		String bpelrules="pdn/bee/binder/rules.xml";
		java.net.URL rulesURI=this.getClass().getClassLoader().getResource(bpelrules);
		System.out.println(rulesURI);
		try {
		FileInputStream fis=new FileInputStream(bpelfile);
		
		bpelprocess=(BPELProcess)DigesterLoader.load(rulesURI, this.getClass().getClassLoader(), fis, rootprocess);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return bpelprocess;
		
	}
}
