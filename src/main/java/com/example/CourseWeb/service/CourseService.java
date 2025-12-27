package com.example.CourseWeb.service;

import com.example.CourseWeb.model.Course;
import com.example.CourseWeb.repositories.CourseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseService {

    @Autowired
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


    public Course updateCourse(Course updateCourse, Integer courseId) {
        // return repo.updateCourseByCourseId(updateCourse,courseId);

        Course existingCourse=repo.findById(courseId).orElseThrow(() ->
                new RuntimeException("Course not found with id: " + courseId)
        );

        existingCourse.setCourseName(updateCourse.getCourseName());
        existingCourse.setCourseDesc(updateCourse.getCourseDesc());
        existingCourse.setDuration(updateCourse.getDuration());
        existingCourse.setTags(updateCourse.getTags());
        existingCourse.setPrice(updateCourse.getPrice());
        existingCourse.setListedOn(updateCourse.getListedOn());
        return repo.save(existingCourse);
    }

    public void deleteCourse(Integer courseId) {
        if (!repo.existsById(courseId)) {
            throw new RuntimeException("Course not found with id: " + courseId);
        }
        repo.deleteById(courseId);
    }
}

