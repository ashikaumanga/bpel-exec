/**
 * 
 */
package pdn.bee.model.bpel11.activity.impl;
import java.util.List;

import pdn.bee.model.bpel11.activity.Activity;
import pdn.bee.model.bpel11.elements.Source;
import pdn.bee.model.bpel11.elements.Target;
import pdn.bee.model.bpel11.expression.BooleanExpression;
import pdn.bee.model.bpel11.expression.impl.BooleanExpressionImpl;
import pdn.bee.utils.BeeUtils;
/**
 * @author umanga
 *
 */
public abstract class ActivityImpl implements Activity{

	private List sources=null;
	private List targets=null;
	private String name;
	private BooleanExpression joinCondition=null;
	private boolean suppressJoinFailure;
	public ActivityImpl()
	{
	sources = new  java.util.ArrayList();
	targets= new java.util.ArrayList();
	
	}
	public ActivityImpl(String name,String joincond,String suppressjoin)
	{
		this();
		this.setName(name);
		if(!BeeUtils.stringYesNoToBoolean(joincond))
		{
			BooleanExpression be=new BooleanExpressionImpl();
			be.setExpression(joincond);
			this.setJoinCondition(be);
			
		}
		this.setSuppressJoinFailure(BeeUtils.stringYesNoToBoolean(suppressjoin));
		
	}
	
	public void addSource(Source source) {
		
		sources.add(source);
	}

	public void addTarget(Target target) {
		
		targets.add(target);
		
	}

	public BooleanExpression getJoinCondiion() {
		
		return joinCondition;
	}

	public String getName() {
		
		return name;
	}

	public List getSources() {
		
		return sources;
	}

	public boolean getSuppressJoinFailure() {
		
		return suppressJoinFailure;
	}

	public List getTargets() {
		
		return targets;
	}

	public void setJoinCondition(BooleanExpression boolexp) {
		
		this.joinCondition=boolexp;
		
	}

	public void setName(String name) {
		
		this.name=name;
		
	}

	public void setSources(List sources) {
		this.sources=sources;
		
	}

	public void setSuppressJoinFailure(boolean joinfail) {
		this.suppressJoinFailure=joinfail;
		
	}

	public void setTargets(List targets) {
		this.targets=targets;
		
		
	}
	
	
	
	

}
