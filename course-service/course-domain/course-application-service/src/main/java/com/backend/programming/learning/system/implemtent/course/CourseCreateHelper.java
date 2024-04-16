package com.backend.programming.learning.system.implemtent.course;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.create.CreateCourseCommand;
import com.backend.programming.learning.system.entity.Course;
import com.backend.programming.learning.system.mapper.CourseDataMapper;
import com.backend.programming.learning.system.ports.output.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * com.backend.programming.learning.system.implemtent.course
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 2:16 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CourseCreateHelper {
    private final CourseDomainService courseDomainService;
    private final CourseDataMapper courseDataMapper;
    private final CourseRepository courseRepository;
    @Transactional
    public Course createCourse(CreateCourseCommand createCourseCommand) {
        Course course = courseDataMapper.createCourseCommandToCourse(createCourseCommand);
        courseDomainService.createCourse(course);
        return saveCourse(course);
    }

    private Course saveCourse(Course course) {
        Course saveCourse = courseRepository.save(course);
        if (Objects.isNull(saveCourse)) {
            log.error("Failed to save course");
            throw new RuntimeException("Failed to save course");
        }
        log.info("Course saved successfully with id: {}", saveCourse.getId());
        return saveCourse;
    }
}
