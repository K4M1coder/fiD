package fr.lefournildesprovinces.ressources.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public SendMailTLS(String to, String subject, String main) {

		final String from = "comptemailquienvoie";
		final String username = "loginducomptemailquienvoie";
		final String password = "motdepasseducomptemailquienvoie";
		final String smtp = "smtp.gmail.com ou celui du serveur interne";

		String tmpTO = to;
		if (to == null) {
			tmpTO = "destinataire par default si aucun précisé : bal communication";
		}
		final String dest = tmpTO;
		final String title = subject;
		final String body = main;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", smtp);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(dest));
			message.setSubject(title);
			message.setText(body);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}