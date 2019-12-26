package wmich.edu.cs.AlvaroSerrano.PA4GSNVisitor.GSNVisitor;

import org.dom4j.Element;

//import org.dom4j.Element;

public interface IArgumentElementFactory {

	//Create instance of GSN node from its DOM4J element equivalent in Safety Pattern
	//Element type objects are instances of data items in xml files.
	//Create GSN nodes for the Assurance Case (based on GSN metamodel)
	public ArgumentElement createArgumentElement(Element element);
	
}
