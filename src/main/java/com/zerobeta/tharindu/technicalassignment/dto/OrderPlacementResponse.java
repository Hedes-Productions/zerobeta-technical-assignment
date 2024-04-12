package com.zerobeta.tharindu.technicalassignment.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class OrderPlacementResponse {
    private UUID orderId;
}
