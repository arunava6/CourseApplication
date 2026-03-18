package com.example.CourseWeb.service;

import com.example.CourseWeb.exceptions.ResourceNotFoundException;
import com.example.CourseWeb.model.Order;
import com.example.CourseWeb.model.User;
import com.example.CourseWeb.repositories.OrderRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public List<Order> getOrdersForCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();

        return repo.findByUser(user);
    }

    public void placeOrder(Order order) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        order.setUser(user);
        repo.save(order);
    }

    public void deleteOrderById(Integer orderId) {
        if (!repo.existsById(orderId)) {
            throw new ResourceNotFoundException("Order Id not found!!");
        }
        repo.deleteById(orderId);
    }

//    public Order getOrderById(Integer orderId) {
//        return repo.findByorderId(orderId).orElseThrow(() -> new ResourceNotFoundException("Order id not found!!"));
//    }
}
