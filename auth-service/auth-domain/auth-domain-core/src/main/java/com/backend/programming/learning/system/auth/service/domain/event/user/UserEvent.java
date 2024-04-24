package com.backend.programming.learning.system.auth.service.domain.event.user;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.DomainEvent;

import java.time.ZonedDateTime;

public abstract class UserEvent implements DomainEvent<User> {
    private final User user;
    private final ZonedDateTime createdAt;

    protected UserEvent(User user, ZonedDateTime createdAt) {
        this.user = user;
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
