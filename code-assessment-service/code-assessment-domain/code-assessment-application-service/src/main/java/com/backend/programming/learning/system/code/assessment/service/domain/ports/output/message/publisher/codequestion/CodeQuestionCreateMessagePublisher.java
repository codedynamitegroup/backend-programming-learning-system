package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.message.publisher.codequestion;

import com.backend.programming.learning.system.code.assessment.service.domain.event.CodeQuestionCreatedEvent;
import com.backend.programming.learning.system.domain.event.publisher.DomainEventPublisher;

public interface CodeQuestionCreateMessagePublisher
        extends DomainEventPublisher<CodeQuestionCreatedEvent> {

}
