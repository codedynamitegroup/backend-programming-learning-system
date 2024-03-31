package com.backend.programming.learning.system.event;


import com.backend.programming.learning.system.entity.User;

import java.time.ZonedDateTime;

public class UserCreatedEvent extends UserEvent {

    public UserCreatedEvent(User user, ZonedDateTime createdAt) {
        super(user, createdAt);
    }
}
