package pdn.bee.core;

public class BeeEngineMessage {
	
	private java.util.Hashtable inputWSDLMessage;
	private String service;
	private String operation;
	private Object result;
	

	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public java.util.Hashtable getInputWSDLMessage() {
		return inputWSDLMessage;
	}
	public void setInputWSDLMessage(java.util.Hashtable inputWSDLMessage) {
		this.inputWSDLMessage = inputWSDLMessage;
	}

}
