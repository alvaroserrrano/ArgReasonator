package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

public abstract class InformationElement extends ArgumentElement {

	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public InformationElement() {
		
	}
	
	InformationElement(Element element){
		super(element);
		url = (element.attributeValue("url") != null) ? element.attributeValue("url") : "";
	}

}
