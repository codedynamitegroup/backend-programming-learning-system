package com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question;

import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface QuestionCreatedMessagePublisher extends DomainEventPublisher<QuestionCreatedEvent> {

}
