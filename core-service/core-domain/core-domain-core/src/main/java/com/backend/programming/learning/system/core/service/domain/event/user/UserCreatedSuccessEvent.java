package com.backend.programming.learning.system.core.service.domain.event.user;

import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.Collections;

public class UserCreatedSuccessEvent extends UserEvent {
    private final DomainEventPublisher<UserCreatedSuccessEvent> userCreatedSucessEventDomainEventPublisher;
    public UserCreatedSuccessEvent(User user,
                                   ZonedDateTime createdAt,
                                   DomainEventPublisher<UserCreatedSuccessEvent> userCreatedSucessEventDomainEventPublisher) {
        super(user, createdAt, Collections.emptyList());
        this.userCreatedSucessEventDomainEventPublisher = userCreatedSucessEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userCreatedSucessEventDomainEventPublisher.publish(this);
    }
}
