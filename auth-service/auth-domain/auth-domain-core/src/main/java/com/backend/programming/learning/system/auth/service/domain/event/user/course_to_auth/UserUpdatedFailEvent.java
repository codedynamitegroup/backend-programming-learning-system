package com.backend.programming.learning.system.auth.service.domain.event.user.course_to_auth;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserEvent;

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
