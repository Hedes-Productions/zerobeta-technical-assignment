package com.zerobeta.tharindu.technicalassignment.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Component
public class JwtIssuer {
    public String issue(Long userId, String email){
        return JWT.create()
                .withSubject(String.valueOf(userId))
                .withClaim("email",String.valueOf(email))
                .withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS)))
                .sign(Algorithm.HMAC256("secret"));
    }

}
