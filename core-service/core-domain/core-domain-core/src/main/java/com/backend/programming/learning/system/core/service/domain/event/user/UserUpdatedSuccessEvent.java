package com.backend.programming.learning.system.core.service.domain.event.user;

import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.Collections;

public class UserUpdatedSuccessEvent extends UserEvent {
    public UserUpdatedSuccessEvent(User user, ZonedDateTime createdAt) {
        super(user, createdAt, Collections.emptyList());
    }

    @Override
    public void fire() {

    }
}
