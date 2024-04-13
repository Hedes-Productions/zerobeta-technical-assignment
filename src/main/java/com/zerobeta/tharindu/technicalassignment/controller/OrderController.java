package com.zerobeta.tharindu.technicalassignment.controller;

import com.zerobeta.tharindu.technicalassignment.dto.*;
import com.zerobeta.tharindu.technicalassignment.model.SecurityUser;
import com.zerobeta.tharindu.technicalassignment.service.OrderService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/placeorder")
    public ResponseEntity<OrderPlacementResponse> placeOrder(@RequestBody @Valid OrderPlacementRequest orderPlacementRequest, @AuthenticationPrincipal @NonNull SecurityUser securityUser){
        try {
            return ResponseEntity.ok(OrderPlacementResponse.builder()
                    .orderId(orderService.placeOrder(orderPlacementRequest, securityUser.getEmail()))
                    .feedback("Success")
                    .build());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(OrderPlacementResponse.builder()
                    .feedback("Internal server error").build());
        }

    }

    @PostMapping("/cancelorder")
    public ResponseEntity<OrderCancellationResponse> cancelOrder(@RequestBody @Valid OrderCancellationRequest orderPlacementRequest){
        try {
            return ResponseEntity.ok(OrderCancellationResponse.builder()
                    .cancelMessage(orderService.cancelOrder(orderPlacementRequest))
                    .feedback("Success")
                    .build());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(OrderCancellationResponse.builder()
                    .feedback("Internal server error").build());
        }
    }

    @GetMapping("/history")
    public ResponseEntity<HistoryResponse> getHistory(@ModelAttribute @Valid HistoryRequest historyRequest ){
        try {
            return ResponseEntity.ok(HistoryResponse.builder()
                    .history(orderService.getHistory(historyRequest.getPage(), historyRequest.getSize()))
                    .feedback("Success")
                    .build());
        } catch (Exception error) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(HistoryResponse.builder()
                    .feedback("Internal server error").build());
        }

    }
}
