package com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.code_questions_update_outbox;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.CodeQuestionsUpdateOutboxRepository;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;
import com.backend.programming.learning.system.saga.code_assessment.SagaConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class CodeQuestionsUpdateOutboxHelper {
    private final CodeQuestionsUpdateOutboxRepository codeQuestionsUpdateOutboxRepository;

    public CodeQuestionsUpdateOutboxHelper(CodeQuestionsUpdateOutboxRepository codeQuestionsUpdateOutboxRepository) {
        this.codeQuestionsUpdateOutboxRepository = codeQuestionsUpdateOutboxRepository;
    }

    @Transactional(readOnly = true)
    public Optional<List<CodeQuestionsUpdateOutboxMessage>>
            getCodeQuestionsUpdateOutboxMessageByOutboxStatusAndSagaStatus(
                    OutboxStatus outboxStatus, SagaStatus... sagaStatus){
        return codeQuestionsUpdateOutboxRepository.findByTypeAndOutboxStatusAndSagaStatus(
                SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME, outboxStatus, sagaStatus
        );
    }

    @Transactional(readOnly = true)
    public Optional<CodeQuestionsUpdateOutboxMessage>
            getCodeQuestionsUpdateOutboxMessageBySagaIdAndSagaStatus(UUID sagaId, SagaStatus ...sagaStatus){
        return codeQuestionsUpdateOutboxRepository.findByTypeAndSagaIdAndSagaStatus(
                SagaConstants.CODE_QUESTIONS_UPDATE_SAGA_NAME,
                sagaId, sagaStatus
        );
    }

}
