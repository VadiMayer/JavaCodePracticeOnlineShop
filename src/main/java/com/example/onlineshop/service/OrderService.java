package com.example.onlineshop.service;

import com.example.onlineshop.dto.OrderDTO;
import com.example.onlineshop.model.Customer;
import com.example.onlineshop.model.Order;
import com.example.onlineshop.model.Product;
import com.example.onlineshop.repository.CustomerRepository;
import com.example.onlineshop.repository.OrderRepository;
import com.example.onlineshop.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepository orderRepository;

    private CustomerRepository customerRepository;

    private ProductRepository productRepository;

    public Order getOrder(int orderId, int customerId) {
        Order order = orderRepository.getOrder(orderId);
        Customer customer = customerRepository.getCustomer(customerId);
        List<Product> products = productRepository.getProductsForOrder(orderId);
        order.setCustomer(customer);
        order.setProducts(products);
        return order;
    }

    public Order create(Order order) {
        return orderRepository.create(order);
    }

    public static OrderDTO toDTO(Order order) {
        return new OrderDTO(order.getCustomer(), order.getProducts(), order.getOrderDate(), order.getTotalPrice());
    }
}
