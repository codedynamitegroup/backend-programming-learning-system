package com.backend.programming.learning.system.implement.course;

import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

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

    public Page<Course> findAll(String search, Integer pageNo, Integer pageSize) {
        Page<Course> courses = courseRepository.findAll(search, pageNo, pageSize);
        log.info("Courses found successfully");
        return courses;
    }
}
