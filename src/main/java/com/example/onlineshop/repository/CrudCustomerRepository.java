package com.example.onlineshop.repository;

import com.example.onlineshop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudCustomerRepository extends JpaRepository<Customer, Integer> {
}
