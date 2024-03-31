package com.backend.programming.learning.system.event;


import com.backend.programming.learning.system.entity.Role;

import java.time.ZonedDateTime;

public class RoleCreatedEvent extends RoleEvent {

    public RoleCreatedEvent(Role role, ZonedDateTime createdAt) {
        super(role, createdAt);
    }
}
