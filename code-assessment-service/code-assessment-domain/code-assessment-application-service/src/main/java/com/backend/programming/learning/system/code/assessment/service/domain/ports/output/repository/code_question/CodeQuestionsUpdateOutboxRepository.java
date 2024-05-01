package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.OutboxSendRepository;

public interface CodeQuestionsUpdateOutboxRepository
        extends OutboxSendRepository<CodeQuestionsUpdateOutboxMessage> {

}
