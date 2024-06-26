package com.example.onlineshop.service;

import com.example.onlineshop.model.Product;
import com.example.onlineshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product updateOrCreate(Product product) {
        Product productFromBase = productRepository.getProduct(product.getId());
        if (productFromBase == null) {
            return productRepository.create(product);
        } else {
            productFromBase.setName(product.getName());
            productFromBase.setCost(product.getCost());
            productFromBase.setDescription(product.getDescription());
            productFromBase.setQuantityInStock(product.getQuantityInStock());
            return productRepository.create(productFromBase);
        }
    }

    public void delete(int id) {
        productRepository.delete(id);
    }
}
