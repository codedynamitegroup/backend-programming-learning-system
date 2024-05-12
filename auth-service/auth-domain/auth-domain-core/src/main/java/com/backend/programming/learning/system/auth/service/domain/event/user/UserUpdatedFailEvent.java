package com.backend.programming.learning.system.auth.service.domain.event.user;

import com.backend.programming.learning.system.auth.service.domain.entity.User;

import java.time.ZonedDateTime;
import java.util.List;

public class UserUpdatedFailEvent extends UserEvent {
    public UserUpdatedFailEvent(User user,
                                ZonedDateTime createdAt,
                                List<String> failureMessages) {
        super(user, createdAt);
    }

    @Override
    public void fire() {

    }
}
