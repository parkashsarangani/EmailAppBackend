package com.email.emailapp.controllers;

import com.email.emailapp.models.EmailRequestDto;
import com.email.emailapp.models.EmailResponseDto;
import com.email.emailapp.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/sendHello")
    public ResponseEntity<String> sendHello(){
        return new ResponseEntity<>("Hello AWS!", HttpStatus.OK);
    }

}
