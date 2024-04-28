package com.backend.programming.learning.system.core.service.domain.implement.service.question.saga;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.question.QuestionCreatedMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.event.EmptyEvent;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class QuestionCreateSaga implements SagaStep<QuestionResponse, EmptyEvent, EmptyEvent> {
    private final CoreDomainService coreDomainService;
    private final QuestionRepository questionRepository;
    private final QuestionCreatedMessagePublisher questionCreatedMessagePublisher;

    public QuestionCreateSaga(
            CoreDomainService coreDomainService,
            QuestionRepository questionRepository,
            QuestionCreatedMessagePublisher questionCreatedMessagePublisher) {
        this.coreDomainService = coreDomainService;
        this.questionRepository = questionRepository;
        this.questionCreatedMessagePublisher = questionCreatedMessagePublisher;
    }

    @Override
    @Transactional
    public EmptyEvent process(QuestionResponse questionResponse) {
        log.info("Processing question create saga for question id: {}", questionResponse.getId());
        return EmptyEvent.INSTANCE;
    }

    @Override
    @Transactional
    public EmptyEvent rollback(QuestionResponse questionResponse) {
        log.info("Rollback question create saga for question id: {}", questionResponse.getId());
        return EmptyEvent.INSTANCE;
    }
}
