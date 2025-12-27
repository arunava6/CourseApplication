package com.example.CourseWeb.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer courseId;

    @NotBlank(message = "Course Name can't blank")
    @Column(nullable = false)
    String courseName;

    @NotBlank(message = "Description cannot be blank")
    @Size(min=20, max=200,message = "Description length should be more than 20 and less than 200")
    @Column(nullable = false)
    String courseDesc;
    String tags;

    @Min(1)
    @Max(2000)
    Integer duration;

    @PastOrPresent
    @Column(nullable = false)
    LocalDate listedOn;

    @Min(0)
    @Max(200000)
    @Column(nullable = false)
    Double price;

}
