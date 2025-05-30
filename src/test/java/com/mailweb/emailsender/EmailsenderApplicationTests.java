package com.mailweb.emailsender;

import com.mailweb.emailsender.sevices.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailsenderApplicationTests {

	@Autowired
	private EmailService mail;
	@Test
	void contextLoads() {
//		mail.sendEmail("daudiaom@gmail.com","test","hello om");
	}

}
