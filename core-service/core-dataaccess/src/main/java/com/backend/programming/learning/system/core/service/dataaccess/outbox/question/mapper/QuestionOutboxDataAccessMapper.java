package com.backend.programming.learning.system.core.service.dataaccess.outbox.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.outbox.question.entity.QuestionOutboxEntity;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class QuestionOutboxDataAccessMapper {
    public QuestionOutboxMessage questionOutboxEntityToQuestionOutboxMessage(QuestionOutboxEntity questionOutboxEntity) {
        return QuestionOutboxMessage.builder()
                .id(questionOutboxEntity.getId())
                .sagaId(questionOutboxEntity.getSagaId())
                .createdAt(questionOutboxEntity.getCreatedAt())
                .type(questionOutboxEntity.getType())
                .payload(questionOutboxEntity.getPayload())
                .copyState(questionOutboxEntity.getCopyState())
                .sagaStatus(questionOutboxEntity.getSagaStatus())
                .outboxStatus(questionOutboxEntity.getOutboxStatus())
                .version(questionOutboxEntity.getVersion())
                .build();
    }

    public QuestionOutboxEntity questionOutboxMessageToQuestionOutboxEntity(QuestionOutboxMessage questionOutboxMessage) {
        return QuestionOutboxEntity.builder()
                .id(questionOutboxMessage.getId())
                .sagaId(questionOutboxMessage.getSagaId())
                .createdAt(questionOutboxMessage.getCreatedAt())
                .type(questionOutboxMessage.getType())
                .payload(questionOutboxMessage.getPayload())
                .copyState(questionOutboxMessage.getCopyState())
                .sagaStatus(questionOutboxMessage.getSagaStatus())
                .outboxStatus(questionOutboxMessage.getOutboxStatus())
                .version(questionOutboxMessage.getVersion())
                .build();
    }
}
