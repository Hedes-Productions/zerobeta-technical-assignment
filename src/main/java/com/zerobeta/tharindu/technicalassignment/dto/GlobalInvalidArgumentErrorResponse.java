package com.zerobeta.tharindu.technicalassignment.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class GlobalInvalidArgumentErrorResponse {
    private Map<String,String> errorMessage;
}
