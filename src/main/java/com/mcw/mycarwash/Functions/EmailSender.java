package com.mcw.mycarwash.Functions;


import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {


    public void sendMail(String fromMail, String toMail, String mailBody) {

        Thread th;
        th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Properties props;
                    props = System.getProperties();
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.enable", "false");
                    props.put("mail.smtp.host", "mail.moviemeniya.com");
                    props.put("mail.smtp.port", "587");
                    // props.put("mail.debug", "true");
                    final String username = "admin@moviemeniya.com";//
                    final String password = "Rwpc940936hgN";
                    Session session = Session.getInstance(props,
                            new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                }
                            });
                    InternetAddress addressFrom = new InternetAddress(username, "My Car Wash");
                    Message message = new MimeMessage(session);
                    MimeMultipart multipart = new MimeMultipart();
                    BodyPart htmlBodyPart = new MimeBodyPart();
                    htmlBodyPart.setContent(mailBody, "text/html");
                    multipart.addBodyPart(htmlBodyPart);
                    message.setContent(multipart);
                    message.setFrom(new InternetAddress("admin@moviemeniya.com"));
                    message.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
                    message.setSubject("One Time Password (OTP) Confirmation");
                    message.setFrom(addressFrom);
                    Transport transport;
                    transport = session.getTransport("smtp");
                    transport.send(message);
                    System.out.println("Send Mail to " + toMail);
                } catch (UnsupportedEncodingException | MessagingException ex) {
                    Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        th.start();


    }


}
