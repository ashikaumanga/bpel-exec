package pdn.bee.core;


import pdn.bee.model.bpel11.process.BPELProcess;

//This is a thread,per every client request
public class Dispatcher extends Thread{

	protected pdn.bee.core.ProcessEngine engine;
	protected ProcessInstance instance;
	protected ProcessContext context;
	protected BPELProcess bproc;
	
	public Dispatcher(BeeEngineMessage beemsg)
	{
		//BPELProcess bproc=
		instance=new ProcessInstance();
		engine=new ProcessEngineImpl();
		bproc=getBPELProcess(beemsg);
	    instance.getContext().setMessage(beemsg);
	    instance.setProcess(bproc);
		
	}
	
	public Object dispatch() throws Exception
	{
		Object result=null;
		start();
        //System.out.println("END");
        // if we have a synchronous process, wait until result is available
      
           // synchronized (instance.getContext()) {
               // try {
                    // wait until the process has finished and get the result
                   // instance.getContext().wait();
                   result= instance.getContext().getResult();
                    
             //   } catch (InterruptedException e) {
            //        throw new Exception("Dispatcher interrupted", e);
            //    }
           
          //  }                        
            
        return result;
		
	}
	
	public void run()
	{
	
		try {
		engine.process(bproc.getProcess(), instance);
		
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	//LOAD the BPELPRocess from the persistance storage acan iuse DAO pattern
	private BPELProcess getBPELProcess(BeeEngineMessage beemsg)
	{
		pdn.bee.loader.Loader loader=new pdn.bee.loader.Loader();
		BPELProcess bproc=null;
		
		if(beemsg.getService().equals("numberService"))
		{
			String plinks[]={"http://localhost:8080/axis2/services/add?wsdl",
			"http://localhost:8080/axis2/services/CubeService?wsdl"};
			String bpelfile="/home/umanga/bpel/bpel1.bpel";
			String bpelwsdl="http://localhost:8080/axis2/services/guide1?wsdl";
			bproc=loader.loadFromIO
			(bpelfile ,
					bpelwsdl, 
				plinks) ; 
			
		} else if(beemsg.getService().equals("orderService"))
		{
		                String plinks[]={"http://localhost:9090/axis2/services/CreditService?wsdl",
						"http://localhost:9090/axis2/services/InventoryService?wsdl",
						"http://localhost:9090/axis2/services/BuyService?wsdl"};
							
						String bpelfile="/home/umanga/bpel/bpel2.bpel";
						String bpelwsdl="/home/umanga/bpel/Purchase.wsdl";
						bproc=loader.loadFromIO
						(bpelfile ,
								bpelwsdl, 
							plinks) ; 
						
		}
	return bproc;
	}
}
