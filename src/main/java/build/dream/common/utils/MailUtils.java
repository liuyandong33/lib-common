package build.dream.common.utils;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;

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
}
