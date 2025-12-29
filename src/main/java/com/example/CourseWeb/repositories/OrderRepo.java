package com.example.CourseWeb.repositories;

import com.example.CourseWeb.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {
//    Optional<Order> findByorderId(Integer orderId);

}
