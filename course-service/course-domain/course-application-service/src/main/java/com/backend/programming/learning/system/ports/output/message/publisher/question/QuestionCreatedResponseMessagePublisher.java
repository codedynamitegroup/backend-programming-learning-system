package com.backend.programming.learning.system.ports.output.message.publisher.question;

import com.backend.programming.learning.system.domain.event.DomainEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import com.backend.programming.learning.system.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.event.question.event.QuestionEvent;

public interface QuestionCreatedResponseMessagePublisher extends DomainEventPublisher<QuestionCreatedEvent> { }
