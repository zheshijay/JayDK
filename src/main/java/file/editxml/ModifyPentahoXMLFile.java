package file.editxml;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ModifyPentahoXMLFile {

	public static void main(String argv[]) {

		try {
			String filepath = "C:\\workspace\\utils\\jaytest\\src\\main\\java\\file\\editxml\\insert_new_offer_to_audience.xml";
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(filepath);

			// Get the root element
			Node company = doc.getFirstChild();

			// Get the staff element , it may not working if tag has spaces, or
			// whatever weird characters in front...it's better to use
			// getElementsByTagName() to get it directly.
			// Node staff = company.getFirstChild();

			// Get the staff element by tag name directly
			Node job = doc.getElementsByTagName("job").item(0);

			// update staff attribute
			//		NamedNodeMap attr = job.getAttributes();
			//		Node nodeAttr = attr.getNamedItem("id");
			//		nodeAttr.setTextContent("2");

			// append a new node to staff
			//		Element age = doc.createElement("age");
			//		age.appendChild(doc.createTextNode("28"));
			//		job.appendChild(age);

			// loop the staff child node
			NodeList jobNodes = job.getChildNodes();

			for (int i = 0; i < jobNodes.getLength(); i++) {

				Node eachJobNode = jobNodes.item(i);
				//                   
				//                   System.out.println("Node Name: " + node.getNodeName());
				//                   System.out.println("Node value: " + node.getTextContent());

				// get the salary element, and update the value
				if ("entries".equals(eachJobNode.getNodeName())) {
					NodeList entryNotes = eachJobNode.getChildNodes();

					for (int j = 0; j < entryNotes.getLength(); j++) {    // Check each entry node
						Node eachEntryNode = entryNotes.item(j);

						NodeList entryNodes = eachEntryNode.getChildNodes();

						for (int k = 0; k < entryNodes.getLength(); k++) {
							Node eachEntry = entryNodes.item(k);

							if("fields".equals(eachEntry.getNodeName())){
								System.out.println("--Found set_variables!");

								NodeList fieldsNodes = eachEntry.getChildNodes();
								//				   		 
								System.out.println("fieldsNodes.getLength: " + fieldsNodes.getLength());
								for (int l = 0; l < fieldsNodes.getLength(); l++) {
									Node eachFieldNode = fieldsNodes.item(l);
									
									    NodeList fieldChildNodes = eachFieldNode.getChildNodes();
									    		for (int m = 0; m < fieldChildNodes.getLength(); m++) {
									    			
									    			System.out.println("---------------------------------------");
									    			Node eachFieldChildNode = fieldChildNodes.item(m);
									    			
//									    			eachFieldChildNode.get
									    			
//									    			NamedNodeMap attr = eachFieldChildNode.getAttributes();
									    			
									    			if("offer_id".equalsIgnoreCase(eachFieldChildNode.getTextContent())){
									    				System.out.println("This is offer_id");
//									    				eachFieldChildNode.setTextContent("offer_id");
									    				
									    			}
									    			
									    			System.out.println("-----1 eachFieldChild Name: " + eachFieldChildNode.getNodeName());
													System.out.println("-----1 eachFieldChild getNodeValue: " + eachFieldChildNode.getTextContent());
									    		}
									    
									    
									


								}


								//				   		   for (int l = 0; l < setVarNodes.getLength(); l++) {
								//				   			Node eachSetVarNode = setVarNodes.item(l);
								//
								//				   			 System.out.println("**2 eachSetVarNode Name: " + eachSetVarNode.getNodeName());
								//				   			 System.out.println("**2 eachSetVarNode Type: " + eachSetVarNode.getNodeType());
								//						   	 System.out.println("**2 eachSetVarNode content: " + eachSetVarNode.getTextContent());
								//				   			   
								//				   		   }
							}

							NodeList entryChildNodes = eachEntry.getChildNodes();




							//				   	  for (int l = 0; l < entryChildNodes.getLength(); l++) {
							//				   		Node eachEntryChildNode = entryChildNodes.item(l);
							//				   		
							//				   		 System.out.println("-----2 eachEntryChildNode Name: " + eachEntryChildNode.getNodeName());
							//				   		
							//				   			if("fields".equals(eachEntryNode.getNodeName())){
							//				   				NodeList fieldChildNodes = eachEntryChildNode.getChildNodes();
							//				   				
							//				   				System.out.println("fieldChildNodes size: " + fieldChildNodes.getLength());
							//				   			}
							//				   		
							//				   		
							//				   	  }



						}



						//                 System.out.println("Node Name: " + eachEntryNode.getNodeName());
						//                 System.out.println("Node value: " + eachEntryNode.getTextContent());

						if ("Set variables".equals(eachEntryNode.getNodeName())) {
							NodeList fieldNodes = eachEntryNode.getChildNodes();
							//					   for (int k = 0; k < fieldNodes.getLength(); k++) {
							//						   Node eachFieldNode = fieldNodes.item(j);
							//						   System.out.println("eachFieldNode Name: " + eachFieldNode.getNodeName());
							//						   
							//					   }




							//					   NodeList entityNodes = eachJobChildEntity
							//					   for (int k = 0; k < entityNodes.getLength(); k++) {
							//						   Node eachEntityNode = entityNodes.item(j);
							//						   
							//						   System.out.println("eachEntityNode Name: " + eachEntityNode.getNodeName());
							//						   System.out.println("eachEntityNode Content: " + eachEntityNode.getTextContent());
							//					   } 
						}



					}


					//			  node.setTextContent("2000000");
				}


			}

			// write the content into xml file
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new File(filepath));
			transformer.transform(source, result);

			System.out.println("Done");

		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SAXException sae) {
			sae.printStackTrace();
		}
	}
}
