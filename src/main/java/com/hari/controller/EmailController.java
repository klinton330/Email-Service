package com.hari.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hari.dto.SendEmailDto;
import com.hari.service.EmailSevice;

@RestController
@RequestMapping("v1/email/")
public class EmailController {

	@Autowired
	private EmailSevice emailService;

	@PostMapping("/sendemail")
	public ResponseEntity<String> sendEmail(@RequestBody SendEmailDto sendEmailDto) {
		String result = emailService.emailSending(sendEmailDto);
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}

}
