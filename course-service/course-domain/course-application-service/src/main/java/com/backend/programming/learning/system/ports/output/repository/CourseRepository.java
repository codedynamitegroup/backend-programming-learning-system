package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Course;

import java.util.List;
import java.util.UUID;

public interface CourseRepository {
    Course saveCourse(Course course);

    Course save(Course course);

    List<Course> findAll(String search);

    Course findBy(UUID courseId);
}
