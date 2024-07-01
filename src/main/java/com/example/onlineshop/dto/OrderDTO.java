package com.example.onlineshop.dto;


import com.example.onlineshop.model.Customer;
import com.example.onlineshop.model.Product;
import com.example.onlineshop.model.StatusOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Customer customer;
    private List<Product> products;
    private LocalDate orderDate;
    private int totalPrice;
}
