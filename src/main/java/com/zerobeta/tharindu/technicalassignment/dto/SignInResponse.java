package com.zerobeta.tharindu.technicalassignment.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SignInResponse {
    private String token;
}
