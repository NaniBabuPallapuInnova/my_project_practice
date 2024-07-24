package com.example.insurance_project.controller;

import com.example.insurance_project.entity.EmailDetails;
import com.example.insurance_project.mail_services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/simpleMail")
    public String sendSimpleMail(@RequestBody EmailDetails emailDetails){
        return emailService.sendSimpleMail(emailDetails);
    }

    @PostMapping("/attachmentMail")
    public String sendMailWithAttachment(@RequestBody EmailDetails emailDetails){
        return emailService.sendWithAttachmentMail(emailDetails);
    }
}
