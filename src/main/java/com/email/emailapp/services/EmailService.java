package com.email.emailapp.services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Properties;

@Service
public class EmailService {

    // email with attachment
    public void sendEmailWithAttachment( String to, String from, String subject,String message) {

        // setting properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Step.1: getting the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("omparkashsarangani@gmail.com", "parkash");
            }
        });
        session.setDebug(true);
        // Step 2. composing the message, may include[text, multimedia]
        MimeMessage mimeMessage = new MimeMessage(session);
        try {

            String filePath = "C:\\Users\\Parkash\\Desktop\\profile.jpeg";
            mimeMessage.setFrom(from);
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject(subject);

            // creating mimeMiltipart for multipart data
            MimeMultipart mimeMultipart = new MimeMultipart();

            // for text part
            MimeBodyPart textMimeBodyPart = new MimeBodyPart();
            textMimeBodyPart.setText(message);

//            // for attachment/file part
            MimeBodyPart fileMimeBodyPart = new MimeBodyPart();
            fileMimeBodyPart.attachFile(new File(filePath));

            // adding both to multipart
            mimeMultipart.addBodyPart(textMimeBodyPart);
            mimeMultipart.addBodyPart(fileMimeBodyPart);

            mimeMessage.setContent(mimeMultipart);

            // Step.3 Sending the email using transport class
            Transport.send(mimeMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // email with text messages only
    public String sendEmail(String to,  String from, String subject, String message) {

        // setting properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Step.1: getting the session object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("programmerparkash@gmail.com", "fmdqwxdxozcsywly");
            }
        });
        session.setDebug(true);
        // Step 2. composing the message, may include[text, multimedia]
        MimeMessage mimeMessage = new MimeMessage(session);
        try {

            mimeMessage.setFrom(from);
            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            // Step.3 Sending the email using transport class
            Transport.send(mimeMessage);
            return "Email sent!";

        } catch (Exception e) {
            e.printStackTrace();
            return "Email sending failed!";
        }
    }

}
