package com.example.onlineshop.service;

import com.example.onlineshop.model.Customer;
import com.example.onlineshop.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private CustomerRepository customerRepository;

    public Customer getCustomer(int id) {
        return customerRepository.getCustomer(id);
    }
}
