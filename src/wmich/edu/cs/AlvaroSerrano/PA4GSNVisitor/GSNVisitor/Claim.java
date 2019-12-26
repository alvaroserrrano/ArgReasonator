package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

public abstract class Claim extends ArgumentElement {

	protected Boolean isAssumed;
	protected Boolean isSupported;
	
	public Claim() {
		
	}

	public Boolean getIsAssumed() {
		return isAssumed;
	}
	
	public void setIsAssumed(Boolean isAssumed) {
		this.isAssumed = isAssumed;
		}

	public Boolean getIsSupported() {
		return isSupported;
	}

	public void setIsSupported(Boolean isSupported) {
		this.isSupported = isSupported;
	}
	
	Claim(Element element) {
		super(element);
		isAssumed = Boolean.parseBoolean(element.attributeValue("assumed"));
		isSupported = Boolean.parseBoolean(element.attributeValue("toBeSupported"));
	}

}
