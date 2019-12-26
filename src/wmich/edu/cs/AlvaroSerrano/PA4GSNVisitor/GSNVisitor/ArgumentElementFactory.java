package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;


import org.dom4j.Attribute;
import org.dom4j.Document;


public class ArgumentElementFactory implements IArgumentElementFactory {

	@Override
	//Create GSN nodes for the Assurance Case (based on GSN metamodel)
	public ArgumentElement createArgumentElement(Element element) {
			
		//====================================================================================
		
				
		//Determine which GSN structure to create based on element's attributes (id)
		
		//ARGUMENT ELEMENT TO BE RETURNED (GSN NODE)
		//============================================
		//							  ||||||||||||||||
		ArgumentElement argElement;	//||||||||||||||||
		//							  ||||||||||||||||
		//============================================
		
//		String type = element.attributeValue("type").trim();
//		
		List<Attribute> attributes = element.attributes();
//		
//		String id = attributes.get(2).getValue().toUpperCase();
//		
//		char first = (!id.isEmpty()) ? id.charAt(0) : ' ';
//		
		

		String id = "";
		
		
		
		for(int i = 0; i < attributes.size(); i++) {
			
			Attribute attribute = attributes.get(i);
        	
////////////Set id : String/////////////////////////////////////////////////////////////////////////////////////////////////////
        	
        	if(attribute.asXML().startsWith("id")) {
       		 	id = attribute.getValue();
       	 	}
        	
		}//for
        	
//****************************************GOAL***************************************************************
        	 //Create Goal
        	 if(id.startsWith("G")) {
        		 
        		 List<Value> content = new ArrayList<Value>();
        		 
        		 Variable variable = new Variable();
        		 
        		 SValue sValue= new SValue();
        		 
        		 //Build Goal
        		 argElement = new Goal();
        		 
        		 //Set id
        		 argElement.setId(id);
        		 
        		 //Set description
        		 argElement.setDescription(element.attribute("description").getValue());
        		 
        		 //temporary array for Value strings
        		 String []temp= element.attributeValue("content").toString().split(" ");
        		 
        		 for(int i = 0; i < temp.length; i++) {
        			 
        			 String word = temp[i];
        			 
        			 if(word.contains("{")) {
        				 
        				 variable = new Variable();
        				 variable.setValue(word.substring(word.indexOf("{"), word.indexOf("}")+1));
                		 
        				 //Add Variable to content : ArrayList<Value>
        				 content.add(variable);
        				 
        			 }else {
        				 
        				 sValue = new SValue();
        				 sValue.setValue(word);
        				 
                		 //Add SValue to content : ArrayList<Value>
        				 content.add(sValue);
        				 
        			 }//else
        				 
        		}//for
        		 
        		 //setContent
        		 argElement.setContent(content);
        		 
        		 String assumedStr = element.attribute("assumed").getValue();
        		 
        		 //set assumed 
        		 if(assumedStr.equals("false")) {
        			 ((Claim) argElement).setIsAssumed(false);
        		 }else {
        			 ((Claim) argElement).setIsAssumed(true);
        		 }
        		 
        		 String toBeSupportedStr = element.attribute("toBeSupported").getValue();
        		 
        		//set toBeSupported
        		 if(toBeSupportedStr.equals("false")) {
        			 ((Claim) argElement).setIsSupported(false);
        		 }else {
        			 ((Claim) argElement).setIsSupported(true);
        		 }
        		 
        		 List<AssertedRelationship> sourceOf = new ArrayList<AssertedRelationship>();
        		 List<AssertedRelationship> targetOf = new ArrayList<AssertedRelationship>();
        		 
        		 argElement.setSourceOf(sourceOf);
        		 argElement.setTargetOf(targetOf);
        		 
        		 return argElement;
        			 
        	}//if

////****************************************ASSUMPTION*********************************************************
//        	
        	 //Create Assumption        		 
        	 if(id.startsWith("A")) {
        	 
        		 List<Value> content = new ArrayList<Value>();
        		 
        		 Variable variable = new Variable();
        		 
        		 SValue sValue= new SValue();
        		 
        		 //Build Assumption
        		 argElement = new Assumption();
        		 
        		 //Set id
        		 argElement.setId(id);
        		 
        		 //Set description
        		 argElement.setDescription(element.attribute("description").getValue());
        		 
        		 //temporary array for Value strings
        		 String []temp= element.attributeValue("content").toString().split(" ");
        		 
        		 for(int i = 0; i < temp.length; i++) {
        			 
        			 String word = temp[i];
        			 
        			 if(word.contains("{")) {
        				 
        				 variable = new Variable();
        				 variable.setValue(word.substring(word.indexOf("{"), word.indexOf("}")+1));
                		 
        				 //Add Variable to content : ArrayList<Value>
        				 content.add(variable);
        				 
        			 }else {
        				 
        				 sValue = new SValue();
        				 sValue.setValue(word);
        				 
                		 //Add SValue to content : ArrayList<Value>
        				 content.add(sValue);
        				 
        			 }//else
        				 
        		}//for
        		 
        		 //setContent
        		 argElement.setContent(content);

        		 List<AssertedRelationship> sourceOf = new ArrayList<AssertedRelationship>();
        		 List<AssertedRelationship> targetOf = new ArrayList<AssertedRelationship>();
        		 
        		 argElement.setSourceOf(sourceOf);
        		 argElement.setTargetOf(targetOf);
        		 
        		 return argElement;
        		 
        	 }//Assumption
//        	 
////****************************************JUSTIFICATION*********************************************************
//	

        	 //Create Context        		 
        	 if(id.startsWith("J")) {
        	 
        		 List<Value> content = new ArrayList<Value>();
        		 
        		 Variable variable = new Variable();
        		 
        		 SValue sValue= new SValue();
        		 
        		 //Build Justification
        		 argElement = new Justification();
        		 
        		 //Set id
        		 argElement.setId(id);
        		 
        		 //Set description
        		 argElement.setDescription(element.attribute("description").getValue());
        		 
        		 //temporary array for Value strings
        		 String []temp= element.attributeValue("content").toString().split(" ");
        		 
        		 for(int i = 0; i < temp.length; i++) {
        			 
        			 String word = temp[i];
        			 
        			 if(word.contains("{")) {
        				 
        				 variable = new Variable();
        				 variable.setValue(word.substring(word.indexOf("{"), word.indexOf("}")+1));
                		 
        				 //Add Variable to content : ArrayList<Value>
        				 content.add(variable);
        				 
        			 }else {
        				 
        				 sValue = new SValue();
        				 sValue.setValue(word);
        				 
                		 //Add SValue to content : ArrayList<Value>
        				 content.add(sValue);
        				 
        			 }//else
        				 
        		}//for
        		 
        		 //setContent
        		 argElement.setContent(content);
        		 
        		 List<AssertedRelationship> sourceOf = new ArrayList<AssertedRelationship>();
        		 List<AssertedRelationship> targetOf = new ArrayList<AssertedRelationship>();
        		 
        		 argElement.setSourceOf(sourceOf);
        		 argElement.setTargetOf(targetOf);

        		 return argElement;
        		 
        	 }//Justification
//        	 
////****************************************SOLUTION*********************************************************
//        	
        	 //Create Solution        		 
        	 if(id.startsWith("n", 1)) {
        	 
        		 List<Value> content = new ArrayList<Value>();
        		 
        		 Variable variable = new Variable();
        		 
        		 SValue sValue= new SValue();
        		 
        		 //Build Solution
        		 argElement = new Solution();
        		 
        		 //Set id
        		 argElement.setId(id);
        		 
        		 //Set description
        		 argElement.setDescription(element.attribute("description").getValue());
        		 
        		 //temporary array for Value strings
        		 String []temp= element.attributeValue("content").toString().split(" ");
        		 
        		 for(int i = 0; i < temp.length; i++) {
        			 
        			 String word = temp[i];
        			 
        			 if(word.contains("{")) {
        				 
        				 variable = new Variable();
        				 variable.setValue(word.substring(word.indexOf("{"), word.indexOf("}")+1));
                		 
        				 //Add Variable to content : ArrayList<Value>
        				 content.add(variable);
        				 
        			 }else {
        				 
        				 sValue = new SValue();
        				 sValue.setValue(word);
        				 
                		 //Add SValue to content : ArrayList<Value>
        				 content.add(sValue);
        				 
        			 }//else
        				 
        		}//for
        		 
        		 //setContent
        		 argElement.setContent(content);
        		 
        		 List<AssertedRelationship> sourceOf = new ArrayList<AssertedRelationship>();
        		 List<AssertedRelationship> targetOf = new ArrayList<AssertedRelationship>();
        		 
        		 argElement.setSourceOf(sourceOf);
        		 argElement.setTargetOf(targetOf);

        		 return argElement;
        		 
        	 }//Solution
//        	 
////****************************************CONTEXT*********************************************************

        	 //Create Context        		 
        	 if(id.startsWith("C")) {
        	 
        		 List<Value> content = new ArrayList<Value>();
        		 
        		 Variable variable = new Variable();
        		 
        		 SValue sValue= new SValue();
        		 
        		 //Build Context
        		 argElement = new Context();
        		 
        		 //Set id
        		 argElement.setId(id);
        		 
        		 //Set description
        		 argElement.setDescription(element.attribute("description").getValue());
        		 
        		 //temporary array for Value strings
        		 String []temp= element.attributeValue("content").toString().split(" ");
        		 
        		 for(int i = 0; i < temp.length; i++) {
        			 
        			 String word = temp[i];
        			 
        			 if(word.contains("{")) {
        				 
        				 variable = new Variable();
        				 variable.setValue(word.substring(word.indexOf("{"), word.indexOf("}")+1));
                		 
        				 //Add Variable to content : ArrayList<Value>
        				 content.add(variable);
        				 
        			 }else {
        				 
        				 sValue = new SValue();
        				 sValue.setValue(word);
        				 
                		 //Add SValue to content : ArrayList<Value>
        				 content.add(sValue);
        				 
        			 }//else
        				 
        		}//for
        		 
        		 //setContent
        		 argElement.setContent(content);

        		 List<AssertedRelationship> sourceOf = new ArrayList<AssertedRelationship>();
        		 List<AssertedRelationship> targetOf = new ArrayList<AssertedRelationship>();
        		 
        		 argElement.setSourceOf(sourceOf);
        		 argElement.setTargetOf(targetOf);
        		 
        		 return argElement;
        		 
        	 }//Context
//
////****************************************STRATEGY*********************************************************
//    		 //Create Strategy
//        	 
        	 //Create Context        		 
        	 if(id.startsWith("S")) {
        	 
        		 List<Value> content = new ArrayList<Value>();
        		 
        		 Variable variable = new Variable();
        		 
        		 SValue sValue= new SValue();
        		 
        		 //Build Strategy
        		 argElement = new Strategy();
        		 
        		 //Set id
        		 argElement.setId(id);
        		 
        		 //Set description
        		 argElement.setDescription(element.attribute("description").getValue());
        		 
        		 //temporary array for Value strings
        		 String []temp= element.attributeValue("content").toString().split(" ");
        		 
        		 for(int i = 0; i < temp.length; i++) {
        			 
        			 String word = temp[i];
        			 
        			 if(word.contains("{")) {
        				 
        				 variable = new Variable();
        				 variable.setValue(word.substring(word.indexOf("{"), word.indexOf("}")+1));
                		 
        				 //Add Variable to content : ArrayList<Value>
        				 content.add(variable);
        				 
        			 }else {
        				 
        				 sValue = new SValue();
        				 sValue.setValue(word);
        				 
                		 //Add SValue to content : ArrayList<Value>
        				 content.add(sValue);
        				 
        			 }//else
        				 
        		}//for
        		 
        		 //setContent
        		 argElement.setContent(content);
        		 
        		 List<SupportedBy> describedInferences = new ArrayList<SupportedBy>();
        		 List<AssertedRelationship> sourceOf = new ArrayList<AssertedRelationship>();
        		 List<AssertedRelationship> targetOf = new ArrayList<AssertedRelationship>();
        		 
        		 ((Strategy) argElement).setDescribedInferences(describedInferences);
        		 argElement.setSourceOf(sourceOf);
        		 argElement.setTargetOf(targetOf);

        		 return argElement;
        		 
        	 }//Strategy
        	 
        	 if(id.isEmpty()) {
        		 
        		 if(element.attribute("type").getValue().equals("ARM:AssertedInference") || 
        			element.attribute("type").getValue().equals("ARM:AssertedEvidence")) {
        			 
        			 List<Value> content = new ArrayList<Value>();
            		 
            		 Variable variable = new Variable();
            		 
            		 SValue sValue= new SValue();

        			 argElement = new SupportedBy();
        			 argElement.setId(id);
        			 argElement.setDescription(element.attribute("description").getValue());
        			 argElement.setContent(null);
        			 
        			 return argElement;
        			 
        		 }//SupportedBy
        		 
        		 if(element.attribute("type").getValue().equals("ARM:AssertedContext")) {
        			 
        			 List<Value> content = new ArrayList<Value>();
            		 
            		 Variable variable = new Variable();
            		 
            		 SValue sValue= new SValue();
        			 
        			 argElement = new InContextOf();
        			 argElement.setId(id);
        			 argElement.setDescription(element.attribute("description").getValue());
        			 argElement.setContent(null);
        			 
        			 List<AssertedRelationship> sourceOf = new ArrayList<AssertedRelationship>();
            		 List<AssertedRelationship> targetOf = new ArrayList<AssertedRelationship>();
            		 
            		 argElement.setSourceOf(sourceOf);
            		 argElement.setTargetOf(targetOf);
        			 
        			 return argElement;
        			 
        		 }//InContextOf
        		 
        	 }
		
		//Return the reference of the new structure created.
		return null;
		
	}//createArgumentElement

	
}//class
