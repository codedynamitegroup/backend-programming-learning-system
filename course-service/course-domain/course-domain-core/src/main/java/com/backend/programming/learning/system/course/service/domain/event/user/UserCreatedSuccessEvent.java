package com.backend.programming.learning.system.course.service.domain.event.user;

import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.Collections;

public class UserCreatedSuccessEvent extends UserEvent {
    private final DomainEventPublisher<UserCreatedSuccessEvent> userCreatedSuccessEventDomainEventPublisher;
    public UserCreatedSuccessEvent(User user,
                                   ZonedDateTime createdAt,
                                   DomainEventPublisher<UserCreatedSuccessEvent> userCreatedSuccessEventDomainEventPublisher) {
        super(user, createdAt, Collections.emptyList());
        this.userCreatedSuccessEventDomainEventPublisher = userCreatedSuccessEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userCreatedSuccessEventDomainEventPublisher.publish(this);
    }
}
