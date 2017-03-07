package tool;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;

public class EmailTool {
	private static final String user="tsintian@126.com";
	private static final String token="authcoe123";
	
	
	/**
	 * Sends Email use my default information.
	 * @param subject
	 * @param message
	 */
	public static void sendEmail(String subject,String message){
		String recipient="1010318417@qq.com";
		String sender="tsintian@126.com";
		String host="smtp.126.com";
		String fileName=null;
		
		boolean debug=false;
		sendEmail(recipient,sender,host,fileName,message,subject,debug);
		
	}
	
	/**
	 * 
	 * @param recipient
	 * @param sender
	 * @param host
	 * @param fileName
	 * @param message
	 * @param subject
	 * @param debug 
	 */
	public static void sendEmail(String recipient,String sender,String host,
			String fileName,String message,String subject,boolean debug){
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", true);
		
		Authenticator auth= new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user,token);
			}
			
		};
		
		Session session = Session.getInstance(props, auth);
		session.setDebug(debug);
		
		
		try {
			//Creates a message.
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(sender));
			
			InternetAddress[] address = {new InternetAddress(recipient)};
			msg.setRecipients(RecipientType.TO, recipient);
			msg.setSubject(subject);
			
			//Creates and fills the first message.
			MimeBodyPart mbp1 = new MimeBodyPart();
			mbp1.setText(message);
			
			//Creates and fills the second message.
			MimeBodyPart mbp2 = new MimeBodyPart();
			if(fileName != null)
				mbp2.attachFile(fileName);
			
			//Creates multipart and add its parts to it.
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mbp1);
			if(fileName != null)
				mp.addBodyPart(mbp2);
			
			//Adds the multipart to the message.
			msg.setContent(mp);
			
			//sets the Date.
			msg.setSentDate(new Date());
			
			//Sends the message.
			Transport.send(msg);
		} catch (MessagingException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
