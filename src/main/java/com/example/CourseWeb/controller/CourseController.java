package com.example.CourseWeb.controller;


import com.example.CourseWeb.model.Course;
import com.example.CourseWeb.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/courses")
@CrossOrigin("http://localhost:5173")

public class CourseController {
    @Autowired
    CourseService service;

    @GetMapping("/allCourses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<?> getCourseById(@PathVariable Integer courseId){
        Course c=service.getCourseById(courseId);
        if(c==null){
            var logM=new HashMap<>();
            logM.put("message","Request denied");
            logM.put("Errors",new ArrayList());
            List<String> errorList=new ArrayList<>();
            errorList.add("Could not find the given Id");
            logM.put("errors",errorList);
            return new ResponseEntity<>(logM,HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(c);
    }

    @PostMapping("/")
    public ResponseEntity<Course> saveCourse(@Valid @RequestBody Course newCourse){
        Course saved = service.saveCourse(newCourse);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/update/{courseId}")
    public ResponseEntity<Course> updateCourse(@RequestBody Course updateCourse,@PathVariable Integer courseId){
        return ResponseEntity.ok(service.updateCourse(updateCourse,courseId));
    }

    @DeleteMapping("/delete/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable Integer courseId){
        service.deleteCourse(courseId);
        return ResponseEntity.ok("Deleted Successfully");
    }
}
