package com.backend.programming.learning.system.event;


import com.backend.programming.learning.system.entity.UserRole;

import java.time.ZonedDateTime;

public class UserRoleCreatedEvent extends UserRoleEvent {
    public UserRoleCreatedEvent(UserRole userRole, ZonedDateTime createdAt) {
        super(userRole, createdAt);
    }
}
