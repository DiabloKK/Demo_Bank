package com.demo_bank_v1.mailMessenger;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

public class MailMessenger {

    public static void htmlEmailMessenger(String toMail, String subject, String body) {
        String host = "smtp.gmail.com";
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vokhuong1403@gmail.com", "ysfxkdzpxfbwfosl");
            }
        });
        session.setDebug(true);

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vokhuong1403@gmail.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            message.setSubject(subject);
            message.setContent(body,"text/html");
            Transport.send(message);
        } catch (MessagingException var7) {
            var7.printStackTrace();
        }
    }


}
