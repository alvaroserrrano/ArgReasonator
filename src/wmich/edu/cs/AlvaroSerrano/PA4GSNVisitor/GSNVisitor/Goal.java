package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Element;

public class Goal extends Claim {

	public Goal() {	
		
	}

	public Object accept(IVisitorGSN visitor) {
		return visitor.visitGoal(this);
	}
	
	public Goal (Element element) {
		super(element);
	}

}
