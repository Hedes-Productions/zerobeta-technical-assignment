package com.zerobeta.tharindu.technicalassignment.controller;

import com.zerobeta.tharindu.technicalassignment.dto.*;
import com.zerobeta.tharindu.technicalassignment.model.SecurityUser;
import com.zerobeta.tharindu.technicalassignment.service.OrderService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/placeorder")
    public ResponseEntity<OrderPlacementResponse> placeOrder(@RequestBody OrderPlacementRequest orderPlacementRequest, @AuthenticationPrincipal @NonNull SecurityUser securityUser){
        return ResponseEntity.ok(OrderPlacementResponse.builder()
                        .orderId(orderService.placeOrder(orderPlacementRequest, securityUser.getEmail()))
                        .build());
    }

    @PostMapping("/cancelorder")
    public ResponseEntity<OrderCancellationResponse> cancelOrder(@RequestBody OrderCancellationRequest orderPlacementRequest){
        return ResponseEntity.ok(OrderCancellationResponse.builder()
                .cancelMessage(orderService.cancelOrder(orderPlacementRequest))
                .build());
    }

    @GetMapping("/history")
    public ResponseEntity<HistoryResponse> getHistory(@ModelAttribute() @NonNull HistoryRequest historyRequest ){
        System.out.println(historyRequest.getPage());
        return ResponseEntity.ok(HistoryResponse.builder()
                .history(orderService.getHistory(historyRequest.getPage(), historyRequest.getSize()))
                .build());
    }
}
