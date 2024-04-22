package com.backend.programming.learning.system.core.service.domain.event.user;

import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.List;

public class UserUpdatedFailEvent extends UserEvent {
    private final DomainEventPublisher<UserUpdatedFailEvent> userUpdatedFailEventDomainEventPublisher;
    public UserUpdatedFailEvent(User user,
                                ZonedDateTime createdAt,
                                DomainEventPublisher<UserUpdatedFailEvent> userUpdatedFailEventDomainEventPublisher,
                                List<String> failureMessages) {
        super(user, createdAt, failureMessages);
        this.userUpdatedFailEventDomainEventPublisher = userUpdatedFailEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userUpdatedFailEventDomainEventPublisher.publish(this);
    }
}
