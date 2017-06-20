package email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class SendEmail2
{
	public static void main(String [] args)
	{    
		System.setProperty("java.net.preferIPv4Stack" , "true");
		
		// Recipient's email ID needs to be mentioned.
		String to = "zheshijay@hotmail.com";

		// Sender's email ID needs to be mentioned
		String from = "zheshijay@gmail.com";

		String host = "jaymailserver.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
//		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "25");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.user", "blah");
		properties.setProperty("mail.smtp.password", "blah");
		
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