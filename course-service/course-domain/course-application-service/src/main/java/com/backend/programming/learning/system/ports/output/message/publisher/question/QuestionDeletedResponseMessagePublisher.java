package com.backend.programming.learning.system.ports.output.message.publisher.question;

import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import com.backend.programming.learning.system.event.question.event.QuestionDeletedEvent;

public interface QuestionDeletedResponseMessagePublisher extends DomainEventPublisher<QuestionDeletedEvent> { }
