package bankingApplication;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Random;

public class BankOTP2 {

	public static String sendOTP(String to) {
		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";
		String numbers = "0123456789";

		// Using random method
		Random rndm_method = new Random();
		char[] otp = new char[6];

		for (int i = 0; i < 6; i++) {
			
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		

		// Get the Session object and pass username and password
		Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("redacted", "redacted");
			}
		});

		// Used to debug SMTP issues
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress("redacted"));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("OTP");

			// Now set the actual message
			
			message.setText(otp.toString());
		
			System.out.println("sending...");
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
			
		} catch (MessagingException mex) {
			//mex.printStackTrace();
		}
		return otp.toString();		
	}
}
