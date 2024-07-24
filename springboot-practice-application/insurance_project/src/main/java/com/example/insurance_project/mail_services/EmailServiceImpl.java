package com.example.insurance_project.mail_services;

import com.example.insurance_project.entity.EmailDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Objects;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderUsername;

    @Override
    public String sendSimpleMail(EmailDetails emailDetails) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(senderUsername);
            simpleMailMessage.setTo(emailDetails.getRecipient());
            simpleMailMessage.setSubject(emailDetails.getSubject());
            simpleMailMessage.setText(emailDetails.getMessageBody());

            javaMailSender.send(simpleMailMessage);
            return "Mail Sent Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Exception Occurred While Sending Mail";
        }

    }

    @Override
    public String sendWithAttachmentMail(EmailDetails emailDetails) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(senderUsername);
            mimeMessageHelper.setTo(emailDetails.getRecipient());
            mimeMessageHelper.setSubject(emailDetails.getSubject());
            mimeMessageHelper.setText(emailDetails.getMessageBody());
            FileSystemResource fileSystemResource = new FileSystemResource(new File(emailDetails.getAttachment()));
            mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()), fileSystemResource);

            javaMailSender.send(mimeMessage);
            return "Mail Sent Successfully";

        } catch (MessagingException e) {
            return "Exception Occurred While Sending Mail";
        }
    }
}
