package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class Strategy extends ArgumentReasoning {

	private List<SupportedBy> describedInferences;
	
	public Strategy() {
		// TODO Auto-generated constructor stub
	}
	
	public Object accept(IVisitorGSN visitor) {
		return visitor.visitStrategy(this);
	}

	public List<SupportedBy> getDescribedInferences() {
		return describedInferences;
	}

	public void setDescribedInferences(List<SupportedBy> describedInferences) {
		this.describedInferences = describedInferences;
	}

	Strategy(Element element){
		super(element);
		describedInferences = new ArrayList<>();
	}
	
}
