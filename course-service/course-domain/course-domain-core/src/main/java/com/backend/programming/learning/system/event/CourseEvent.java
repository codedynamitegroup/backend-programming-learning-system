package com.backend.programming.learning.system.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.entity.Course;

import java.time.ZonedDateTime;

public abstract class CourseEvent implements DomainEvent<Course> {
    private final Course course;
    private final ZonedDateTime createdAt;

    public CourseEvent(Course course, ZonedDateTime createdAt) {
        this.course = course;
        this.createdAt = createdAt;
    }

    public Course getCourse() {
        return course;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
