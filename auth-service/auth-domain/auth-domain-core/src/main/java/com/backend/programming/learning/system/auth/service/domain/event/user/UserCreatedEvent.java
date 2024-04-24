package com.backend.programming.learning.system.auth.service.domain.event.user;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class UserCreatedEvent extends UserEvent {
    private final DomainEventPublisher<UserCreatedEvent> userCreatedEventDomainEventPublisher;
    public UserCreatedEvent(User user, ZonedDateTime createdAt, DomainEventPublisher<UserCreatedEvent> userCreatedEventDomainEventPublisher) {
        super(user, createdAt);
        this.userCreatedEventDomainEventPublisher = userCreatedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userCreatedEventDomainEventPublisher.publish(this);
    }
}
