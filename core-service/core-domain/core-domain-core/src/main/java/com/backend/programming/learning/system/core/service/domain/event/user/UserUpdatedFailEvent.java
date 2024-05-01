package com.backend.programming.learning.system.core.service.domain.event.user;

import com.backend.programming.learning.system.core.service.domain.entity.User;

import java.time.ZonedDateTime;
import java.util.List;

public class UserUpdatedFailEvent extends UserEvent {
    public UserUpdatedFailEvent(User user,
                                ZonedDateTime createdAt,
                                List<String> failureMessages) {
        super(user, createdAt, failureMessages);
    }

    @Override
    public void fire() {

    }
}
