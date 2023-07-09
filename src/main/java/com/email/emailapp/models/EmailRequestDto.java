package com.email.emailapp.models;

import lombok.Data;

@Data
public class EmailRequestDto {
    private String to;
    private String subject;
    private String message;
}
