package email;

//File Name SendEmail.java

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmailVTwo
{
	
	public static void main(String[] args) {

	final String username = "zheshijay@gmail.com";
	final String password = "Lebron@23";

	Properties props = new Properties();
	props.put("mail.smtp.auth", "false");
	props.put("mail.smtp.starttls.enable", "false");
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "587");

	Session session = Session.getInstance(props,
			new javax.mail.Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
		}
	});

	try {

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("from-email@gmail.com"));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("to-email@gmail.com"));
		message.setSubject("Testing Subject");
		message.setText("Dear Mail Crawler,"
				+ "\n\n No spam to my email, please!");

		Transport.send(message);

		System.out.println("Done");

	} catch (MessagingException e) {
		throw new RuntimeException(e);
	}
}
}