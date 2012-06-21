/**
 * 
 */
package pdn.bee.core;

import pdn.bee.model.bpel11.process.BPELProcess;
import pdn.bee.model.bpel11.process.impl.BPELProcessImpl;

/**
 * @author umanga
 *
 */
public class ProcessInstance {
	
	private BPELProcess bpelprocess;
	private ProcessContext context;
	
	public ProcessInstance()
	{
		//elprocess=new BPELProcessImpl();
		context= new ProcessContext();
		
	}
	public void setProcess(BPELProcess process)
	{
		bpelprocess=process;
	}
	public BPELProcess getProcess()
	{
		return bpelprocess;
	}
	
	public void setContext(ProcessContext context)
	{
		this.context=context;
	}
	public ProcessContext getContext()
	{
		return this.context;
	}

}
