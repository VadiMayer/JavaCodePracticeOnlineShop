package com.example.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Integer productId;
    private String name;
    private String description;
    private int price;
    private int quantityInStock;
}
