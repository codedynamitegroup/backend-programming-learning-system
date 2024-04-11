package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.create;

import com.backend.programming.learning.system.domain.event.Question.QuestionCreatedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface QuestionCreatedMessagePublisher extends DomainEventPublisher<QuestionCreatedEvent> {
}
