package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Course;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository {
    Course save(Course course);

    Page<Course> findAll(String search, Integer page, Integer size);

    Course findBy(UUID courseId);

    Optional<Course> findByName(String courseName);

    Course findById(UUID courseId);

    void deleteById(UUID courseId);
}
