package com.backend.programming.learning.system.course.service.domain.outbox.scheduler.code_submission_sender;

import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionSenderOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox.CodeSubmissionSenderOutboxRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.outbox.QuestionOutboxRepository;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class CodeSubmissionSenderOutboxHelper {
    private final CodeSubmissionSenderOutboxRepository outboxRepository;
    private final ObjectMapper objectMapper;
    public Optional<List<CodeSubmissionSenderOutboxMessage>> getMessagesByOutboxStatus(OutboxStatus outboxStatus) {
        return outboxRepository.findByOutboxStatus(outboxStatus);
    }

    public void saveOutboxMessage(CodeSubmissionSenderOutboxMessage outboxMessage) {
        outboxRepository.save(outboxMessage);
    }

    public void deleteByOutboxStatus(OutboxStatus outboxStatus) {
        outboxRepository.deleteByOutboxStatus(outboxStatus);
    }
}
