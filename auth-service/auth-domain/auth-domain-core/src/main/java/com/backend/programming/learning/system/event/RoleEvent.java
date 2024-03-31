package com.backend.programming.learning.system.event;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.entity.Role;

import java.time.ZonedDateTime;

public abstract class RoleEvent implements DomainEvent<Role> {
    private final Role role;
    private final ZonedDateTime createdAt;

    protected RoleEvent(Role role, ZonedDateTime createdAt) {
        this.role = role;
        this.createdAt = createdAt;
    }

    public Role getRole() {
        return role;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }
}
