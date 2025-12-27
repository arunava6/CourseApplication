package com.example.CourseWeb.repositories;

import com.example.CourseWeb.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Integer> {

    Course getCourseByCourseId(Integer courseId);

}
