package com.zerobeta.tharindu.technicalassignment.service;

import com.zerobeta.tharindu.technicalassignment.dto.OrderPlacementRequest;
import com.zerobeta.tharindu.technicalassignment.model.Order;
import com.zerobeta.tharindu.technicalassignment.model.User;
import com.zerobeta.tharindu.technicalassignment.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final UserRepository userRepository;
    public UUID placeOrder(OrderPlacementRequest orderPlacementRequest, String email) throws UsernameNotFoundException{
        User user = userRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Username not found " + email));
        Order order = Order.builder()
                .item_name(orderPlacementRequest.getItemName())
                .quantity(orderPlacementRequest.getQuantity())
                .address(orderPlacementRequest.getAddress())
                .build();

        user.getOrders().add(order);
        userRepository.save(user);

        return order.getId();
    }

}
