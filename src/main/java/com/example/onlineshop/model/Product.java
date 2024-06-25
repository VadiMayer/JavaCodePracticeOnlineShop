package com.example.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@Component
public class Product {
    private String name;
    private String description;
    private int cost;
    private int quantityInStock;
}
