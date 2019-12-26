package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

public class Solution extends ArgumentReasoning {

	public Solution() {

	}

	public Object accept(IVisitorGSN visitor) {
		return visitor.visitSolution(this);
	}
	
	public Solution (Element element) {
		super(element);
	}

}
