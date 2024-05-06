package com.backend.programming.learning.system.code.assessment.service.domain.event.user;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;

import java.time.ZonedDateTime;
import java.util.Collections;

public class UserDeletedSuccessEvent extends UserEvent {
    public UserDeletedSuccessEvent(User user, ZonedDateTime createdAt) {
        super(user, createdAt, Collections.emptyList());
    }

    @Override
    public void fire() {
    }
}
