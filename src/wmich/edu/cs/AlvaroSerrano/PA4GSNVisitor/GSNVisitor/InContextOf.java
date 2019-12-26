package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

public class InContextOf extends AssertedRelationship {

	public InContextOf(Element element) {
		
		super(element);
		
	}
	
	public InContextOf() {
		
	}

	public Object accept(IVisitorGSN visitor) {
		return visitor.visitInContextOf(this);
	}

}
