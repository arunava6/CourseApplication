package com.example.CourseWeb.controller;

import com.example.CourseWeb.model.Order;
import com.example.CourseWeb.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> placeOrder(@Valid @RequestBody Order order) {
        service.placeOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order Placed Successfully!!");
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return new ResponseEntity<>(service.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/my-order")
    public ResponseEntity<?> getOrderByUser() {
        return new ResponseEntity<>(service.getOrdersForCurrentUser(), HttpStatus.OK);
    }

//    @GetMapping("/{orderId}")
//    public ResponseEntity<Order> getOrderById(@PathVariable Integer orderId){
//        return new ResponseEntity<>(service.getOrderById(orderId),HttpStatus.FOUND);
//    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable Integer orderId) {
        service.deleteOrderById(orderId);
        return new ResponseEntity<>("Deleted Successfully!!", HttpStatus.OK);
    }
}
