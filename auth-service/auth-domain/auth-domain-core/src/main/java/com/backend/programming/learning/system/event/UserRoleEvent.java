package com.backend.programming.learning.system.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.entity.UserRole;

import java.time.ZonedDateTime;

public abstract class UserRoleEvent implements DomainEvent<UserRole> {
    private final UserRole userRole;
    private final ZonedDateTime createdAt;

    protected UserRoleEvent(UserRole userRole, ZonedDateTime createdAt) {
        this.userRole = userRole;
        this.createdAt = createdAt;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
