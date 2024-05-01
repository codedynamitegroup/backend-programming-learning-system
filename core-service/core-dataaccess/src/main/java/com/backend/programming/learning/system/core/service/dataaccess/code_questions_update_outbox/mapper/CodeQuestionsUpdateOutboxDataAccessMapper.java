package com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.code_questions_update_outbox.entity.CodeQuestionsUpdateOutboxEntity;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class CodeQuestionsUpdateOutboxDataAccessMapper {
    public CodeQuestionsUpdateOutboxEntity
    outboxMessageToOutboxEntity(CodeQuestionsUpdateOutboxMessage message){
        return CodeQuestionsUpdateOutboxEntity.builder()
                .id(message.getId())
                .sagaId(message.getSagaId())
                .createdAt(message.getCreatedAt())
                .processedAt(message.getProcessedAt())
                .type(message.getType())
                .payload(message.getPayload())
                .outboxStatus(message.getOutboxStatus())
                .copyState(message.getCopyState())
                .version(message.getVersion())
                .build();
    }
    public  CodeQuestionsUpdateOutboxMessage
    outboxEntityToOutboxMessage(CodeQuestionsUpdateOutboxEntity message){
        return CodeQuestionsUpdateOutboxMessage.builder()
                .id(message.getId())
                .sagaId(message.getSagaId())
                .createdAt(message.getCreatedAt())
                .processedAt(message.getProcessedAt())
                .type(message.getType())
                .payload(message.getPayload())
                .outboxStatus(message.getOutboxStatus())
                .copyState(message.getCopyState())
                .version(message.getVersion())
                .build();
    }
}
