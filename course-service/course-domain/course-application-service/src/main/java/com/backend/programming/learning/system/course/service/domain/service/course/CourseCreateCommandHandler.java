package com.backend.programming.learning.system.course.service.domain.service.course;

import com.backend.programming.learning.system.course.service.domain.dto.course.create.CreateCourseCommand;
import com.backend.programming.learning.system.course.service.domain.dto.course.get.CourseResponse;
import com.backend.programming.learning.system.course.service.domain.entity.course.Course;
import com.backend.programming.learning.system.course.service.domain.event.course.CourseCreateEvent;
import com.backend.programming.learning.system.course.service.domain.mapper.course.CourseDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * com.backend.programming.learning.system.course.service.domain.service.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:01 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseCreateCommandHandler {
    private final CourseDomainService courseDomainService;
    private final CourseRepository courseRepository;
    private final CourseDataMapper courseDataMapper;
    @Transactional
    public CourseCreateEvent createCourse(CreateCourseCommand createCourseCommand) {
        Course course = courseDataMapper.createCourseCommandToCourse(createCourseCommand);
        CourseCreateEvent courseCreateEvent = courseDomainService.validateAndInitiateCourseCreation(course);
        Course savedCourse = courseRepository.createCourse(courseCreateEvent.getCourse());
        if (savedCourse == null) {
            log.error("Failed to save course with name: {}", savedCourse);
            throw new RuntimeException("Failed to save course");
        }
        log.info("Course saved successfully");
        return courseCreateEvent;
    }

    @Transactional(readOnly = true)
    public CourseResponse findAll(String search) {
        List<Course> courses = courseRepository.findAll(search);
        return courseDataMapper.coursesToCourseResponse(courses, "Get list course successfully");
    }
}
