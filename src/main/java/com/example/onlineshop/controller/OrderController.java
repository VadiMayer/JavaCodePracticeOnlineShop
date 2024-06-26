package com.example.onlineshop.controller;

import com.example.onlineshop.model.Order;
import com.example.onlineshop.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    private ObjectMapper objectMapper;

    @GetMapping("/{id}")
    public ResponseEntity<String> get(@PathVariable int id) throws JsonProcessingException {
        Order order = orderService.getOrder(id);
        String json = objectMapper.writeValueAsString(order);
        return ResponseEntity.ok(json);
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody String json) throws JsonProcessingException, URISyntaxException {
        Order order = objectMapper.readValue(json, Order.class);
        return ResponseEntity.created(new URI("/orders/" + order.getOrderId())).body(orderService.create(order));
    }

}
