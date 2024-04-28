package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.contest_user;

import com.backend.programming.learning.system.core.service.domain.event.contest_user.ContestUserUpdatedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface ContestUserUpdatedMessagePublisher extends DomainEventPublisher<ContestUserUpdatedEvent> {
}
