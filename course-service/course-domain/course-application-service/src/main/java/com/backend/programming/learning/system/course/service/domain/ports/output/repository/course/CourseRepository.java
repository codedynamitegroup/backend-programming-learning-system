package com.backend.programming.learning.system.course.service.domain.ports.output.repository.course;

import com.backend.programming.learning.system.course.service.domain.entity.course.Course;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.ports.output.repository.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:33 AM
 * Description: ...
 */
public interface CourseRepository {
    Course createCourse(Course course);

    List<Course> findAll(String search);

    Course findBy(Long courseId);

    void deleteBy(Long courseId);
}
