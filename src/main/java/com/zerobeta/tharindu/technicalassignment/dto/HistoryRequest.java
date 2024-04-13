package com.zerobeta.tharindu.technicalassignment.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryRequest {
    @Min(1)
    private int page;
    @Min(1)
    private int size;
}
