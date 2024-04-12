package com.zerobeta.tharindu.technicalassignment.dto;

import lombok.Getter;

import java.util.UUID;

@Getter
public class OrderCancellationRequest {
    private UUID orderId;
}
