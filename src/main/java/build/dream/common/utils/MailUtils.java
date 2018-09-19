package build.dream.common.utils;

import build.dream.common.constants.Constants;
import com.sun.mail.util.MailSSLSocketFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailUtils {
    private static JavaMailSender javaMailSender;

    private static JavaMailSender obtainJavaMailSender() {
        if (javaMailSender == null) {
            javaMailSender = ApplicationHandler.getBean(JavaMailSender.class);
        }
        return javaMailSender;
    }

    public static MimeMessage createMimeMessage() {
        return obtainJavaMailSender().createMimeMessage();
    }

    public static MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
        return obtainJavaMailSender().createMimeMessage(contentStream);
    }

    public static void send(MimeMessage mimeMessage) throws MailException {
        obtainJavaMailSender().send(mimeMessage);
    }

    public static void send(MimeMessage... mimeMessages) throws MailException {
        obtainJavaMailSender().send(mimeMessages);
    }

    public static void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {
        obtainJavaMailSender().send(mimeMessagePreparator);
    }

    public static void send(MimeMessagePreparator... mimeMessagePreparators) throws MailException {
        obtainJavaMailSender().send(mimeMessagePreparators);
    }

    public static void send(SimpleMailMessage simpleMessage) throws MailException {
        obtainJavaMailSender().send(simpleMessage);
    }

    public static void send(SimpleMailMessage... simpleMessages) throws MailException {
        obtainJavaMailSender().send(simpleMessages);
    }

    public static void main(String[] args) throws MessagingException, GeneralSecurityException {
        Properties properties = new Properties();

        MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
        mailSSLSocketFactory.setTrustAllHosts(true);

        properties.put(Constants.MAIL_SMTP_SSL_ENABLE, true);
        properties.put(Constants.MAIL_SMTP_SSL_SOCKET_FACTORY, mailSSLSocketFactory);
        properties.put(Constants.MAIL_SMTP_TIMEOUT, 5000);
        Session session = Session.getInstance(properties);
        Store store = session.getStore("pop3");
        store.connect("pop3.mxhichina.com", "liuyandong@smartpos.top", "Liu963733540");

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);

        int messageCount = folder.getMessageCount();

        Message[] messages = folder.getMessages(messageCount - 10, messageCount);
        for (Message message : messages) {
            MimeMessage mimeMessage = (MimeMessage) message;

            Address[] addresses = mimeMessage.getFrom();
            InternetAddress internetAddress = (InternetAddress) addresses[0];
            String address = internetAddress.getAddress();
            String messageId = mimeMessage.getMessageID();
            System.out.println(address);
            System.out.println(messageId);
        }

        folder.close();
        store.close();
    }
}
