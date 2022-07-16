package com.dailycodebuffer.springEmailClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SpringEmailClientApplication {
	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailClientApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() throws MessagingException {
//		service.sendSimpleEmail("ranjeevrock1@gmail.com",
//				"This is the Email Body..",
//				"This is the email subject");

		service.sendEmailWithAttachment("ranjeev.kumar@mgtechsoft.com",
				"<ul><li>1</li><li>2</li></ul>",
				"Attachment test",
				"C:\\Users\\HP\\Downloads\\Jun_1_slip.jpeg");
	}


}
