package com.backend.programming.learning.system.implement.course;

import com.backend.programming.learning.system.dto.method.create.course.CreateCourseCommand;
import com.backend.programming.learning.system.dto.method.create.course.CreateCourseResponse;
import com.backend.programming.learning.system.dto.method.query.course.QueryCourseResponse;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.mapper.course.CourseDataMapper;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implemtent.course
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 2:15 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseCommandHandler {
    private final CourseCreateHelper courseCreateHelper;
    private final CourseDataMapper courseDataMapper;
    private final CourseRepository courseRepository;

    public CreateCourseResponse createCourse(CreateCourseCommand createCourseCommand) {
        Course course = courseCreateHelper.createCourse(createCourseCommand);
        log.info("Course is created with id: {}", course.getId());
        return courseDataMapper.courseToCreateCourseResponse(course, "Course created successfully");
    }

    @Transactional(readOnly = true)
    public List<QueryCourseResponse> findAll(String search) {
        List<Course> courses = courseRepository.findAll(search);
        return courseDataMapper.coursesToQueryCourseResponse(courses);
    }

    @Transactional(readOnly = true)
    public QueryCourseResponse findBy(UUID courseId) {
        Course course = courseRepository.findBy(courseId);
        return courseDataMapper.courseToQueryCourseResponse(course, "Get course successfully");
    }
}
