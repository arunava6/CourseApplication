package com.example.CourseWeb.service;

import com.example.CourseWeb.exceptions.ResourceNotFoundException;
import com.example.CourseWeb.model.Order;
import com.example.CourseWeb.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepo repo;

    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    public void placeOrder(Order order) {
        repo.save(order);
    }

    public Order getOrderById(Integer orderId) {
        return repo.findById(orderId).orElseThrow(() -> new ResourceNotFoundException(
                "Order Id not found!!"
                )
        );
    }

    public void deleteOrderById(Integer orderId) {
        if(!repo.existsById(orderId)){
            throw new ResourceNotFoundException("Order Id not found!!");
        }
        repo.deleteById(orderId);
    }
}
