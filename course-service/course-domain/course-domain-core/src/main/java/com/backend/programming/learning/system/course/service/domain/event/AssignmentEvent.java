package com.backend.programming.learning.system.course.service.domain.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.course.service.domain.entity.Assignment;

import java.time.ZonedDateTime;

public abstract class AssignmentEvent implements DomainEvent<Assignment> {
    private final Assignment assignment;
    private final ZonedDateTime createdAt;

    public AssignmentEvent(Assignment assignment, ZonedDateTime createdAt) {
        this.assignment = assignment;
        this.createdAt = createdAt;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
