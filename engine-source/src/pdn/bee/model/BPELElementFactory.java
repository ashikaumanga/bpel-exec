package pdn.bee.model;

import java.util.Hashtable;
import java.util.Map;

import javax.xml.namespace.QName;

import pdn.bee.model.bpel11.process.BPELProcess;
import pdn.bee.model.bpel11.process.Process;
import pdn.bee.model.bpel11.process.impl.ProcessImpl;
import pdn.bee.model.bpel11.activity.Assign;
import pdn.bee.model.bpel11.activity.Flow;
import pdn.bee.model.bpel11.activity.Invoke;
import pdn.bee.model.bpel11.activity.Recieve;
import pdn.bee.model.bpel11.activity.Reply;
import pdn.bee.model.bpel11.activity.Sequence;
import pdn.bee.model.bpel11.activity.Switch;
import pdn.bee.model.bpel11.activity.impl.ActivityImpl;
import pdn.bee.model.bpel11.activity.impl.AssignImpl;
import pdn.bee.model.bpel11.activity.impl.FlowImpl;
import pdn.bee.model.bpel11.activity.impl.InvokeImpl;
import pdn.bee.model.bpel11.activity.impl.RecieveImpl;
import pdn.bee.model.bpel11.activity.impl.ReplyImpl;
import pdn.bee.model.bpel11.activity.impl.SequenceImpl;
import pdn.bee.model.bpel11.activity.impl.SwitchImpl;
import pdn.bee.model.bpel11.elements.Case;
import pdn.bee.model.bpel11.elements.From;
import pdn.bee.model.bpel11.elements.PartnerLink;
import pdn.bee.model.bpel11.elements.Roles;
import pdn.bee.model.bpel11.elements.To;
import pdn.bee.model.bpel11.elements.Variable;
import pdn.bee.model.bpel11.elements.impl.FromImpl;
import pdn.bee.model.bpel11.elements.impl.RolesImpl;
import pdn.bee.model.bpel11.elements.impl.ToImpl;
import pdn.bee.utils.BeeUtils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BPELElementFactory {
	
	private static Map instances=new Hashtable();
	private Log logger=LogFactory.getFactory().getInstance(this.getClass());
   public static BPELElementFactory getInstance(BPELProcess bpelproc)
   {
	   BPELElementFactory fac=null;
	   fac=(BPELElementFactory)instances.get(bpelproc);
	   if(fac==null)
	   {
		   fac=new BPELElementFactory();
		   instances.put(bpelproc, fac);
	   }
	   return fac;
	   
   }
   private Map partnerlinks;
   private Map variables;
   private Map namespaces;
   
   public BPELElementFactory()
   {
	   partnerlinks=new Hashtable();
	   variables=new Hashtable();
	   namespaces=new Hashtable();
   }
   
   public Process createProcess(String name,String namespace,String querylang,String explang,String joinfail,String enblcompensation,String absractprocess,
		   Map namespaces   )
   {
	   Process proc=new ProcessImpl();
	   proc.setName(name);
	   proc.setTargetNamespace(namespace);
	   proc.setQueryLanguage(querylang);
	   proc.setExpressionLanguage(explang);
	   
	   proc.setIsSuppressJoinFailure(pdn.bee.utils.BeeUtils.stringYesNoToBoolean(joinfail));
	   proc.setIsEnableInstanceCompensation(pdn.bee.utils.BeeUtils.stringYesNoToBoolean( enblcompensation));
	   proc.setIsAbstractProcess(pdn.bee.utils.BeeUtils.stringYesNoToBoolean(absractprocess));
	   
	   if(namespaces!=null)
	   {
		   this.namespaces=namespaces;
	   } 
	    logger.debug("Binding process:"+name);    
	   return proc;
	   
   }
   
   public PartnerLink createParnerLink(String name,String pltype,String myrole,String partnerrole)
   {
	   PartnerLink pl=new pdn.bee.model.bpel11.elements.impl.PartnerLinkImpl();
	   pl.setName(name);
	   pl.setPartnerLinkType(pdn.bee.utils.BeeUtils.stringToQName(pltype));
	   pl.setMyRole(myrole);
	   pl.setPartnerRole(partnerrole);
	   
	   partnerlinks.put(name, pl);
	   logger.debug("Binding partnerlink:"+name);
	   return pl;
   }
   
   public Variable createVariable(String name,String msgtype,String type,String element)
   {
	   Variable var=null;
	   var=new pdn.bee.model.bpel11.elements.impl.VariableImpl();
	   
	   var.setName(name);
	   QName qmtype;
	   QName qmsgtype;
	   qmtype=pdn.bee.utils.BeeUtils.stringToQName(msgtype);
	   
	   String prefix=qmtype.getPrefix();
	   
	   if(prefix!=null && !prefix.equals(""))
	   {
		   var.setTargetNamespace((String)namespaces.get(prefix) );
		   qmsgtype=new QName((String)namespaces.get(prefix),qmtype.getLocalPart(),qmtype.getPrefix() );
		   
	   }else
	   {
		   qmsgtype=new QName("",qmtype.getLocalPart(),qmtype.getPrefix() );
	   }
	   
	   
	   var.setMessageType(qmsgtype);
	   QName qtype;
	   qtype=pdn.bee.utils.BeeUtils.stringToQName(type);
	   var.setType(qtype);
	   
	   var.setElement(pdn.bee.utils.BeeUtils.stringToQName(element));	 
	   //javax.swing.JOptionPane.showMessageDialog(null,name+" "+msgtype+" "+type+" "+element+" obj:"+var);
	  	   
	   variables.put(name,var);
	   logger.debug("Binding variable:"+name);
	   return var;	   
	   	   
   }
   
   public Sequence createSequence(String name,String joincond,String supp)
   {
	   Sequence seq=null;
	   seq=new SequenceImpl(name,joincond,supp);
	   logger.debug("Binding sequence:"+name);
	   return seq;
   }
   
   public Flow createFlow(String name,String join,String supp)
   {
	   Flow flow=null;
	   flow=new FlowImpl(name,join,supp);
	   logger.debug("Binding Flow:"+name);
	   return flow;
   }
   
   public Recieve createRecieve(String name,String joincond,String supp
		 ,String partnerlink,String porttype,String operation,String variable,String createIns)	 
   
   {
	Recieve rec=new RecieveImpl(name,joincond,supp);
	rec.setPartnerLink(this.retrievePartnerLink(partnerlink));
	rec.setPortType(BeeUtils.stringToQName(porttype));
	rec.setOperation(operation);
	rec.setVariable(retrieveVariable(variable));
	rec.setIsCreateInstance(BeeUtils.stringYesNoToBoolean(createIns));
	logger.debug("Binding recieve:"+name);
	return rec;
   }
   
   public Assign createAssign(String name,String joincond,String supp)
   {
	   Assign assign=null;
	   assign=new AssignImpl(name,joincond,supp);
	   logger.debug("Binding assign:"+name);
	   return assign;
   }
   
   public From createFrom(String variable,String part,String query,String property,String partnerlink,
		   String endpointref,String expression,String opaque
   )
   {
	   From from=null;
	   from=new FromImpl();
	   
	   from.setVariable(this.retrieveVariable(variable));
	   from.setPart(part);
	   from.setQuery(query);
	   from.setProperty(BeeUtils.stringToQName(property));
	   from.setPartnerLink(this.retrievePartnerLink(partnerlink));
	   
	   Roles role=new RolesImpl();
	   role.setRole(endpointref);
	   from.setEndpointReference(role);
	   from.setExpression(expression);
	   from.setOpaque(BeeUtils.stringYesNoToBoolean(opaque));
	   logger.debug("Binding from:"+variable);
	   return from;
   }
   
   public To createTo(String variable,String part,String query,String property,String partnerlink)
   {
	   To to=null;
	   to=new ToImpl();
	   
	   to.setVariable(this.retrieveVariable(variable));
	   to.setPart(part);
	   to.setQuery(query);
	   to.setProperty(BeeUtils.stringToQName(property));
	   to.setPartnerLink(this.retrievePartnerLink(partnerlink));
	   
	   logger.debug("Binding to:"+variable);
	   return to;
   }
   
   public Invoke createInvoke(String name,String joincond,String supp,
	String partnerlink,String porttype,String operation,String invar,String outvar)
   {
	QName qpt;
	QName qpt2=null;
	qpt=BeeUtils.stringToQName(porttype);
	
	if(qpt.getPrefix()!=null)
	{
		String ns=(String)namespaces.get(qpt.getPrefix());
		qpt2=new QName(ns,qpt.getLocalPart(),qpt.getPrefix());
	}
	if (qpt2==null)
		 qpt2=qpt;
	Invoke inv=new InvokeImpl(name,joincond,supp);
	inv.setPartnerLink(this.retrievePartnerLink(partnerlink));
	inv.setPortType(qpt2);
	inv.setOperation(operation);
	inv.setInputVariable(this.retrieveVariable(invar));
	inv.setOutputVariable(this.retrieveVariable(outvar));
	Variable iv=retrieveVariable(invar);
	
	
	//Object ss[]=variables.keySet().toArray();
	
	//logger.debug("Binding invoke:"+name);
	return inv;
   }
   
   public Reply createReply(String name,String joincond,String supp,
		   String partnerlink,String porttype,String operation,String variable,String faultname)
   	
   {
	   Reply reply=new ReplyImpl(name,joincond,supp);
	   reply.setPartnerLink(this.retrievePartnerLink(partnerlink));
	   reply.setPortType(BeeUtils.stringToQName(porttype));
	   reply.setOperation(operation);
	   reply.setVariable(this.retrieveVariable(variable));
	   reply.setFaultName(BeeUtils.stringToQName(faultname));
	   logger.debug("Binding createReply:"+name);
	   return reply;
   }
   
   public Switch createSwitch(String name,String joincond,String supp)
   {
    Switch bswitch=new SwitchImpl(name,joincond,supp);    
    logger.debug("Binding swith:"+name);
    return bswitch;
   }
   
   
   public Case createCase(String name,String joincond,String supp)
   {
	   Case bpelcase=null;
	   logger.debug("Binding case:"+name);
	   return bpelcase;
   }
   
   // helper methods
   public PartnerLink retrievePartnerLink(String plname)
   {
	   if(BeeUtils.stringNullOrEmply(plname)) return null;
	   
	   return (PartnerLink)partnerlinks.get(plname);
   }
   
   public Variable retrieveVariable(String varname)
   {
	   if(BeeUtils.stringNullOrEmply(varname)) return null;	   
	   return (Variable)variables.get(varname);
   }
   
   
   
}
