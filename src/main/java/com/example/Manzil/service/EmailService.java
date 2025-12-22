package com.example.Manzil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail(String toMail, String subject, String message) {

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(toMail);
        mail.setSubject(subject);
        mail.setFrom("yourgmail@gmail.com");
        mail.setText(message);

        javaMailSender.send(mail);
    }
}
