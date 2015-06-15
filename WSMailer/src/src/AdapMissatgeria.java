package src;

import java.util.*; 
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class AdapMissatgeria {
	private Integer id;
	private Integer punt;
	private String mail;
	public void enviarMissatge(Integer id, Integer punt, String mail)
	{
		String missatge = "Partida amb id "+id+" ha obtingut "+punt+" punts";
		
		 // Recipient's email ID needs to be mentioned.
	      String to = mail;

	      // Sender's email ID needs to be mentioned
	      String from = "joc2048@as.com";

	      // Assuming you are sending email from localhost
	      String host = "localhost";

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

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
	         message.setSubject("Resultats joc 2048!");

	         // Now set the actual message
	         message.setText(missatge);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }

	}
}
