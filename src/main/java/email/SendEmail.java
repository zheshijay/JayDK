package email;

//File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail
{
	public static void main(String [] args)
	{    
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		// Recipient's email ID needs to be mentioned.
		String to = "Zhe.Shi@infoimageinc.com";

		// Sender's email ID needs to be mentioned
		String from = "zheshijay@gmail.com";

		// Assuming you are sending email from localhost
//		String host = "10.8.8.17";

		//DR
//		String host = "10.9.2.37";
		String host= "10.8.9.56";
//		String host= "10.8.9.145";
//		String host = "mailbox-prod01.infoimageinc.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
//		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "25");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.user", "pdadmin");
		properties.setProperty("mail.smtp.password", "p@ssw0rd");
		
		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("This is the Subject Line!");

			// Now set the actual message
			message.setText("This is actual message");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		}catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}