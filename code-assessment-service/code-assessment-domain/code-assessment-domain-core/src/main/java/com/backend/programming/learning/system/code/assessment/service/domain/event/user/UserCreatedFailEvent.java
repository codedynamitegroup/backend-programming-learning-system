package com.backend.programming.learning.system.code.assessment.service.domain.event.user;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;

import java.time.ZonedDateTime;
import java.util.List;

public class UserCreatedFailEvent extends UserEvent {
    public UserCreatedFailEvent(User user,
                                ZonedDateTime createdAt,
                                List<String>failureMessages) {
        super(user, createdAt, failureMessages);
    }

    @Override
    public void fire() {

    }
}
