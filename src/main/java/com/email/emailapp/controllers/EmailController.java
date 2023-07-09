package com.email.emailapp.controllers;

import com.email.emailapp.models.EmailRequestDto;
import com.email.emailapp.models.EmailResponseDto;
import com.email.emailapp.services.EmailService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EmailController {

    private static final String from = "omparkashsarangani@gmail.com";

    @Autowired
    EmailService emailService;

    @PostMapping("/sendEmail")
    public ResponseEntity<EmailResponseDto> sendEmail(@RequestBody EmailRequestDto requestDto){
        String response = emailService.sendEmail(requestDto.getTo(), from, requestDto.getSubject(), requestDto.getMessage());
        EmailResponseDto responseDto = new EmailResponseDto();
        responseDto.setResponse(response);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
