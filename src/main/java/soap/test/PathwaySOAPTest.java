package soap.test;

import java.io.ByteArrayOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringEscapeUtils;

//import org.mule.api.MuleEventContext;
//import org.mule.api.MuleMessage;
//import org.mule.api.lifecycle.Callable;
//import org.mule.util.StringUtils;
//import org.slf4j.Logger;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import config.UtilsConfig;

public class PathwaySOAPTest {
	/**
	 * Method used to print the SOAP Response
	 */
	private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		Source sourceContent = soapResponse.getSOAPPart().getContent();
		System.out.println("\nResponse SOAP Message = ");
		StreamResult result = new StreamResult(System.out);
		transformer.transform(sourceContent, result);
	}
	
	 private static SOAPMessage createPathwaysSOAPRequest() throws Exception {
	        MessageFactory messageFactory = MessageFactory.newInstance();
	        SOAPMessage soapMessage = messageFactory.createMessage();
	        SOAPPart soapPart = soapMessage.getSOAPPart();

	        String serverURI = UtilsConfig.getVal("server_uri").toString();

	        // SOAP Envelope
	        SOAPEnvelope envelope = soapPart.getEnvelope();
	        envelope.addNamespaceDeclaration("urn", serverURI);
	        // SOAP Body
	        SOAPBody soapBody = envelope.getBody();
	        SOAPElement soapBodyElem = soapBody.addChildElement("submitXMLCommand", "urn");
	        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("xmlRequest");
	        SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("Summit");
	        SOAPElement soapBodyElem3 = soapBodyElem2.addChildElement("Spectrum");
	        SOAPElement soapBodyElem4 = soapBodyElem3.addChildElement("CommandRq");
	        SOAPElement soapBodyElem5 = soapBodyElem4.addChildElement("RequestHeader");
	        SOAPElement soapBodyElem6 = soapBodyElem5.addChildElement("Teller");
	        SOAPElement soapBodyElem7 = soapBodyElem6.addChildElement("ID");
	        SOAPElement soapBodyElem8 = soapBodyElem5.addChildElement("Override");
	        SOAPElement soapBodyElem9 = soapBodyElem4.addChildElement("FLAGRq");
	        
	        SOAPElement soapBodyElem10 = soapBodyElem9.addChildElement("Account");
	        SOAPElement soapBodyElem11 = soapBodyElem9.addChildElement("Suffix");
	        SOAPElement soapBodyElem12 = soapBodyElem9.addChildElement("Surname");
	        SOAPElement soapBodyElem13 = soapBodyElem9.addChildElement("FlagSetOrClear1");
	        SOAPElement soapBodyElem14 = soapBodyElem9.addChildElement("FlagLevel1");
	        SOAPElement soapBodyElem15 = soapBodyElem9.addChildElement("FlagType1");
	        SOAPElement soapBodyElem16 = soapBodyElem9.addChildElement("FlagNum1");
	        SOAPElement soapBodyElem17 = soapBodyElem9.addChildElement("ReasonNum1");
	        
	        soapBodyElem7.setTextContent("INI11");
	        soapBodyElem8.setTextContent("0");

	        soapBodyElem10.setTextContent("12345");
	        soapBodyElem11.setTextContent("00");
	        soapBodyElem12.setTextContent("ZZ");
	        soapBodyElem13.setTextContent("S");
	        soapBodyElem14.setTextContent("M");
	        soapBodyElem15.setTextContent("C");
	        soapBodyElem16.setTextContent("69");
	        
	        soapBodyElem2.setAttribute("xmlns", "http://summit.fiserv.com");
	        soapBodyElem2.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
	        soapBodyElem2.setAttribute("xsi:schemaLocation", "http://summit.fiserv.com/cfg/CommandSchema/sisCommands.xsd");


	        MimeHeaders headers = soapMessage.getMimeHeaders();
//	        headers.addHeader("SOAPAction", serverURI  + "url:submitXMLCommand");
	        headers.addHeader("SOAPAction",  "urn:submitXMLCommand");
	        headers.addHeader("Content-Type",  "text/xml; charset=utf-8");
	        soapMessage.saveChanges();

	        /* Print the request message */
	        System.out.println("Request SOAP Message = ");
	        soapMessage.writeTo(System.out);
	        System.out.println();

	        return soapMessage;
	    }

	 
	 
	/**
	 * Starting point for the SAAJ - SOAP Client Testing
	 */
	public static void main(String args[]) {
		try {

			
			//1. DEMO
//			 try {
//		            // Create SOAP Connection
//		            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//		            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
//
//		            // Send SOAP Message to SOAP Server
//		            String url = "http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx";
//		            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);
//
//		            // Process the SOAP Response
//		            printSOAPResponse(soapResponse);
//
//		            soapConnection.close();
//		        } catch (Exception e) {
//		            System.err.println("Error occurred while sending SOAP Request to Server");
//		            e.printStackTrace();
//		        }
			
			//2. test
			 try {
		            // Create SOAP Connection
		            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
		            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
		            // Send SOAP Message to SOAP Server
		            String url = UtilsConfig.getVal("sscu_pathways_server").toString();
		            SOAPMessage soapResponse = soapConnection.call(createPathwaysSOAPRequest(), url);

		            // Process the SOAP Response
		            printSOAPResponse(soapResponse);

		            soapConnection.close();
		        } catch (Exception e) {
		            System.err.println("Error occurred while sending SOAP Request to Server");
		            e.printStackTrace();
		        }
//			
			
			
		} catch (Exception e) {
			System.err.println("Error occurred while sending SOAP Request to Server");
			e.printStackTrace();
		}
	}



}



