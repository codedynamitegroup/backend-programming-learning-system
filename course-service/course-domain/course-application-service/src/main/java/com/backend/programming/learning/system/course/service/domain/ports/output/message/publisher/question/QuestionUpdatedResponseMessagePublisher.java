package com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question;

import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;
import com.backend.programming.learning.system.course.service.domain.event.question.event.QuestionUpdatedEvent;

public interface QuestionUpdatedResponseMessagePublisher extends DomainEventPublisher<QuestionUpdatedEvent> { }