package com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_update_outbox.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_submission_update_outbox.entity.CodeSubmissionUpdateOutboxEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_submission_update_outbox.CodeSubmissionUpdateOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class CodeSubmissionUpdateOutboxMapper {
    public CodeSubmissionUpdateOutboxMessage outboxMessageEntityToCodeSubmissionUpdateOutboxMessage(CodeSubmissionUpdateOutboxEntity entity) {
        return CodeSubmissionUpdateOutboxMessage.builder()
                .id(entity.getId())
                .sagaId(entity.getSagaId())
                .createdAt(entity.getCreatedAt())
                .processedAt(entity.getProcessedAt())
                .type(entity.getType())
                .payload(entity.getPayload())
                .copyState(entity.getCopyState())
                .outboxStatus(entity.getOutboxStatus())
                .sagaStatus(entity.getSagaStatus())
                .version(entity.getVersion())
                .build();
    }

    public CodeSubmissionUpdateOutboxEntity codeSubmisisonUpdateOutboxMessageToOutboxEntity(CodeSubmissionUpdateOutboxMessage outboxMessage) {
        return CodeSubmissionUpdateOutboxEntity.builder()
                .id(outboxMessage.getId())
                .sagaId(outboxMessage.getSagaId())
                .createdAt(outboxMessage.getCreatedAt())
                .processedAt(outboxMessage.getProcessedAt())
                .type(outboxMessage.getType())
                .payload(outboxMessage.getPayload())
                .copyState(outboxMessage.getCopyState())
                .sagaStatus(outboxMessage.getSagaStatus())
                .outboxStatus(outboxMessage.getOutboxStatus())
                .version(outboxMessage.getVersion())
                .build();
    }
}
