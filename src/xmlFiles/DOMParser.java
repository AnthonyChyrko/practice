package xmlFiles;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DOMParser {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(new File(".\\src\\xmlFiles\\Presents.xml"));
//		System.out.println(list);
		visit(doc,0);		
	}

	private static void visit(Node node, int level) {
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node childNode = list.item(i); // текущий нод 
		      process(childNode, level + 1); // обработка 
		      visit(childNode, level + 1); // рекурсия
		}
	}

	private static void process(Node node, int level) {
		for (int i = 0; i < level; i++) { 
		      System.out.print('\t'); 
		    } 
		    System.out.print(node.getNodeName()); 
		    if (node instanceof Element){ 
		        Element e = (Element) node;
		        System.out.println(e.getTextContent());
		        // работаем как с элементом (у него есть атрибуты и схема) 
		    } 
		    System.out.println(); 
		
	}
	
	

}
