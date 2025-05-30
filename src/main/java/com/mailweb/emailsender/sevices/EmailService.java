package com.mailweb.emailsender.sevices;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface EmailService {
    //single person email
    void sendEmail(String to, String sub, String msg);

    //multiple person email
//    void sendEmail(String []to, String sub, String msg);

    //send email with file
    void sendEmail(String to, String sub, String msg, MultipartFile file);


}

