/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppppppp;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author PUSAKR
 */
public class Mail {
      public static void sendEmail(String recipient, String subject, String textMessage) {
        final String senderEmail = "puskarnath110@gmail.com"; // Replace with your Gmail
        final String senderPassword = "fhdn pjry bcbb uywf"; // Use app password (not your Gmail password)

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            message.setSubject(subject);
            message.setText(textMessage);
            Transport.send(message);
            System.out.println("OTP sent successfully to " + recipient);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
