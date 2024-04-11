package com.zerobeta.tharindu.technicalassignment.service;

import com.zerobeta.tharindu.technicalassignment.model.SecurityUser;
import com.zerobeta.tharindu.technicalassignment.model.User;
import com.zerobeta.tharindu.technicalassignment.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSecurityDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Username not found " + email));
        return SecurityUser.builder()
                .userId(user.getId())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
