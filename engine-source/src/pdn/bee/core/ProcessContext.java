package pdn.bee.core;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import pdn.bee.model.bpel11.activity.Activity;

public class ProcessContext {
	
	private Map activities;
	public Map variables;
	private Object result;
	private BeeEngineMessage message;
	
	public ProcessContext()
	{
		activities=new Hashtable();
		variables=new Hashtable();		
	}
	
	public void addVariable(Object var,Object value)
	{
		variables.put(var, value);
	}
	
	public Object getVariable(Object var)
	{
		return variables.get(var);
	}
	public void addActivity(Activity act)
	{
		activities.put(act.getName(), act);
	}
	
	public Activity getActity(Object key)
	{
		return (Activity)activities.get(key);
	}

	public BeeEngineMessage getMessage() {
		return message;
	}

	public void setMessage(BeeEngineMessage message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

}
   