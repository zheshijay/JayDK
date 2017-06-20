package soap.test;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class PathwayTest_encode {
	
	private static String tokenId = "INI11";
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


	//	  private static SOAPMessage createSOAPRequest() throws Exception {
	//	        MessageFactory messageFactory = MessageFactory.newInstance();
	//	        SOAPMessage soapMessage = messageFactory.createMessage();
	//	        SOAPPart soapPart = soapMessage.getSOAPPart();
	//
	//	        String serverURI = "http://ws.cdyne.com/";
	//
	//	        // SOAP Envelope
	//	        SOAPEnvelope envelope = soapPart.getEnvelope();
	//	        envelope.addNamespaceDeclaration("example", serverURI);
	//
	//	        /*
	//	        Constructed SOAP Request Message:
	//	        <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
	//	            <SOAP-ENV:Header/>
	//	            <SOAP-ENV:Body>
	//	                <example:VerifyEmail>
	//	                    <example:email>mutantninja@gmail.com</example:email>
	//	                    <example:LicenseKey>123</example:LicenseKey>
	//	                </example:VerifyEmail>
	//	            </SOAP-ENV:Body>
	//	        </SOAP-ENV:Envelope>
	//	         */
	//
	//	        // SOAP Body
	//	        SOAPBody soapBody = envelope.getBody();
	//	        SOAPElement soapBodyElem = soapBody.addChildElement("VerifyEmail", "example");
	//	        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("email", "example");
	//	        soapBodyElem1.addTextNode("mutantninja@gmail.com");
	//	        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("LicenseKey", "example");
	//	        soapBodyElem2.addTextNode("123");
	//
	//	        MimeHeaders headers = soapMessage.getMimeHeaders();
	//	        headers.addHeader("SOAPAction", serverURI  + "VerifyEmail");
	//
	//	        soapMessage.saveChanges();
	//
	//	        /* Print the request message */
	//	        System.out.println("Request SOAP Message = ");
	//	        soapMessage.writeTo(System.out);
	//	        System.out.println();
	//
	//	        return soapMessage;
	//	    }

	private static SOAPMessage createPathwaysSOAPRequest() throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		String serverURI = "urn:connections.spectrum.summitsite.com";

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("urn", serverURI);

		/*
	        Constructed SOAP Request Message:
	       <?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope
    xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
    xmlns:urn="urn:connections.spectrum.summitsite.com"
    xmlns:xsd="http://www.w3.org/2001/XMLSchema"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">
    <soapenv:Header/>
    <soapenv:Body>
        <urn:submitXMLCommand>
            <xmlRequest>
                <Summit
                    xmlns="http://summit.fiserv.com"
                    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://summit.fiserv.com/cfg/CommandSchema/sisCommands.xsd">
                    <Spectrum>
                        <CommandRq>
                            <RequestHeader>
                                <Teller>
                                    <ID>INI11</ID>
                                </Teller>
                                <Override>0</Override>
                            </RequestHeader>
                            <FLAGRq>
                                <Account>26145</Account>
                                <Suffix>00</Suffix>
                                <Surname>ZZ</Surname>
                                <FlagSetOrClear1>S</FlagSetOrClear1>
                                <FlagLevel1>M</FlagLevel1>
                                <FlagType1>C</FlagType1>
                                <FlagNum1>69</FlagNum1>
                                <ReasonNum1></ReasonNum1>
                            </FLAGRq>
                        </CommandRq>
                    </Spectrum>
                </Summit>
            </xmlRequest>
        </urn:submitXMLCommand>
    </soapenv:Body>
</soapenv:Envelope>

		 */

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

		soapBodyElem10.setTextContent("26145");
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

	public static Document prepareFLAGRequest(String accountNo, String surname, String suffix,
			String flagInd,	String flagLevel, 
			String flagType, String reasonNum){
		Document xmlDoc = null;
		Element element = null;

		try {

			//Default values: surname=ZZ, suffix=00, flagLevel1=M, flagType1=C, FlagNum1=69, flagInd1 = S/C
			//if (flagLevel==null) flagLevel="M";
			//if (flagType==null)  flagType="C";
			if ((surname==null) || StringUtils.isEmpty(surname) || StringUtils.isBlank(surname) ){
				surname= InstantConstants.SURNAME_DEFAULT; 
			}
			suffix    = InstantConstants.SUFFIX_DEFAULT;  
			flagLevel = InstantConstants.FLAGLEVEL1_DEFAULT; 
			flagType  = InstantConstants.FLAGTYPE1_DEFAULT;  
			reasonNum = InstantConstants.REASONNUM_DEFAULT; 

			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append("<Summit xmlns=\"http://summit.fiserv.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://summit.fiserv.com/cfg/CommandSchema/sisCommands.xsd\">");
			strBuilder.append("<Spectrum><CommandRq><RequestHeader><Teller><ID>");
			strBuilder.append(tokenId);
			strBuilder.append("</ID></Teller><Override>0</Override></RequestHeader>");
			strBuilder.append(InstantConstants.FLAGRQ_START);
			strBuilder.append("<Account>");
			strBuilder.append(accountNo);
			strBuilder.append("</Account>");        		
			strBuilder.append("<Suffix>");
			strBuilder.append(suffix);
			strBuilder.append("</Suffix>");
			strBuilder.append("<Surname>"); 
			strBuilder.append(surname);
			strBuilder.append("</Surname>");
			strBuilder.append("<FlagSetOrClear1>"); 
			strBuilder.append(flagInd);
			strBuilder.append("</FlagSetOrClear1>");
			strBuilder.append("<FlagLevel1>"); 
			strBuilder.append(flagLevel);
			strBuilder.append("</FlagLevel1>");
			strBuilder.append("<FlagType1>");
			strBuilder.append(flagType);
			strBuilder.append("</FlagType1>");
			strBuilder.append("<FlagNum1>"); 
			strBuilder.append(InstantConstants.FLAGNUM1_DEFAULT);
			strBuilder.append("</FlagNum1>");
			strBuilder.append("<ReasonNum1>"); 
			strBuilder.append(reasonNum);
			strBuilder.append("</ReasonNum1>");
			strBuilder.append(InstantConstants.FLAGRQ_END);
			strBuilder.append("</CommandRq></Spectrum></Summit>");
			System.out.println("XMLRequest=" + strBuilder);
			/************** Sample XML request - Input data ********************
<FLAGRq>
<Account>1234</Account>
<Suffix>00</Suffix>
<Surname>CL</Surname>
<FlagSetOrClear1>S</FlagSetOrClear1>
<FlagLevel1>M</FlagLevel1>
<FlagType1>C</FlagType1>
<FlagNum1>12</FlagNum1>
<ReasonNum1></ReasonNum1>
</FLAGRq>
			 ******************************************************/
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setNamespaceAware(true);
			DocumentBuilder docBuilder  = factory.newDocumentBuilder();
			DOMImplementation impl = docBuilder.getDOMImplementation();

			// Set root element
			xmlDoc = impl.createDocument(InstantConstants.NAMESPACE_URI, InstantConstants.NAMESPACE_PREFIX + ":Envelope", null);                      
			Element rootElement = xmlDoc.getDocumentElement();
			rootElement.setAttributeNS(InstantConstants.SOAP_ATTRIB_NS, "xmlns:" + InstantConstants.NAMESPACE_PREFIX, InstantConstants.NAMESPACE_URI);
			rootElement.setAttributeNS(InstantConstants.SOAP_ATTRIB_NS, "xmlns:xsi", InstantConstants.SOAP_XSI_NS);
			rootElement.setAttributeNS(InstantConstants.SOAP_ATTRIB_NS, "xmlns:xsd", InstantConstants.SOAP_XML_NS);
			rootElement.setAttributeNS(InstantConstants.SOAP_ATTRIB_NS, "xmlns:urn", InstantConstants.SOAP_PATHWAYS_NS2_NS);

			// Set header/body elements
			Element header = xmlDoc.createElement(InstantConstants.NAMESPACE_PREFIX + ":Header");
			rootElement.appendChild(header);

			Element body = xmlDoc.createElement(InstantConstants.NAMESPACE_PREFIX + ":Body");
			rootElement.appendChild(body);
			// Set xmlRequest element - FLAG command 
			Element elementCmd = xmlDoc.createElement("urn:submitXMLCommand");
			body.appendChild(elementCmd);
			element = xmlDoc.createElement("xmlRequest");
			element.appendChild(xmlDoc.createTextNode(strBuilder.toString()));
			elementCmd.appendChild(element);
			return xmlDoc;


		} catch (ParserConfigurationException e) {
			System.out.println("RequestParserComponent XML parse error: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("RequestParserComponent Exeption: " + e.getMessage());
		}
		return null;    	
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
//			try {
//				// Create SOAP Connection
//				SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
//				SOAPConnection soapConnection = soapConnectionFactory.createConnection();
//
//				// Send SOAP Message to SOAP Server
//				String url = "https://pwd.safecu.org/estatements/wsiservices/CmdSpectrum";
//				SOAPMessage soapResponse = soapConnection.call(createPathwaysSOAPRequest(), url);
//
//				// Process the SOAP Response
//				printSOAPResponse(soapResponse);
//
//				soapConnection.close();
//			} catch (Exception e) {
//				System.err.println("Error occurred while sending SOAP Request to Server");
//				e.printStackTrace();
//			}
			//			
			
			//3. encode request
			Document docReq = PathwayTest_encode.prepareFLAGRequest("12345", "ZZ", "00", null, "M", "C", null);
			
			 MessageFactory msgFactory = MessageFactory.newInstance();
			 SOAPMessage message = msgFactory.createMessage();
			 SOAPBody soapBody = message.getSOAPBody();




		} catch (Exception e) {
			System.err.println("Error occurred while sending SOAP Request to Server");
			e.printStackTrace();
		}
	}



}



