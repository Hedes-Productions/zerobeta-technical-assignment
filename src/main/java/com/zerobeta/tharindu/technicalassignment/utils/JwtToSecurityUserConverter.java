package com.zerobeta.tharindu.technicalassignment.utils;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.zerobeta.tharindu.technicalassignment.model.SecurityUser;
import org.springframework.stereotype.Component;

@Component
public class JwtToSecurityUserConverter {
    public SecurityUser convert(DecodedJWT decodedJWT){
        return SecurityUser.builder()
                .userId(Long.valueOf(decodedJWT.getSubject()))
                .email(String.valueOf(decodedJWT.getClaim("email")))
                .build();
    }
}
