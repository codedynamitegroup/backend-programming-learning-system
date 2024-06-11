package com.backend.programming.learning.system.auth.service.domain.event.user.course_to_auth;


import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.auth.service.domain.event.user.UserEvent;

import java.time.ZonedDateTime;

public class UserCreatedSuccessEvent extends UserEvent {
    public UserCreatedSuccessEvent(User user,
                                   ZonedDateTime createdAt) {
        super(user, createdAt);
    }

    @Override
    public void fire() {

    }
}
