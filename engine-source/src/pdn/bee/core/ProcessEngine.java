package pdn.bee.core;

import pdn.bee.model.bpel11.activity.Assign;
import pdn.bee.model.bpel11.activity.Flow;
import pdn.bee.model.bpel11.activity.Invoke;
import pdn.bee.model.bpel11.activity.Recieve;
import pdn.bee.model.bpel11.activity.Reply;
import pdn.bee.model.bpel11.activity.Sequence;
import pdn.bee.model.bpel11.activity.Switch;
import pdn.bee.model.bpel11.elements.Case;
import pdn.bee.model.bpel11.elements.Copy;
import pdn.bee.model.bpel11.elements.From;
import pdn.bee.model.bpel11.elements.Link;
import pdn.bee.model.bpel11.elements.Links;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.PartnerLinks;
import pdn.bee.model.bpel11.elements.Source;
import pdn.bee.model.bpel11.elements.Target;
import pdn.bee.model.bpel11.elements.To;
import pdn.bee.model.bpel11.elements.Variable;
import pdn.bee.model.bpel11.elements.Variables;
import pdn.bee.model.bpel11.elements.While;
import pdn.bee.model.bpel11.process.Process;

public interface ProcessEngine {
	
	public void processMessage(BeeEngineMessage msg,ProcessInstance instance) throws Exception;
	public void process(Process process,ProcessInstance instance) throws Exception;
	public void process(PartnerLinks plinks,ProcessInstance instance) throws Exception;
	public void process(PartnerLink plinks,ProcessInstance instance) throws Exception;
	public void process(Variables vars,ProcessInstance instance) throws Exception;
	public void process(Variable var,ProcessInstance instance) throws Exception;
	public void process(Sequence seq,ProcessInstance instance) throws Exception;
	public void process(Flow flow,ProcessInstance instance) throws Exception;
	public void process(Recieve rec,ProcessInstance instance) throws Exception;
	public void process(Reply reply,ProcessInstance instance) throws Exception;
	public void process(Links links,ProcessInstance instance) throws Exception;
	public void process(Link link,ProcessInstance instance) throws Exception;
	public void process(Assign assign,ProcessInstance instance) throws Exception;
	public void process(Copy copy,ProcessInstance instance) throws Exception;
	public void process(From from,ProcessInstance instance) throws Exception;
	public void process(To to,ProcessInstance instance) throws Exception;
	public void process(Source source,ProcessInstance instance) throws Exception;
	public void process(Switch aswitch,ProcessInstance instance) throws Exception;
	public void process(Case acase,ProcessInstance instance) throws Exception;
	public void process(Invoke invoke,ProcessInstance instance) throws Exception;
	public void process(While awhile,ProcessInstance instance) throws Exception;
	public void process(Target target,ProcessInstance instance) throws Exception;
	
	
	
}
