package com.zerobeta.tharindu.technicalassignment.dto;

import com.zerobeta.tharindu.technicalassignment.model.Order;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Builder
@Getter
public class HistoryResponse {
    private Page<Order> history;
    private String feedback;
}
