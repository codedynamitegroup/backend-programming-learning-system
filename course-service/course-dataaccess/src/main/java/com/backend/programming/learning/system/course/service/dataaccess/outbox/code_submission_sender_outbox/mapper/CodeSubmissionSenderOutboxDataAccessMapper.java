package com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.outbox.code_submission_sender_outbox.entity.CodeSubmissionSenderOutboxEntity;
import com.backend.programming.learning.system.course.service.domain.outbox.model.code_submission_sender.CodeSubmissionSenderOutboxMessage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CodeSubmissionSenderOutboxDataAccessMapper {
    public CodeSubmissionSenderOutboxEntity messageToEntity(CodeSubmissionSenderOutboxMessage message) {
        return CodeSubmissionSenderOutboxEntity.builder()
                .id(message.getId())
                .sagaId(message.getSagaId())
                .outboxStatus(message.getOutboxStatus())
                .payload(message.getPayload())
                .sendStatus(message.getSendStatus())
                .createdAt(message.getCreatedAt())
                .processedAt(message.getProcessedAt())
                .build();
    }


    public CodeSubmissionSenderOutboxMessage entityToMessage(CodeSubmissionSenderOutboxEntity entity) {
        return CodeSubmissionSenderOutboxMessage.builder()
                .id(entity.getId())
                .sagaId(entity.getSagaId())
                .outboxStatus(entity.getOutboxStatus())
                .payload(entity.getPayload())
                .sendStatus(entity.getSendStatus())
                .createdAt(entity.getCreatedAt())
                .processedAt(entity.getProcessedAt())
                .build();
    }
}
