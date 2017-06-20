package soap.test;

import java.net.URLDecoder;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

import config.UtilsConfig;

public class PathwayTest {

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
                                <Account>12345</Account>
                                <Suffix>00</Suffix>
                                <Surname>ZZ</Surname>
                                <FlagSetOrClear1>S</FlagSetOrClear1>
                                <FlagLevel1>M</FlagLevel1>
                                <FlagType1>C</FlagType1>
                                <FlagNum1>12</FlagNum1>
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
			try {
				// Create SOAP Connection
				SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
				SOAPConnection soapConnection = soapConnectionFactory.createConnection();

				// Send SOAP Message to SOAP Server
				String url = UtilsConfig.getVal("url").toString();
				
				System.out.println(createPathwaysSOAPRequest().CHARACTER_SET_ENCODING);
				
				SOAPMessage soapResponse = soapConnection.call(createPathwaysSOAPRequest(), URLDecoder.decode(url, "UTF-8") );

				// Process the SOAP Response
				printSOAPResponse(soapResponse);

				soapConnection.close();
			} catch (Exception e) {
				System.err.println("Error occurred while sending SOAP Request to Server");
				e.printStackTrace();
			}	
		} catch (Exception e) {
			System.err.println("Error occurred while sending SOAP Request to Server");
			e.printStackTrace();
		}
	}
}



