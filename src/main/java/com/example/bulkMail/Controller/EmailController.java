package com.example.bulkMail.Controller;

import com.example.bulkMail.Dto.EmailRequest;
import com.example.bulkMail.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    
    @PostMapping("/send-bulk")
    public String sendBulkEmail(@RequestBody EmailRequest request){
        emailService.sendBulkEmail(request);
        return "Bulk Email Sent Successfully";
    }
}
