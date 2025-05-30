package com.mailweb.emailsender.sevices;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@Service
public class EmailSeviceController implements EmailService{

    private JavaMailSender javaMailSender;

    public EmailSeviceController(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    //Send mail to single person
    @Override
    public void sendEmail(String to, String sub, String msg) {
        try {
            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(to);
            email.setSubject(sub);
            email.setText(msg);
            email.setFrom("daudiaom@gmail.com");
            javaMailSender.send(email);
            System.out.println("email send");
        } catch (MailException e) {
            System.out.println("Error in single sendEmail method");
        }
    }

    //Send mail with document to single person
    @Override
    public void sendEmail(String to, String sub, String msg, MultipartFile file) {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setTo(to);
            helper.setSubject(sub);
            helper.setText(msg);
            helper.setFrom("daudiaom@gmail.com");

            // Attach the file
            if (file != null && !file.isEmpty()) {
                helper.addAttachment(file.getOriginalFilename(), file);
            }

            javaMailSender.send(mimeMessage);
            System.out.println("Email with attachment sent.");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
