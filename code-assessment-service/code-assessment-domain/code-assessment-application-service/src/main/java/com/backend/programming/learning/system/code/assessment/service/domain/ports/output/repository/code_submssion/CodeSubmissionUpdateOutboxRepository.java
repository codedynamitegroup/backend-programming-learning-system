package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_submssion;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdateOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.backend.programming.learning.system.saga.SagaStatus;

import java.util.List;
import java.util.Optional;

public interface CodeSubmissionUpdateOutboxRepository {
    Optional<List<CodeSubmissionUpdateOutboxMessage>> findByTypeAndOutboxStatusAndSagaStatus(String type, OutboxStatus outboxStatus, SagaStatus ...sagaStatus);

    CodeSubmissionUpdateOutboxMessage save(CodeSubmissionUpdateOutboxMessage outboxMessage);

    void deleteByTypeAndOutboxStatusAndSagaStatus(String codeSubmissionUpdateSagaName, OutboxStatus outboxStatus, SagaStatus ...sagaStatus);
}
