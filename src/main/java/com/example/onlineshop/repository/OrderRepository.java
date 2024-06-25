package com.example.onlineshop.repository;

import com.example.onlineshop.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class OrderRepository {

    private CrudOrderRepository crudOrderRepository;

    public Order getOrder(int id) {
        return crudOrderRepository.findById(id).orElse(null);
    }

    public Order create(Order order) {
        return crudOrderRepository.save(order);
    }
}
