package com.backend.programming.learning.system.event;

import com.backend.programming.learning.system.entity.Assignment;

import java.time.ZonedDateTime;

public class AssignmentCreatedEvent extends AssignmentEvent {
    public AssignmentCreatedEvent(Assignment assignment, ZonedDateTime createdAt) {
        super(assignment, createdAt);
    }
}
