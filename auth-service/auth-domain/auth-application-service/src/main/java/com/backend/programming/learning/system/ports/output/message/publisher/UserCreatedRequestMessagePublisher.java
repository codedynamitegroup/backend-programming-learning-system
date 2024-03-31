package com.backend.programming.learning.system.ports.output.message.publisher;

import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import com.backend.programming.learning.system.event.UserCreatedEvent;

public interface UserCreatedRequestMessagePublisher extends DomainEventPublisher<UserCreatedEvent> {
}
