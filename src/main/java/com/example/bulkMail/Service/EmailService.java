package com.example.bulkMail.Service;

import com.example.bulkMail.Dto.EmailRequest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSenderImpl mailSender;
    private JavaMailSender javaMailSender;

    public EmailService(JavaMailSenderImpl mailSender) {
        this.mailSender = mailSender;
    }

    public void sendBulkEmail(EmailRequest request){
        for (String email : request.getEmails()){
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email);
            message.setSubject(request.getSubject());
            message.setText(request.getBody());
            
            mailSender.send(message);            
        }
    }
}
