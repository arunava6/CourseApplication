package com.example.CourseWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer orderId;

    @ManyToOne
    @JoinColumn(name = "courseId")
    Course course;

    @PastOrPresent
    LocalDate purchaseDate;

    @Column(nullable = false)
    @NotNull(message = "Amount is required")
    Double amountPaid;

}
