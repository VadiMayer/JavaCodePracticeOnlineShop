package com.example.onlineshop.controller;

import com.example.onlineshop.model.Product;
import com.example.onlineshop.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<String> get() throws JsonProcessingException {
        List<Product> list = productService.getProducts();
        String json = objectMapper.writeValueAsString(list);
        return ResponseEntity.ok(json);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable int id) throws JsonProcessingException {
        Product product = productService.getProduct(id);
        String json = objectMapper.writeValueAsString(product);
        return ResponseEntity.ok(json);
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody String json) throws JsonProcessingException, URISyntaxException {
        Product product = objectMapper.readValue(json, Product.class);
        return ResponseEntity.created(new URI("/products/" + product.getProductId())).body(productService.updateOrCreate(product));
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody String json) throws JsonProcessingException {
        Product product = objectMapper.readValue(json, Product.class);
        return ResponseEntity.ok(productService.updateOrCreate(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
