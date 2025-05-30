package com.mailweb.emailsender;

import com.mailweb.emailsender.sevices.EmailSeviceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;

@Controller
public class MyController {
    @Autowired
    private EmailSeviceController emailService;

    @GetMapping("/email")
    public String email_page(Model model){
        model.addAttribute("from","daudiaom@gmail.com");
        return "email_page";
    }

    @PostMapping("/sendemail")
    public String sendEmail(@RequestParam("to") String to,
                            @RequestParam("subject") String subject,
                            @RequestParam("message") String message,
                            @RequestParam("file") MultipartFile file) {

        try {
            if (file != null && !file.isEmpty()) {
                emailService.sendEmail(to, subject, message, file);
            } else {
                emailService.sendEmail(to, subject, message);
            }
            System.out.println("Mail send");
        } catch (Exception e) {
            System.out.println("Mail Not send - "+e.toString());
        }

        return "redirect:/email";
    }
}
