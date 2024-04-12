package com.zerobeta.tharindu.technicalassignment.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class OrderCancellationResponse {
    private String cancelMessage;
}
