package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

public class SupportedBy extends AssertedRelationship {
	
	public SupportedBy() {
		
	}
	
	public SupportedBy(Element element) {
		super(element);
	}

	public SupportedBy(SupportedBy assertedRelationship) {
		// TODO Auto-generated constructor stub
	}

	public Object accept(IVisitorGSN visitor) {
		return visitor.visitSupportedBy(this);
	}
	
}
