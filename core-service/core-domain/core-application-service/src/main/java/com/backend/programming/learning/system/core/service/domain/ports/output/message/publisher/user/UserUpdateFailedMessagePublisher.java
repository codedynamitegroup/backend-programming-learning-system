package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user;

import com.backend.programming.learning.system.core.service.domain.event.user.UserUpdatedFailEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface UserUpdateFailedMessagePublisher extends DomainEventPublisher<UserUpdatedFailEvent> {
}
