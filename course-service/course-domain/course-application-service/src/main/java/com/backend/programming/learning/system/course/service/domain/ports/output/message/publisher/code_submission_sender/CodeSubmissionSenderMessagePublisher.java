package com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.code_submission_sender;

import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionSenderOutboxMessage;
import com.backend.programming.learning.system.course.service.domain.outbox.model.organization.OrganizationOutboxMessage;
import com.backend.programming.learning.system.outbox.OutboxStatus;

import java.util.function.BiConsumer;

public interface CodeSubmissionSenderMessagePublisher {
    void publish(CodeSubmissionSenderOutboxMessage outboxMessage,
                 BiConsumer<CodeSubmissionSenderOutboxMessage, OutboxStatus> outboxCallback);
}
