package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.user;

import com.backend.programming.learning.system.core.service.domain.event.user.UserDeletedSuccessEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface UserDeletedSuccessMessagePublisher extends DomainEventPublisher<UserDeletedSuccessEvent> {
}
