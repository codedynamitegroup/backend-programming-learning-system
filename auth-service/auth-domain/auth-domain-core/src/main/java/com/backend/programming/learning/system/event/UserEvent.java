package com.backend.programming.learning.system.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.entity.User;

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
