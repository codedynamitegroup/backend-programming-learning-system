package com.backend.programming.learning.system.event;

import com.backend.programming.learning.system.entity.Course;

import java.time.ZonedDateTime;

public class CourseCreatedEvent extends CourseEvent {
    public CourseCreatedEvent(Course course, ZonedDateTime createdAt) {
        super(course, createdAt);
    }

    @Override
    public void fire() {

    }
}
