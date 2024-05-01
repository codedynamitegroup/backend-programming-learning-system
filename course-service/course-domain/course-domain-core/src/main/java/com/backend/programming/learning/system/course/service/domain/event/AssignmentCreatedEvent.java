package com.backend.programming.learning.system.course.service.domain.event;

import com.backend.programming.learning.system.course.service.domain.entity.Assignment;

import java.time.ZonedDateTime;

public class AssignmentCreatedEvent extends AssignmentEvent {
    public AssignmentCreatedEvent(Assignment assignment, ZonedDateTime createdAt) {
        super(assignment, createdAt);
    }

    @Override
    public void fire() {

    }
}
