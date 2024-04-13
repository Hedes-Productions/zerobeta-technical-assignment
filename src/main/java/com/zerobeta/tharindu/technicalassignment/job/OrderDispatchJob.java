package com.zerobeta.tharindu.technicalassignment.job;

import com.zerobeta.tharindu.technicalassignment.model.Order;
import com.zerobeta.tharindu.technicalassignment.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class OrderDispatchJob {
    private final OrderRepository orderRepository;
    private final Logger logger = LoggerFactory.getLogger("OrderDispatch");

    @Scheduled(fixedRate = 1000*30)
    public void dispatchOrders() {
        logger.info("Running scheduled task...");
        List<Order> newOrders = orderRepository.findAllByStatus("NEW").orElseThrow(()->new NoSuchElementException("No new orders"));
        for (Order order: newOrders){
            order.setStatus("DISPATCHED");
        }
        orderRepository.saveAll(newOrders);
        logger.info("Dispatch job was executed.");
    }
}
