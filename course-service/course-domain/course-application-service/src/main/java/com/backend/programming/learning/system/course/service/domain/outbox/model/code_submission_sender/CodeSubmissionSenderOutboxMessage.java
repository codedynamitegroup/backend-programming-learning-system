package com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender;

import com.backend.programming.learning.system.outbox.OutboxStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class CodeSubmissionSenderOutboxMessage {
    UUID id;
    UUID sagaId;
    ZonedDateTime createdAt;
    @Setter
    ZonedDateTime processedAt;
    String payload;
    Boolean sendStatus;
    @Setter
    OutboxStatus outboxStatus;
}
