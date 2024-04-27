package com.backend.programming.learning.system.course.service.domain.event.user;

import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

import java.time.ZonedDateTime;
import java.util.List;

public class UserDeletedFailEvent extends UserEvent {
    private final DomainEventPublisher<UserDeletedFailEvent> userDeletedFailEventDomainEventPublisher;
    public UserDeletedFailEvent(User user,
                                ZonedDateTime createdAt,
                                DomainEventPublisher<UserDeletedFailEvent> userDeletedFailEventDomainEventPublisher,
                                List<String> failureMessages) {
        super(user, createdAt, failureMessages);
        this.userDeletedFailEventDomainEventPublisher = userDeletedFailEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        userDeletedFailEventDomainEventPublisher.publish(this);
    }
}
