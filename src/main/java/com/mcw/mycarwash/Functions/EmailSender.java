package com.mcw.mycarwash.Functions;


import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {


    public static void sendMail(String fromMail, String toMail, String mailBody) {
        try {



            Properties props = System.getProperties();
            props.setProperty("mail.smtp.host", "mail.moviemeniya.com");
            props.setProperty("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.debug", "true");
            props.put("mail.store.protocol", "pop3");
            props.put("mail.transport.protocol", "smtp");
            final String username = fromMail;//
            final String password = "Rwpc940936hgN";

            Session session = Session.getDefaultInstance(props, null);
            InternetAddress addressFrom = new InternetAddress(username, "My Car Wash");
            //Message---------------------
            Message m_massage = new MimeMessage(session);
            m_massage.setFrom(addressFrom);
            m_massage.setSubject("One Time Password (OTP) Confirmation");
            //===================Test==================
            //  m_massage.setContent("<h1>This is actual message</h1>", "text/html");
            MimeMultipart multipart = new MimeMultipart();
            //Create Email Body
            BodyPart htmlBodyPart = new MimeBodyPart();
            // set Email Body - Text
            htmlBodyPart.setContent(mailBody, "text/html");
            multipart.addBodyPart(htmlBodyPart);
            // set Email Body - Image's
            m_massage.setContent(multipart);
            //
            m_massage.saveChanges();
            m_massage.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
            //SLS Enble
            Transport transport;
            transport = session.getTransport("smtp");
            transport.connect("mail.moviemeniya.com", username, password);
            transport.sendMessage(m_massage, m_massage.getAllRecipients());
            transport.close();

        } catch (UnsupportedEncodingException | MessagingException ex) {
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
