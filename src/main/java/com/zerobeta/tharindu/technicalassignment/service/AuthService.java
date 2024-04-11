package com.zerobeta.tharindu.technicalassignment.service;

import com.zerobeta.tharindu.technicalassignment.dto.SignupRequest;
import com.zerobeta.tharindu.technicalassignment.model.User;
import com.zerobeta.tharindu.technicalassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public User signUp(SignupRequest signupRequest){
        return userRepository.save(
                User.builder()
                        .email(signupRequest.getEmail())
                        .password(passwordEncoder.encode(signupRequest.getPassword()))
                        .firstName(signupRequest.getFirstName())
                        .lastName(signupRequest.getLastName())
                        .build()
        );
    }

}
