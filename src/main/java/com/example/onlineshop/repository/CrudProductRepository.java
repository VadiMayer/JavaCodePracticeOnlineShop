package com.example.onlineshop.repository;

import com.example.onlineshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudProductRepository extends JpaRepository<Product, Integer> {
}
