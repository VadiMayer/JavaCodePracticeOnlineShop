package com.example.onlineshop.model;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(min = 2, max = 30)
    private String name;
    @NotBlank
    private String description;
    private int price;
    private int quantityInStock;
    private Order order;

    public Product(String name, String description, int price, int quantityInStock, Order order) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.order = order;
    }
}
