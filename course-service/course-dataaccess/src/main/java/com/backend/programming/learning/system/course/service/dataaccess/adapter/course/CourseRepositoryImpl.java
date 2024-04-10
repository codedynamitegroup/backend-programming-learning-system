package com.backend.programming.learning.system.course.service.dataaccess.adapter.course;

import com.backend.programming.learning.system.course.service.dataaccess.mapper.course.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.repository.course.CourseJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.course.Course;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.course.service.dataaccess.adapter.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:34 AM
 * Description: ...
 */
@Component
@RequiredArgsConstructor
public class CourseRepositoryImpl implements CourseRepository {
    private final CourseJpaRepository courseRepository;
    private final CourseDataAccessMapper courseDataAccessMapper;

    @Override
    public Course createCourse(Course course) {
        return courseDataAccessMapper.courseEntityToCourse(
                courseRepository.save(courseDataAccessMapper.courseToCourseEntity(course)));
    }
}
