package com.example.onlineshop.controller;

import com.example.onlineshop.dto.OrderDTO;
import com.example.onlineshop.model.Order;
import com.example.onlineshop.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import static com.example.onlineshop.service.OrderService.toDTO;

@Controller
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    private ObjectMapper objectMapper;

    @GetMapping()
    public ResponseEntity<String> get(@PathParam("orderId") int orderId, @PathParam("customerId") int customerId) throws JsonProcessingException {
        Order order = orderService.getOrder(orderId, customerId);
        OrderDTO orderDTO = toDTO(order);
        String json = objectMapper.writeValueAsString(orderDTO);
        return ResponseEntity.ok(json);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Order order) throws URISyntaxException, JsonProcessingException {
        Order orderFromBase = orderService.create(order);
        OrderDTO orderDTO = toDTO(orderFromBase);
        String json = objectMapper.writeValueAsString(orderDTO);
        return ResponseEntity.created(new URI("/orders/" + order.getOrderId())).body(json);
    }

}
