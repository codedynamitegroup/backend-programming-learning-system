package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;

public interface CodeQuestionsUpdateOutboxRepository
        extends OutboxRepository<CodeQuestionsUpdateOutboxMessage>{

}
