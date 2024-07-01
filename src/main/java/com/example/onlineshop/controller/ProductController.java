package com.example.onlineshop.controller;

import com.example.onlineshop.dto.ProductDTO;
import com.example.onlineshop.model.Product;
import com.example.onlineshop.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import static com.example.onlineshop.service.ProductService.toDTO;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    private ObjectMapper objectMapper;

    @GetMapping
    public ResponseEntity<String> get() throws JsonProcessingException {
        List<Product> list = productService.getProducts();
        List<ProductDTO> dtoList = toDTO(list);
        String json = objectMapper.writeValueAsString(dtoList);
        return ResponseEntity.ok(json);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable int id) throws JsonProcessingException {
        Product product = productService.getProduct(id);
        ProductDTO productDTO = toDTO(product);
        String json = objectMapper.writeValueAsString(productDTO);
        return ResponseEntity.ok(json);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Product product) throws URISyntaxException, JsonProcessingException {
        Product productFromBase = productService.updateOrCreate(product);
        ProductDTO productDTO = toDTO(productFromBase);
        String json = objectMapper.writeValueAsString(productDTO);
        return ResponseEntity.created(new URI("/products/" + product.getProductId())).contentType(MediaType.APPLICATION_JSON).body(json);
    }

    @PutMapping
    public ResponseEntity<Product> update(@RequestBody Product product) {
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
