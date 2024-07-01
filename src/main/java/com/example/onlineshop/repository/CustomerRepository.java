package com.example.onlineshop.repository;

import com.example.onlineshop.model.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class CustomerRepository {
    private CrudCustomerRepository crudCustomerRepository;

    public Customer getCustomer(int id) {
        return crudCustomerRepository.findById(id).orElse(null);
    }
}
