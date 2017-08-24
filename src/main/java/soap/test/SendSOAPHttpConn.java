package soap.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import config.UtilsConfig;

public class SendSOAPHttpConn {
	
	private static String tokenId = "INI11";
	
	public static String prepareFLAGRequest(String accountNo, String surname, String suffix,
			String flagInd,	String flagLevel, 
			String flagType, String reasonNum){
		StringBuilder strBuilder = new StringBuilder();
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
<Account>9729</Account>
<Suffix>00</Suffix>
<Surname>CL</Surname>
<FlagSetOrClear1>S</FlagSetOrClear1>
<FlagLevel1>M</FlagLevel1>
<FlagType1>C</FlagType1>
<FlagNum1>69</FlagNum1>
<ReasonNum1></ReasonNum1>
</FLAGRq>
			 ******************************************************/
		}catch (Exception e) {
			System.out.println("RequestParserComponent Exeption: " + e.getMessage());
		}
		return strBuilder.toString();    	
	}
	
	public static void main(String[] args){
	
		try {
			String url = UtilsConfig.getVal("url").toString();
			URL oURL = new URL(url);
			HttpURLConnection con = (HttpURLConnection) oURL.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-type", "text/xml; charset=utf-8");
			con.setRequestProperty("SOAPAction", "urn:submitXMLCommand");
			con.setDoOutput(true);

			String reqFront = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:urn=\"urn:connections.spectrum.summitsite.com\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Header/><soapenv:Body><urn:submitXMLCommand><xmlRequest>";
			String reqEnd = "</xmlRequest></urn:submitXMLCommand></soapenv:Body></soapenv:Envelope>";
//			String summit = "&lt;Summit xmlns=\"http://summit.fiserv.com\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://summit.fiserv.com/cfg/CommandSchema/sisCommands.xsd\"&gt;&lt;Spectrum&gt;&lt;CommandRq&gt;&lt;RequestHeader&gt;&lt;Teller&gt;&lt;ID&gt;INI11&lt;/ID&gt;&lt;/Teller&gt;&lt;Override&gt;0&lt;/Override&gt;&lt;/RequestHeader&gt;&lt;FLAGRq&gt;&lt;Account&gt;26145&lt;/Account&gt;&lt;Suffix&gt;00&lt;/Suffix&gt;&lt;Surname&gt;ZZ&lt;/Surname&gt;&lt;FlagSetOrClear1&gt;S&lt;/FlagSetOrClear1&gt;&lt;FlagLevel1&gt;M&lt;/FlagLevel1&gt;&lt;FlagType1&gt;C&lt;/FlagType1&gt;&lt;FlagNum1&gt;69&lt;/FlagNum1&gt;&lt;ReasonNum1&gt;&lt;/ReasonNum1&gt;&lt;/FLAGRq&gt;&lt;/CommandRq&gt;&lt;/Spectrum&gt;&lt;/Summit&gt;";

			String summit = SendSOAPHttpConn.prepareFLAGRequest("12345", "ZZ", "00", null, "M", "C", null);
			String encodedSummit = StringEscapeUtils.escapeXml(summit);
			
			System.out.println("summit is: " + summit);
			System.out.println("after encoding summit is: " + encodedSummit);
	
			String reqXML = reqFront + encodedSummit + reqEnd;
			
			
			System.out.println("Request is: " + reqXML);
			
			
			OutputStream reqStream = con.getOutputStream();
			reqStream.write(reqXML.getBytes());

			InputStream resStream = con.getInputStream();
			
			String myString = IOUtils.toString(resStream, "UTF-8");
			System.out.println("Response is: " + myString);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
