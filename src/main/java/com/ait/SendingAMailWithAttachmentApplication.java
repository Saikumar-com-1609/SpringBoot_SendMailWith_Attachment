package com.ait;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.ait.email.EmailSend;

@SpringBootApplication
public class SendingAMailWithAttachmentApplication {
	
	@Autowired
	private EmailSend emailsend;

	public static void main(String[] args) {
		SpringApplication.run(SendingAMailWithAttachmentApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void triggerEmail() throws MessagingException{
		String toEmail;
		String body;
		String subject;
		String attachment;
		
		emailsend.sendMailWithAttachment(toEmail="thummagunta.saikumar@gmail.com",
				body="Hi,"
				
			    	+ "Please find my Attachment",
				subject="This is email with Attachment",
				attachment="C:\\Users\\test\\OneDrive\\Pictures\\Screenshots\\photo.jpeg");
	}
	
}
