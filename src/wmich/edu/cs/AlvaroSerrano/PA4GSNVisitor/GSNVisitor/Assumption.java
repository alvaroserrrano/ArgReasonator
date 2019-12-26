package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

public class Assumption extends Claim {

	public Assumption() {
		// TODO Auto-generated constructor stub
	}

	public Object accept(IVisitorGSN visitor) {
		return visitor.visitAssumption(this);
	}

	Assumption(Element element){
		super(element);
	}
	
}
