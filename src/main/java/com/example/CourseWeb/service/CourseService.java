package com.example.CourseWeb.service;

import com.example.CourseWeb.model.Course;
import com.example.CourseWeb.repositories.CourseRepo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    CourseRepo repo;

    public List<Course> getAllCourses() {
        return repo.findAll();
    }

    public Course getCourseById(Integer courseId) {
        return repo.getCourseByCourseId(courseId);
    }

    public Course saveCourse(Course newCourse) {
        return repo.save(newCourse);
    }
}
