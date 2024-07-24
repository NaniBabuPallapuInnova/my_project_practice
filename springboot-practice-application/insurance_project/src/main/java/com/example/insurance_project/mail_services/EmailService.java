package com.example.insurance_project.mail_services;

import com.example.insurance_project.entity.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails emailDetails);

    String sendWithAttachmentMail(EmailDetails emailDetails);
}
