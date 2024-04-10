package com.backend.programming.learning.system.course.service.domain.service.course;

import com.backend.programming.learning.system.course.service.domain.entity.course.Course;
import com.backend.programming.learning.system.course.service.domain.event.course.CourseCreateEvent;

/**
 * com.backend.programming.learning.system.course.service.domain.service.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:31 AM
 * Description: ...
 */
public interface CourseDomainService {
    CourseCreateEvent validateAndInitiateCourseCreation(Course course);
}
