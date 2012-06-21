package pdn.bee.model.bpel11.elements;

public interface CorrelationWithPattern extends Correlation{

	//Constants
	public static String IN="in";
	public static String OUT="out";
	public static String IN_OUT="outin";
	
	//xml elements
	
	public void setPattern(String pattern_string);
	public String getPattern();
	
	
	
}
