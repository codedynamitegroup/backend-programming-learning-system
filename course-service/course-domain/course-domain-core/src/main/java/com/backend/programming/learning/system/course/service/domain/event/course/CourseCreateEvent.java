package com.backend.programming.learning.system.course.service.domain.event.course;

import com.backend.programming.learning.system.course.service.domain.entity.course.Course;
import com.backend.programming.learning.system.event.DomainEvent;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * com.backend.programming.learning.system.course.service.domain.event.course
 * Create by Dang Ngoc Tien
 * Date 4/11/2024 - 12:17 AM
 * Description: ...
 */
@Getter
public class CourseCreateEvent implements DomainEvent<Course> {
    private final Course course;
    private final LocalDateTime createAt;

    public CourseCreateEvent(Course course, LocalDateTime createAt) {
        this.course = course;
        this.createAt = LocalDateTime.now();
    }

}
