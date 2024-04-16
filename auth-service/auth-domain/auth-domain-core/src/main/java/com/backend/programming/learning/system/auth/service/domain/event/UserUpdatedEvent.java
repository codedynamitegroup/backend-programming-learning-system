package com.backend.programming.learning.system.auth.service.domain.event;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class UserUpdatedEvent extends UserEvent {
    private final DomainEventPublisher<UserUpdatedEvent> userUpdatedEventDomainEventPublisher;
    public UserUpdatedEvent(User user, ZonedDateTime createdAt, DomainEventPublisher<UserUpdatedEvent> userUpdatedEventDomainEventPublisher) {
        super(user, createdAt);
        this.userUpdatedEventDomainEventPublisher = userUpdatedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userUpdatedEventDomainEventPublisher.publish(this);
    }
}
