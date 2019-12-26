		package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

public class Context extends InformationElement {

	public Context() {
		
	}
	
	public Context(Element element) {
		super(element);
	}
	
	public Object accept(IVisitorGSN visitor) {
		return visitor.visitContext(this);
	}

}
