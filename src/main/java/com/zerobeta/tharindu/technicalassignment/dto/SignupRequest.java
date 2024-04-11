package com.zerobeta.tharindu.technicalassignment.dto;

import lombok.Getter;

@Getter
public class SignupRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
