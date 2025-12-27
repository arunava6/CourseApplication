package com.example.CourseWeb.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name="courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer courseId;

    @Column(nullable = false)
    String courseName;

    @Column(nullable = false)
    String courseDesc;
    String tags;
    Integer duration;

    @Column(nullable = false)
    LocalDate listedOn;

    @Column(nullable = false)
    Double price;

}
