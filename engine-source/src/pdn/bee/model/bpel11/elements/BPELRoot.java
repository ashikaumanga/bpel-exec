/**
 * 
 */
package pdn.bee.model.bpel11.elements;

import pdn.bee.core.ProcessEngine;
import pdn.bee.core.ProcessInstance;

/**
 * @author umanga
 *
 */
public interface BPELRoot {
	/**
     * name attribute name
     */
    public static final String NAME = "name";

    /**
     * partnerLink attribute name
     */
    public static final String PARTNER_LINK = "partnerLink";

    /**
     * partnerLinkType attribute name
     */
    public static final String PARTNER_LINK_TYPE = "partnerLinkType";

    /**
     * myRole attribute name
     */
    public static final String MY_ROLE = "myRole";

    /**
     * partnerRole attribute name
     */
    public static final String PARTNER_ROLE = "partnerRole";

    /**
     * portType attribute name
     */
    public static final String PORT_TYPE = "portType";

    /**
     * operation attribute name
     */
    public static final String OPERATION = "operation";

    /**
     * variable attribute name
     */
    public static final String VARIABLE = "variable";

    /**
     * createInstance attribute name
     */
    public static final String CREATE_INSTANCE = "createInstance";

    /**
     * messageType attribute name
     */
    public static final String MESSAGE_TYPE = "messageType";

    /**
     * type attribute name
     */
    public static final String TYPE = "type";

    /**
     * element attribute name
     */
    public static final String ELEMENT = "element";

    /**
     * set attribute name
     */
    public static final String SET = "set";

    /**
     * inititate attribute name
     */
    public static final String INITIATE = "inititate";

    /**
     * pattern attribute name
     */
    public static final String PATTERN = "pattern";

    /**
     * inputVariable attribute name
     */
    public static final String INPUT_VARIABLE = "inputVariable";

    /**
     * outputVariable attribute name
     */
    public static final String OUTPUT_VARIABLE = "outputVariable";

    /**
     * joinCondition attribute name
     */
    public static final String JOIN_CONDITION = "joinCondition";

    /**
     * suppressJoinFailure attribute name
     */
    public static final String SUPPRESS_JOIN_FAILURE = "suppressJoinFailure";

    /**
     * part attribute name
     */
    public static final String PART = "part";

    /**
     * property attribute name
     */
    public static final String PROPERTY = "property";

    /**
     * endpointReference attribute name
     */
    public static final String ENDPOINT_REFERENCE = "endpointReference";

    /**
     * expression attribute name
     */
    public static final String EXPRESSION = "expression";

    /**
     * opaque attribute name
     */
    public static final String OPAQUE = "opaque";

    /**
     * targetNamespace attribute name
     */
    public static final String TARGET_NAMESPACE = "targetNamespace";

    /**
     * queryLanguage attribute name
     */
    public static final String QUERY_LANGUAGE = "queryLanguage";

    /**
     * expressionLanguage attribute name
     */
    public static final String EXPRESSION_LANGUAGE = "expressionLanguage";

    /**
     * enableInstanceCompensation attribute name
     */
    public static final String ENABLE_INSTANCE_COMPESATION = "enableInstanceCompensation";

    /**
     * xmlns attribute name
     */
    public static final String XMLNS = "xmlns";

    /**
     * abstractProcess attribute name
     */
    public static final String ABSTRACT_PROCESS = "abstractProcess";

    /**
     * condition attribute name
     */
    public static final String CONDITION = "condition";

    /**
     * faultName attribute name
     */
    public static final String FAULT_NAME = "faultName";
    public static final String QUERY="query";
    //public void setTargetNameSpace(String ns);
    //public String getTargetNameSpace();
    public void accept(ProcessEngine engine,ProcessInstance instance) throws Exception;

}
