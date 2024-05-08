package com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.question_outbox.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.question_outbox.entity.QuestionOutboxEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionOutboxMessage;
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
                .outboxStatus(questionOutboxMessage.getOutboxStatus())
                .version(questionOutboxMessage.getVersion())
                .build();
    }
}
