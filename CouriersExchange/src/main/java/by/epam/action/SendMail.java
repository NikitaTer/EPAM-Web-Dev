package by.epam.action;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.stream.Collectors;

public class SendMail {

    private static final Logger logger = LogManager.getLogger();

    public static void sendSignUpVerify(String to, String login, String code) {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(MailData.SERVER_MAIL, MailData.SERVER_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(MailData.SERVER_MAIL));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Verify message");

            String text = Files.lines(Paths.get(MailData.VERIFY_MESSAGE_PATH)).collect(Collectors.joining());
            text = text.replace("%LOGIN%", login);
            text = text.replace("%CODE%", code);

            message.setText(text);
            Transport.send(message);
            logger.info("Message to " + to + " was successfully sent");
        } catch (MessagingException e) {
            logger.error(e.getMessage());
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
