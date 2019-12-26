 package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

 import org.dom4j.Element;
 
public abstract class AssertedRelationship extends ArgumentElement {

	private ArgumentElement source;
	private ArgumentElement target;
	
	private Boolean multiplicity;
    private Boolean optionality;
    
    //Element constructor
    public AssertedRelationship(Element element) {
    	
    	super(element);
    	
    	source = null;
    	target = null;
    	multiplicity = false;
    	optionality = false;
    	
    	
    }
	
	public ArgumentElement getSource() {
		return source;
	}


	public void setSource(ArgumentElement source) {
		this.source = source;
	}


	public ArgumentElement getTarget() {
		return target;
	}


	public void setTarget(ArgumentElement target) {
		this.target = target;
	}


	public AssertedRelationship() {
	
	}


	public Boolean getMultiplicity() {
		return multiplicity;
	}


	public void setMultiplicity(Boolean multiplicity) {
		this.multiplicity = multiplicity;
	}


	public Boolean getOptionality() {
		return optionality;
	}


	public void setOptionality(Boolean optionality) {
		this.optionality = optionality;
	}
	
	
}
