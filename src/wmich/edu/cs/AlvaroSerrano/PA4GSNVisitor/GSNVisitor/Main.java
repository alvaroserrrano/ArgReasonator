package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Attribute;
import org.dom4j.Node;
import org.dom4j.Visitor;
import org.dom4j.io.SAXReader;

public class Main {

	public static void main(String[] args) throws IOException {
		
		try {
			
			boolean keepAsking = true;
			
			do {
			
				Scanner scanner = new Scanner(System.in);
				
				IArgumentElementFactory factory = new ArgumentElementFactory();
				
				IVisitorGSN acBuilder = new GSNPrintVisitor();
				
				int answer = 0;
				
				//Read input safety pattern and reference it as dom4jtree
		        Element root;
		        
		        //BUILD GSN TREE
		        
		        //List<ArgumentElement> argumentElements = constructGSNPattern(root, factory, sourcesStr, targetsStr, nodes, assertedRelationships, nodeElements, assertedRelationshipElements);        
		        
		        List<ArgumentElement> argumentElements1 = new ArrayList<ArgumentElement>();

		        HashMap<String, ArgumentElement> xmiIDToArgElement1 = new HashMap<>();
		        
		        HashMap<ArgumentElement, Element> argElementToDom1 = new HashMap<>();

		        List<ArgumentElement> argumentElements2 = new ArrayList<ArgumentElement>();
		        
		        HashMap<String, ArgumentElement> xmiIDToArgElement2 = new HashMap<>();
		        
		        HashMap<ArgumentElement, Element> argElementToDom2 = new HashMap<>();
		        
		        		        
		        do {
		        	
		        	System.out.println("Please choose an input file: \n Enter 1, 2 or 3\n"
		        			+ "\t1. CS3310_F19_Example1_Goal_Justification.xmi\n"
		        			+ "\t2. CS3310PA4_SafetyPattern.xmi\n"
		        			+ "\t3. Quit");
		        	
		        	answer = getUserInput(scanner);
		        	
		        }while(answer == 0);
		        
		        if(answer == 1) {
		        	
		        	root = readFile(scanner, "CS3310_F19_Example1_Goal_Justification.xmi").getRootElement();
		        	
		 	       
			        System.out.println("--------------------------------");
			        System.out.println("Root element: " + root.getName() + "    |");
			        System.out.println("--------------------------------");
			        
		        	
		        	constructGSNPattern(root, factory, argumentElements1, xmiIDToArgElement1, argElementToDom1);
		        	
		        	System.out.println("--------------------------------------------------------------------------------");
		        	System.out.println("|||||||||||||||||||||||||||||PRINTING TREE 1|||||||||||||||||||||||||||||||||||||");
		        	System.out.println("--------------------------------------------------------------------------------");
		        	System.out.println("CS3310_F19_Example1_Goal_Justification.xmi");
		        	System.out.println("--------------------------------------------------------------------------------\n");
		        	
		        	for(ArgumentElement argumentElement : argumentElements1) {
		        		
		        		//Traverse GSN TREE 1 with Visitor Pattern
		        		traverseGSN(argumentElement, acBuilder);
		        		
		        	}
		        	
		        }//CS3310_F19_Example1_Goal_Justification.xmi
		        
		        else if (answer == 2) {
		        	
		        	root = readFile(scanner, "CS3310PA4_SafetyPattern.xmi").getRootElement();
		        	
		 	       
			        System.out.println("--------------------------------");
			        System.out.println("Root element: " + root.getName() + "    |");
			        System.out.println("--------------------------------");
			        
		        	
		        	constructGSNPattern(root, factory, argumentElements2,  xmiIDToArgElement2, argElementToDom2);
		        	
		        	System.out.println("--------------------------------------------------------------------------------");
		        	System.out.println("|||||||||||||||||||||||||||||PRINTING TREE 2|||||||||||||||||||||||||||||||||||||");
		        	System.out.println("--------------------------------------------------------------------------------");
		        	System.out.println("CS3310PA4_SafetyPattern.xmi");
		        	System.out.println("--------------------------------------------------------------------------------\n");
		        	
		        	for(ArgumentElement argumentElement : argumentElements2) {
		        		
		        		//Traverse GSN TREE 1 with Visitor Pattern
		        		traverseGSN(argumentElement, acBuilder);
		        		
		        	}
		        	
		        }//CS3310PA4_SafetyPattern.xmi
		        else if(answer == 3) {
		        	keepAsking = false;
		        }
		        
			}while(keepAsking);
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}//main

	//*************************************************************************************************
			
	//Build the DOM4J document from an XML source
	public static Document readFile(Scanner scanner, String filename) throws DocumentException {
	
		//Read input safety pattern file and reference it as a dom4j tree
		//File inputFile = new File(userInput);
		SAXReader saxReader = new SAXReader();			
		Document document = saxReader.read(filename);
		return document;
		
	}//readFile

	//*************************************************************************************************
	
	public static void constructGSNPattern(Element root, IArgumentElementFactory factory, 
			List<ArgumentElement> argumentElements,
			HashMap<String, ArgumentElement> xmiIDToArgElement,
			HashMap<ArgumentElement, Element> argElementToDom){
	
		for(Element element : root.elements()) {
						
			ArgumentElement argumentElementItem = null;
				
				//to extract the xmiId
				List<Attribute> attributes = element.attributes();
				
				//Create instance of GSN node from its DOM4J element equivalent in Safety Pattern
        		argumentElementItem = factory.createArgumentElement(element);
        		
        		xmiIDToArgElement.put(attributes.get(1).getValue().toString(), argumentElementItem);
        		
        		argElementToDom.put(argumentElementItem, element);
				
        		argumentElements.add(argumentElementItem);			
			
		}//for
		
		for(int i = 0; i < argumentElements.size(); i++) {
			
			if(argumentElements.get(i) instanceof AssertedRelationship) {
				
				//retrieve AssertedRelationship element
				Element relationElement = argElementToDom.get(argumentElements.get(i));
				
				ArgumentElement source = xmiIDToArgElement.get(relationElement.attributeValue("source"));
				
				ArgumentElement target = xmiIDToArgElement.get(relationElement.attributeValue("target"));
				
				source.getSourceOf().add((AssertedRelationship) argumentElements.get(i));
				target.getTargetOf().add((AssertedRelationship) argumentElements.get(i));
				
				((AssertedRelationship) argumentElements.get(i)).setSource(source);
				((AssertedRelationship) argumentElements.get(i)).setTarget(target);
			
			}//if
			
		}//for
		
//		for(int i = 0 ; i < argumentElements.size();i++) {
//			
//			if(argumentElements.get(i) instanceof ArgumentReasoning) {
//				
//				Element strategyElement = argElementToDom.get(argumentElements.get(i));
//				System.out.println(strategyElement.attributeValue("describedInference"));
				
//				System.out.println(xmiIDToArgElement.get(strategyElement.attributeValue("describedInference")));
				
//				AssertedRelationship assertedRelationship = ((AssertedRelationship)xmiIDToArgElement.get(strategyElement.attributeValue("describedInference").split[1]));
//				System.out.println(assertedRelationship);
//				SupportedBy strategySupport = new SupportedBy((SupportedBy) assertedRelationship);
//				
//				assertedRelationship.setSource(argumentElements.get(i));
//				
//				strategySupport.setTarget(argumentElements.get(i));
//				
//				((Strategy) argumentElements.get(i)).getSourceOf().add(assertedRelationship);
//				((Strategy) argumentElements.get(i)).getTargetOf().add(strategySupport);
//				
//				((Strategy) argumentElements.get(i)).getDescribedInference().add(strategySupport);
//			}//if
//			
//		}//for		
				
	}//constructGSNPattern
	
	//*************************************************************************************************
	
	private static void traverseGSN(ArgumentElement argumentElement, IVisitorGSN acBuilder) {
		
		if(argumentElement instanceof Goal) {
			((Goal) argumentElement).accept(acBuilder);
		}else if(argumentElement instanceof Justification) {
			((Justification) argumentElement).accept(acBuilder);
		}else if(argumentElement instanceof Assumption) {
			((Assumption) argumentElement).accept(acBuilder);
		}else if(argumentElement instanceof Solution) {
			((Solution) argumentElement).accept(acBuilder);
		}else if(argumentElement instanceof Context) {
			((Context) argumentElement).accept(acBuilder);
		}else if(argumentElement instanceof Strategy) {
			((Strategy) argumentElement).accept(acBuilder);
		}else if(argumentElement instanceof SupportedBy) {
			((SupportedBy) argumentElement).accept(acBuilder);
		}else if(argumentElement instanceof InContextOf) {
			((InContextOf) argumentElement).accept(acBuilder);
		}
		
	}//traverseGSN
	
	//*************************************************************************************************
	
	//TESTER METHOD
	//Print dom4jTree recursively
	public static void printRecursive(Element root) {

		for(int i = 0, size = root.nodeCount(); i < size; i++) {
	        Node node = root.node(i);
	        //System.out.println("\n Current element: " + node.getName());
	        if(node instanceof Element) {
	        	if(node.getName().equals("taggedValue")) {
	        		System.out.println("I am the tagged value");
	        	}
	        	System.out.println("\n Current element: " + node.getName());
	            
	        	Element currentNode = (Element) node;
	            
	        	//Read attributes of current node
	            List<Attribute> attributes = currentNode.attributes();
	            
	            for(Attribute attribute : attributes) {
	            	
	            	System.out.println(attribute.getName()+"----->" + attribute.getValue());
	            	//System.out.println(attribute.getName() + ": " + attribute.getText());
	            	if(attribute.getName().equalsIgnoreCase("assumed")) {
	            		System.out.println("Hello from assumed ---->>>" + attribute.getValue());	            	
	            	}
	            	if(attribute.getName().equals("content")) {
	            		System.out.println("CONTENT STRING IS:" + attribute.getValue());
	            		if(attribute.getValue().contains("{")) {	            			
	            			System.out.println("VARIABLE STRING IS:  " + attribute.getValue().substring(attribute.getValue().indexOf("{")+1, attribute.getValue().indexOf("}")));
	            		}else {
	            			System.out.println("VARIABLE STRING IS EMPTY");
	            		}
	            	}
	            	
	            }//for
	            
	            printRecursive(currentNode);
	        }//if(node instanceof Element)
	    
		}//for

	}//printRecursive

	//*************************************************************************************************
	
	public static void checkParentClass(ArgumentElement argElement) {
		
		if(argElement instanceof Claim) {
			System.out.println("This is a claim");
		}
		
		if(argElement instanceof InformationElement) {
			System.out.println("This is an informationElement");
		}
		
		if(argElement instanceof ArgumentReasoning) {
			System.out.println("This is an ArgumentReasoning");
		}
		
		
	}
	
//*************************************************************************************************
	
public static int getUserInput(Scanner scanner) {
		
		String input = "";
				
		int answer = 0;
		
		input = scanner.nextLine();
		
		if(!(input.equals("1") || input.equals("2") || input.equals("3") 
				|| input.equalsIgnoreCase("\\t 1. CS3310_F19_Example1_Goal_Justification.jpg\\n")
				|| input.equalsIgnoreCase("\\t 1. CS3310PA4_SafetyPattern.jpg\\n") 
				|| input.equalsIgnoreCase("CS3310PA4_SafetyPattern.xmi"))) {
			
			System.out.println("Invalid option. Enter 1, 2 or 3");
			
		}else {
			
			if(input.equalsIgnoreCase("CS3310_F19_Example1_Goal_Justification.jpg") || input.equalsIgnoreCase("1")) {
				answer = 1;
			}else if(input.equalsIgnoreCase("CS3310PA4_SafetyPattern.jpg") || input.equalsIgnoreCase("2")) {
				answer =  2;
			}else if(input.equalsIgnoreCase("CS3310PA4_SafetyPattern.xmi") || input.equalsIgnoreCase("3")) {
				answer = 3;
			}
			
		}//else
		
		return answer;
		
	}//getUserInput

//*************************************************************************************************
	
}//Main

