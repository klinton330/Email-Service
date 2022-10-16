package com.hari.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.hari.dto.SendEmailDto;

@Service
public class EmailSevice {

	@Autowired
	private JavaMailSender javaMailSender;

	public String emailSending(SendEmailDto sendEmailDto) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(sendEmailDto.getTo());
		simpleMailMessage.setFrom(sendEmailDto.getFrom());
		simpleMailMessage.setSubject(sendEmailDto.getSubject());
		simpleMailMessage.setText(sendEmailDto.getText());

		javaMailSender.send(simpleMailMessage);
		return "Email sent successfully";
	}

}
