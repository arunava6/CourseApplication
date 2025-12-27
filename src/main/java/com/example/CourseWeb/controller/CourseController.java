package com.example.CourseWeb.controller;


import com.example.CourseWeb.model.Course;
import com.example.CourseWeb.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService service;

    @GetMapping("/allCourses")
    public List<Course> getAllCourses(){
        return service.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable Integer courseId){
        return service.getCourseById(courseId);
    }

    @PostMapping("/")
    public Course saveCourse(@RequestBody Course newCourse){
        return service.saveCourse(newCourse);
    }

}
