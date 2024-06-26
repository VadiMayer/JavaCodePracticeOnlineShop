package com.example.onlineshop.service;

import com.example.onlineshop.model.Order;
import com.example.onlineshop.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    public Order getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    public Order create(Order order) {
        return orderRepository.create(order);
    }
}
