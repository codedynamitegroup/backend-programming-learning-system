package com.backend.programming.learning.system.code.assessment.service.domain.event.user;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;
import java.util.List;

public abstract class UserEvent implements DomainEvent<User> {
    private final User user;
    private final ZonedDateTime createdAt;
    private final List<String> failureMessages;

    protected UserEvent(User user, ZonedDateTime createdAt, List<String> failureMessages) {
        this.user = user;
        this.createdAt = createdAt;
        this.failureMessages = failureMessages;
    }

    public User getUser() {
        return user;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public List<String> getFailureMessages() {
        return failureMessages;
    }
}
