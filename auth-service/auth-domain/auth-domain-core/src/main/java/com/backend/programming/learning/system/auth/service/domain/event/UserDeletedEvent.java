package com.backend.programming.learning.system.auth.service.domain.event;

import com.backend.programming.learning.system.auth.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;

public class UserDeletedEvent extends UserEvent {
    private final DomainEventPublisher<UserDeletedEvent> userDeletedEventDomainEventPublisher;
    public UserDeletedEvent(User user, ZonedDateTime createdAt, DomainEventPublisher<UserDeletedEvent> userDeletedEventDomainEventPublisher) {
        super(user, createdAt);
        this.userDeletedEventDomainEventPublisher = userDeletedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userDeletedEventDomainEventPublisher.publish(this);
    }
}
