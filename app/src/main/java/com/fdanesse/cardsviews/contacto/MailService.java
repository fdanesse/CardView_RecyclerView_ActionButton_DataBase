package com.fdanesse.cardsviews.contacto;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

/**
 * Created by flavio on 16/01/17.
 */
public class MailService {
    // http://mrbool.com/how-to-work-with-java-mail-api-in-android/27800

    public void sendEmail(String correo, String password, String mensaje) throws AddressException, MessagingException {

        String host = "smtp.gmail.com";
        String address = correo;

        String from = correo;
        String pass = password;

        String to = "notenemos@mail.com";

        Multipart multiPart;
        String finalString = "";

        Properties props = System.getProperties();

        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", address);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props, null);
        DataHandler handler = new DataHandler(new ByteArrayDataSource(finalString.getBytes(), "text/plain"));

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setDataHandler(handler);

        multiPart = new MimeMultipart();
        InternetAddress toAddress;
        toAddress = new InternetAddress(to);

        message.addRecipient(Message.RecipientType.TO, toAddress);

        message.setSubject("Mensaje de prueba");
        message.setContent(multiPart);
        message.setText(mensaje);

        Transport transport = session.getTransport("smtp");

        transport.connect(host, address, pass);

        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
