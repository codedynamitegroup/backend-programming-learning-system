package com.backend.programming.learning.system.ports.output.message.publisher.question;

import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import com.backend.programming.learning.system.event.question.event.QuestionCreateFailedEvent;

public interface QuestionCreateFailedResponseMessagePublisher extends DomainEventPublisher<QuestionCreateFailedEvent> { }
