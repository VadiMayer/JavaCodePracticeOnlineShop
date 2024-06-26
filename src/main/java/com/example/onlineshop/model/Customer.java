package com.example.onlineshop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
}
