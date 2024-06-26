package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Course;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface CourseRepository {
    Course save(Course course);

    Page<Course> findAll(String search,String[] courseType, Integer page, Integer size);

    Course findBy(UUID courseId);

    Optional<Course> findByName(String courseName);

    Optional<Course> findByCourseIdMoodle(Integer courseIdMoodle);

    Course findById(UUID courseId);

    void deleteById(UUID courseId);

    void deleteByMoodleId(Integer courseMoodleId);

    Optional<Course> findCourseById(UUID courseId);
}
