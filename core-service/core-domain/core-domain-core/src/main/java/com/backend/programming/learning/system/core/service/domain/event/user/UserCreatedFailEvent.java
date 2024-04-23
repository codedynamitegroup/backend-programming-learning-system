package com.backend.programming.learning.system.core.service.domain.event.user;

import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.List;

public class UserCreatedFailEvent extends UserEvent {
    private final DomainEventPublisher<UserCreatedFailEvent> userCreatedFailEventDomainEventPublisher;
    public UserCreatedFailEvent(User user,
                                ZonedDateTime createdAt,
                                DomainEventPublisher<UserCreatedFailEvent> userCreatedFailEventDomainEventPublisher,
                                List<String>failureMessages) {
        super(user, createdAt, failureMessages);
        this.userCreatedFailEventDomainEventPublisher = userCreatedFailEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userCreatedFailEventDomainEventPublisher.publish(this);
    }
}
