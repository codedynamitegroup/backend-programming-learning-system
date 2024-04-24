package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Course;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

public interface CourseRepository {
    Course save(Course course);

    Page<Course> findAll(String search, Integer page, Integer size);

    Course findBy(UUID courseId);

    Course findById(UUID courseId);

    void deleteById(UUID courseId);
}
