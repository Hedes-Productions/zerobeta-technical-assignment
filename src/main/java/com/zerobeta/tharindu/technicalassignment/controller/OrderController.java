package com.zerobeta.tharindu.technicalassignment.controller;

import com.zerobeta.tharindu.technicalassignment.dto.OrderPlacementRequest;
import com.zerobeta.tharindu.technicalassignment.dto.OrderPlacementResponse;
import com.zerobeta.tharindu.technicalassignment.model.SecurityUser;
import com.zerobeta.tharindu.technicalassignment.service.OrderService;
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
    public ResponseEntity<OrderPlacementResponse> placeOrder(@RequestBody OrderPlacementRequest orderPlacementRequest, @AuthenticationPrincipal SecurityUser securityUser){
        return ResponseEntity.ok(OrderPlacementResponse.builder()
                        .orderId(orderService.placeOrder(orderPlacementRequest, securityUser.getEmail()))
                        .build());
    }
}
