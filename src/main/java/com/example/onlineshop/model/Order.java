package com.example.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private String address;
    private int cost;
    private StatusOrder statusOrder;
}
