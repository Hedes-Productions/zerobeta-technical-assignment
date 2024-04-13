package com.zerobeta.tharindu.technicalassignment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class OrderPlacementRequest {
    @NotBlank(message = "Item name is required")
    private String itemName;
    @Min(1)
    @NotNull(message = "Quantity is required")
    private Integer quantity;
    @NotBlank(message = "Address is required")
    private String address;
}
