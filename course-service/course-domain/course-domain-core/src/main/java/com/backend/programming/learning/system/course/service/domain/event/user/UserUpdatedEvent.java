package com.backend.programming.learning.system.course.service.domain.event.user;

import com.backend.programming.learning.system.course.service.domain.entity.User;

import java.time.ZonedDateTime;
import java.util.List;

public class UserUpdatedEvent extends UserEvent {
    public UserUpdatedEvent(User user, ZonedDateTime createdAt, List<String> failureMessages) {
        super(user, createdAt, failureMessages);
    }

    @Override
    public void fire() {
        
    }
}
