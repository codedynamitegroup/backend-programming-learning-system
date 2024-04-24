package com.backend.programming.learning.system.auth.service.domain.ports.output.message.publisher.user;

import com.backend.programming.learning.system.auth.service.domain.event.user.UserUpdatedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface UserUpdatedMessagePublisher extends DomainEventPublisher<UserUpdatedEvent> {
}
