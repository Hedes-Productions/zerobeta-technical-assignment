package com.zerobeta.tharindu.technicalassignment.service;

import com.zerobeta.tharindu.technicalassignment.Enum.OrderStates;
import com.zerobeta.tharindu.technicalassignment.dto.OrderCancellationRequest;
import com.zerobeta.tharindu.technicalassignment.dto.OrderPlacementRequest;
import com.zerobeta.tharindu.technicalassignment.model.Order;
import com.zerobeta.tharindu.technicalassignment.model.User;
import com.zerobeta.tharindu.technicalassignment.repository.OrderRepository;
import com.zerobeta.tharindu.technicalassignment.repository.UserRepository;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    public UUID placeOrder(@NonNull OrderPlacementRequest orderPlacementRequest, String email) throws UsernameNotFoundException{
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

    public String cancelOrder(@NonNull OrderCancellationRequest orderCancellationRequest) throws NoSuchElementException{
        Order order = orderRepository.findById(orderCancellationRequest.getOrderId()).orElseThrow(()->new NoSuchElementException("Order not found"));
        if (Objects.equals(order.getStatus(), OrderStates.NEW)){
            order.setStatus(OrderStates.CANCELLED);
            orderRepository.save(order);
            return "Order successfully canceled";

        } else if (Objects.equals(order.getStatus(), OrderStates.CANCELLED)) {
            return "Unable to cancel the oder. Order canceled already";
        }else{
            return "Unable to cancel the oder. Order dispatched already";
        }
    }

    public List<Order> getHistory(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Order> orderPage = orderRepository.findAll(pageRequest);
        return orderPage.getContent();
    }
}
