package com.backend.programming.learning.system.core.service.domain.implement.question.saga;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.domain.event.EmptyEvent;
import com.backend.programming.learning.system.saga.SagaStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class QuestionDeleteSaga implements SagaStep<QuestionResponse, EmptyEvent, EmptyEvent> {
    @Override
    public EmptyEvent process(QuestionResponse data) {
        log.info("Processing question delete saga for question id: {}", data.getId());
        return null;
    }

    @Override
    public EmptyEvent rollback(QuestionResponse data) {
        log.info("Rollback question delete saga for question id: {}", data.getId());
        return null;
    }
}
