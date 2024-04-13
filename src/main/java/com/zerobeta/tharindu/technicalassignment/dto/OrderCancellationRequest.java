package com.zerobeta.tharindu.technicalassignment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.util.UUID;

@Getter
public class OrderCancellationRequest {
    @NotNull(message = "Order ID is required")
    private UUID orderId;
}
