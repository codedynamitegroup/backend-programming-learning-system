package com.backend.programming.learning.system.core.service.domain.event.user;

import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.Collections;

public class UserDeletedSuccessEvent extends UserEvent {
    private final DomainEventPublisher<UserDeletedSuccessEvent> userDeletedSuccessEventDomainEventPublisher;
    public UserDeletedSuccessEvent(User user, ZonedDateTime createdAt, DomainEventPublisher<UserDeletedSuccessEvent> userDeletedSuccessEventDomainEventPublisher) {
        super(user, createdAt, Collections.emptyList());
        this.userDeletedSuccessEventDomainEventPublisher = userDeletedSuccessEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userDeletedSuccessEventDomainEventPublisher.publish(this);
    }
}
