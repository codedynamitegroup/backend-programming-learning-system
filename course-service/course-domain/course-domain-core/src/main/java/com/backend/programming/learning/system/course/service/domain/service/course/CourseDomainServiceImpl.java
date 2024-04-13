package com.backend.programming.learning.system.course.service.domain.service.course;

import com.backend.programming.learning.system.course.service.domain.entity.course.Course;
import com.backend.programming.learning.system.course.service.domain.event.course.CourseCreateEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.service.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:31 AM
 * Description: ...
 */
@Slf4j
public class CourseDomainServiceImpl implements CourseDomainService{
    @Override
    public CourseCreateEvent validateAndInitiateCourseCreation(Course course) {
        log.info("validateAndInitiateCourseCreation");
        return new CourseCreateEvent(course, LocalDateTime.now());
    }
}
