package com.zerobeta.tharindu.technicalassignment.dto;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HistoryRequest {
    @Min(0)
    private int page;
    @Min(0)
    private int size;
}
