package com.example.onlineshop.repository;

import com.example.onlineshop.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ProductRepository {
    private CrudProductRepository crudProductRepository;

    public Product getProduct(int id) {
        return crudProductRepository.findById(id).orElse(null);
    }

    public List<Product> getProducts() {
        return crudProductRepository.findAll();
    }

    public Product create(Product product) {
        return crudProductRepository.save(product);
    }

    public void delete(int id) {
        crudProductRepository.deleteById(id);
    }

}
