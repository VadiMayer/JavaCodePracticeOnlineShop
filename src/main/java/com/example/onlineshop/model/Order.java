package com.example.onlineshop.model;

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
public class Order {
    private Integer orderId;
    private Customer customer;
    private List<Product> products;
    private String shippingAddress;
    private LocalDate orderDate;
    private int totalPrice;
    private StatusOrder orderStatus;
}
