package com.example.onlineshop.controller;

import com.example.onlineshop.model.Product;
import com.example.onlineshop.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;


@WebMvcTest(ProductController.class)
class ProductControllerTest {

    @MockBean
    ProductService productService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    List<Product> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>();
        list.add(new Product(1, "Laptop", "15,6", 60_000, 3));
        list.add(new Product(2, "iPhone", "20 Pro Max", 400_000, 2));
        list.add(new Product(3, "Samsung", "A21", 15_000, 10));
    }

    @AfterEach
    void clear() {
        list.clear();
    }

    @Test
    void getProductsList() throws Exception {
        when(productService.getProducts()).thenReturn(list);
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetNull() throws Exception {
        String errorMessage = "Product not found";
        when(productService.getProduct(4)).thenThrow(new NullPointerException(errorMessage));
        mockMvc.perform(get("/products/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andExpect(content().string(errorMessage));
    }

    @Test
    void create() throws Exception {
        Product newProduct = new Product(4, "Tablet", "iPad Pro", 150_000, 5);
        URI location = new URI("/products/" + newProduct.getProductId());
        when(productService.updateOrCreate(any(Product.class))).thenReturn(newProduct);

        mockMvc.perform(post("/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newProduct)))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", location.toString()))
                .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON.toString()))
                .andExpect(jsonPath("$.productId").value(newProduct.getProductId()))
                .andExpect(jsonPath("$.name").value(newProduct.getName()))
                .andExpect(jsonPath("$.description").value(newProduct.getDescription()))
                .andExpect(jsonPath("$.price").value(newProduct.getPrice()))
                .andExpect(jsonPath("$.quantityInStock").value(newProduct.getQuantityInStock()));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}