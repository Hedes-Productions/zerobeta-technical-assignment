package com.zerobeta.tharindu.technicalassignment.repository;

import com.zerobeta.tharindu.technicalassignment.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends CrudRepository<Order, UUID> {
    Optional<List<Order>> findAllByStatus(String status);
}
