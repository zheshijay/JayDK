package soap.test;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class SOAPUtils {

	public static SOAPMessage strToMessage(String strDocument) throws IOException, SOAPException {
		InputStream is = new ByteArrayInputStream( URLDecoder.decode(strDocument, "UTF-8").getBytes());
		return MessageFactory.newInstance().createMessage(null, is);
	}


	public static Document toDocument(SOAPMessage soapMsg)   
			throws TransformerConfigurationException, TransformerException, SOAPException, IOException {  
		Source src = soapMsg.getSOAPPart().getContent();  
		TransformerFactory tf = TransformerFactory.newInstance();  
		Transformer transformer = tf.newTransformer();  
		DOMResult result = new DOMResult();  
		transformer.transform(src, result);  
		return (Document)result.getNode();  
	}

	//method to convert Document to String
	public static String getStringFromDocument(Document doc)
	{
		try
		{
			DOMSource domSource = new DOMSource(doc);
			StringWriter writer = new StringWriter();
			StreamResult result = new StreamResult(writer);
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();
			transformer.transform(domSource, result);
			return writer.toString();
		}
		catch(TransformerException ex)
		{
			ex.printStackTrace();
			return null;
		}
	} 



	public static Document loadXMLString(String response) throws Exception
	{
		DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputSource is = new InputSource(new StringReader(response));

		return db.parse(is);
	}

	public static List<String> getFullNameFromXml(String response, String tagName) throws Exception {
		Document xmlDoc = loadXMLString(response);
		NodeList nodeList = xmlDoc.getElementsByTagName(tagName);
		List<String> ids = new ArrayList<String>(nodeList.getLength());
		for(int i=0;i<nodeList.getLength(); i++) {
			Node x = nodeList.item(i);
			ids.add(x.getFirstChild().getNodeValue());             
			System.out.println(nodeList.item(i).getFirstChild().getNodeValue());
		}
		return ids;
	}

	public static String soapMessageToString(SOAPMessage message) 
	{
		String result = null;

		if (message != null) 
		{
			ByteArrayOutputStream baos = null;
			try 
			{
				baos = new ByteArrayOutputStream();
				message.writeTo(baos); 
				result = baos.toString();
			} 
			catch (Exception e) 
			{
			} 
			finally 
			{
				if (baos != null) 
				{
					try 
					{
						baos.close();
					} 
					catch (IOException ioe) 
					{
					}
				}
			}
		}
		return result;
	}   



}
