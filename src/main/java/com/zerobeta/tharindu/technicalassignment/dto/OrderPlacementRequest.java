package com.zerobeta.tharindu.technicalassignment.dto;

import lombok.Getter;

@Getter
public class OrderPlacementRequest {
    private String itemName;
    private Integer quantity;
    private String address;
}
