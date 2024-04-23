package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher;

import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface QuestionDeletedMessagePublisher extends DomainEventPublisher<QuestionDeletedEvent> {
}
