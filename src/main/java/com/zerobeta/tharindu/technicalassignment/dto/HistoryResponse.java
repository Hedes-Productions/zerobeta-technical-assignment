package com.zerobeta.tharindu.technicalassignment.dto;

import com.zerobeta.tharindu.technicalassignment.model.Order;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class HistoryResponse {
    private List<Order> history;
}
