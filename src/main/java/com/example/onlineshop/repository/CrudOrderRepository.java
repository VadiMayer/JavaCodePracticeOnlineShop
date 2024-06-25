package com.example.onlineshop.repository;

import com.example.onlineshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudOrderRepository extends JpaRepository<Order, Integer> {
}
