package file.editxml;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XPathParserDemo2 {
	public static void main(String[] args) {
		try {

			String offer_id = "008";
			String offer_desc = "test offer 008";
			String offer_start_date = "2016/08/08";
			String offer_end_date = "2016/09/08";
			String rules = "[{\"key\": \"age\",\"operator\": \"&gt;\",\"value\": \"80\"}, {\"key\": \"gender\",\"operator\": \"=\",\"value\": \"F\"}]";

			File inputFile = new File("C:\\workspace\\utils\\jaytest\\src\\main\\java\\file\\editxml\\insert_new_offer_to_audience.xml");
			DocumentBuilderFactory dbFactory 
			= DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;

			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();

			XPath xPath =  XPathFactory.newInstance().newXPath();

			String expression = "/job/entries";	        
			NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node nNode = nodeList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					//                System.out.println(nNode.getTextContent());

					Element eElement = (Element) nNode;

					int totalFields = eElement.getElementsByTagName("variable_name").getLength();
					System.out.println("totalFields: " + totalFields);

					for(int j=0; j<totalFields; j++){
						
						if(eElement.getElementsByTagName("variable_name").item(j).getTextContent().equals("offer_id")){
							System.out.println("update offer id to " + offer_id);
							
							eElement.getElementsByTagName("variable_value")
									.item(j)
									.setTextContent(offer_id);
						}


						if(eElement.getElementsByTagName("variable_name").item(j).getTextContent().equals("offer_desc")){
							System.out.println("update offer_desc to " + offer_desc);
							eElement
							.getElementsByTagName("variable_value")
							.item(j)
							.setTextContent(offer_desc);
						}

						if(eElement.getElementsByTagName("variable_name").item(j).getTextContent().equals("offer_start_date")){
							System.out.println("update offer_start_date to " + offer_start_date);
							eElement
							.getElementsByTagName("variable_value")
							.item(j)
							.setTextContent(offer_start_date);
						}

						if(eElement.getElementsByTagName("variable_name").item(j).getTextContent().equals("offer_end_date")){
							System.out.println("update offer_end_date to " + offer_end_date);
							eElement
							.getElementsByTagName("variable_value")
							.item(j)
							.setTextContent(offer_end_date);
						}

						if(eElement.getElementsByTagName("variable_name").item(j).getTextContent().equals("rules")){
							System.out.println("update rules to " + rules);
							eElement
							.getElementsByTagName("variable_value")
							.item(j)
							.setTextContent(rules);
						}
					}








				}
			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File("temp.xml"));
			transformer.transform(source, result);



		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}