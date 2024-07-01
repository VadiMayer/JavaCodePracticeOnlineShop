package com.example.onlineshop.repository;

import com.example.onlineshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CrudProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p JOIN p.orders o WHERE o.id = :orderId")
    List<Product> findAllByOrderId(@Param("orderId") int orderId);
}
