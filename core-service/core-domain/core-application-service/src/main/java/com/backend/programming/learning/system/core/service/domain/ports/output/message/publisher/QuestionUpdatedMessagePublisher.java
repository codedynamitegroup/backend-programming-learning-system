package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher;

import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface QuestionUpdatedMessagePublisher extends DomainEventPublisher<QuestionUpdatedEvent> {
}
