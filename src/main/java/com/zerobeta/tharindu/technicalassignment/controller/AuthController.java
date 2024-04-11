package com.zerobeta.tharindu.technicalassignment.controller;

import com.zerobeta.tharindu.technicalassignment.dto.SignupRequest;
import com.zerobeta.tharindu.technicalassignment.model.User;
import com.zerobeta.tharindu.technicalassignment.service.AuthService;
import com.zerobeta.tharindu.technicalassignment.utils.JwtIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    public final AuthService authService;
    public final JwtIssuer jwtIssuer;
    @GetMapping
    public String home(){
        return "Welcome to order management system";
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest){
        User user = authService.signUp(signupRequest);
        String token = jwtIssuer.issue(user.getId(), user.getEmail());
        return ResponseEntity.ok(token);
    }

}
