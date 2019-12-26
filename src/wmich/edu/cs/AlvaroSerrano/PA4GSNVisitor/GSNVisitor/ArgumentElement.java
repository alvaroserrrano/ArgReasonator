package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Element;

public abstract class ArgumentElement{
	
	private String id;
	private String description;
	private List<Value> content;
	private List<AssertedRelationship> targetOf;
	private List<AssertedRelationship> sourceOf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Value> getContent() {
		return content;
	}

	public void setContent(List<Value> content) {
		this.content = content;
	}

	public List<AssertedRelationship> getTargetOf() {
		return targetOf;
	}

	public void setTargetOf(List<AssertedRelationship> targetOf) {
		this.targetOf = targetOf;
	}

	public List<AssertedRelationship> getSourceOf() {
		return sourceOf;
	}

	public void setSourceOf(List<AssertedRelationship> sourceOf) {
		this.sourceOf = sourceOf;
	}
	

	//construct from element
	public ArgumentElement(Element element) {
		
		List<Attribute> attributes = element.attributes();
		
		id = attributes.get(2).getValue().toString();
		
		description = (element.attributeValue("description") != null) ? element.attributeValue("description") : "";
		
		//temporary array for Value strings
		String []temp= element.attributeValue("content").toString().split(" ");
		 
		 for(int i = 0; i < temp.length; i++) {
			 
			 String word = temp[i];
			 
			 if(word.contains("{")) {
				 
				 Value variable = new Variable();
				 variable.setValue(word.substring(word.indexOf("{"), word.indexOf("}")+1));
	   		 
				 //Add Variable to content : ArrayList<Value>
				 content.add(variable);
				 
			 }else {
				 
				 Value sValue = new SValue();
				 sValue.setValue(word);
				 
				 //	Add SValue to content : ArrayList<Value>
				 content.add(sValue);
				 
			 }//else
				 
		}//for
		
		//content = (element.attributeValue("content") != null) ? element.attributeValue("content") : "";
		targetOf = new ArrayList<>();
		sourceOf = new ArrayList<>();
	}
	
	public ArgumentElement() {
		
	}
	
}
