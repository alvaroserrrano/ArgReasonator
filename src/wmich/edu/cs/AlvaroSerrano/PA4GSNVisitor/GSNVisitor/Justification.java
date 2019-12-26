package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

public class Justification extends Claim {

	public Justification() {
		// TODO Auto-generated constructor stub
	}

	public Object accept(IVisitorGSN visitor) {
		return visitor.visitJustification(this);
	}

	public Justification (Element element) {
		super(element);
	}
	
}
