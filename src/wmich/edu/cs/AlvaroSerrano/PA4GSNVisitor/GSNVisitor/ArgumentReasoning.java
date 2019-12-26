package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import java.util.List;

import org.dom4j.Element;

public class ArgumentReasoning extends ArgumentElement {

	private List<SupportedBy> describedInferences;
	
	public List<SupportedBy> getDescribedInference() {
		return describedInferences;
	}

	public void setDescribedInference(List<SupportedBy> describedInference) {
		this.describedInferences = describedInference;
	}

	public ArgumentReasoning(Element element) {
		super(element);
	}
	
	public ArgumentReasoning() {
		
	}

}
