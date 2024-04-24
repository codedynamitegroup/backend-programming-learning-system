package com.backend.programming.learning.system.core.service.domain.event.user;

import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.Collections;

public class UserUpdatedSuccessEvent extends UserEvent {
    private final DomainEventPublisher<UserUpdatedSuccessEvent> userUpdatedSuccessEventDomainEventPublisher;
    public UserUpdatedSuccessEvent(User user, ZonedDateTime createdAt, DomainEventPublisher<UserUpdatedSuccessEvent> userUpdatedSuccessEventDomainEventPublisher) {
        super(user, createdAt, Collections.emptyList());
        this.userUpdatedSuccessEventDomainEventPublisher = userUpdatedSuccessEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userUpdatedSuccessEventDomainEventPublisher.publish(this);
    }
}
