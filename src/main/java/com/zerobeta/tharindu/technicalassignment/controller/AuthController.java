package com.zerobeta.tharindu.technicalassignment.controller;

import com.zerobeta.tharindu.technicalassignment.dto.SignInRequest;
import com.zerobeta.tharindu.technicalassignment.dto.SignInResponse;
import com.zerobeta.tharindu.technicalassignment.dto.SignUpRequest;
import com.zerobeta.tharindu.technicalassignment.dto.SignUpResponse;
import com.zerobeta.tharindu.technicalassignment.model.SecurityUser;
import com.zerobeta.tharindu.technicalassignment.model.User;
import com.zerobeta.tharindu.technicalassignment.service.AuthService;
import com.zerobeta.tharindu.technicalassignment.utils.JwtIssuer;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    public final AuthService authService;
    public final JwtIssuer jwtIssuer;
    public final AuthenticationManager authenticationManager;

    @PostMapping("/signup")
    public ResponseEntity<SignUpResponse> signup(@RequestBody @Valid SignUpRequest signUpRequest) throws AuthenticationException {
        User user = authService.signUp(signUpRequest);
        String token = jwtIssuer.issue(user.getId(), user.getEmail());
        return ResponseEntity.ok(SignUpResponse.builder()
                .token(token)
                .build());


    }

    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signin(@RequestBody @Valid SignInRequest signInRequest){
            var authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            var principal = (SecurityUser)authentication.getPrincipal();
            var token = jwtIssuer.issue(principal.getUserId(),principal.getEmail());
            return ResponseEntity.ok(SignInResponse.builder()
                    .token(token)
                    .build());
    }

}
