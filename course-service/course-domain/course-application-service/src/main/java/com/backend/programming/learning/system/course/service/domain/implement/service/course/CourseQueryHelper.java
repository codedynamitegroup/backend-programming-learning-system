package com.backend.programming.learning.system.course.service.domain.implement.service.course;

import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.course
 * Create by Dang Ngoc Tien
 * Date 4/18/2024 - 8:23 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseQueryHelper {
    private final CourseRepository courseRepository;

    public Page<Course> findAll(String search,String[] courseType, Integer pageNo, Integer pageSize) {
        Page<Course> courses = courseRepository.findAll(search,courseType, pageNo, pageSize);
        log.info("Courses found successfully");
        return courses;
    }

    public Course findById(UUID courseId) {
        Course course = courseRepository.findBy(courseId);
        log.info("Course found successfully");
        return course;
    }
}
