package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user;

import com.backend.programming.learning.system.core.service.domain.event.user.UserCreatedFailEvent;
import com.backend.programming.learning.system.core.service.domain.event.user.UserDeletedFailEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface UserDeleteFailedMessagePublisher extends DomainEventPublisher<UserDeletedFailEvent> {
}
