package com.zerobeta.tharindu.technicalassignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserController {
    @GetMapping
    public String home(){
        return "Welcome to order management system";
    }

}