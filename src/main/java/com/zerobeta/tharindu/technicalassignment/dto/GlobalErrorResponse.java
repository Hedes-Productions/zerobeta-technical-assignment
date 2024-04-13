package com.zerobeta.tharindu.technicalassignment.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GlobalErrorResponse {
    private String errorMessage;
}
