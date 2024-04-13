package com.zerobeta.tharindu.technicalassignment.advice;

import com.zerobeta.tharindu.technicalassignment.dto.GlobalErrorResponse;
import com.zerobeta.tharindu.technicalassignment.dto.GlobalInvalidArgumentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public GlobalInvalidArgumentErrorResponse handleInvalidArgument(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(),error.getDefaultMessage());
        });
        return GlobalInvalidArgumentErrorResponse.builder()
                .errorMessage(errorMap)
                .build();
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    public GlobalErrorResponse handleBadCredentialsException(BadCredentialsException ex) {
        return GlobalErrorResponse.builder()
                .errorMessage("Invalid username or password")
                .build();
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(AuthenticationException.class)
    public GlobalErrorResponse handleAuthenticationException(AuthenticationException ex) {
        return GlobalErrorResponse.builder()
                .errorMessage("User already exists")
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public GlobalErrorResponse handleException(Exception ex) {
        return GlobalErrorResponse.builder()
                .errorMessage("Error: " + ex)
                .build();
    }
}
