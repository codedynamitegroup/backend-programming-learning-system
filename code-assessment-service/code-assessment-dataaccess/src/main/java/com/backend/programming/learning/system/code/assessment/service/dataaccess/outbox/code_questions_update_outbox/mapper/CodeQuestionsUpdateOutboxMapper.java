package com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_questions_update_outbox.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.outbox.code_questions_update_outbox.entity.CodeQuestionsUpdateOutboxEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class CodeQuestionsUpdateOutboxMapper {
    public CodeQuestionsUpdateOutboxEntity
    codeQuestionsUpdateOutboxMessageToOutboxEntity
            (CodeQuestionsUpdateOutboxMessage outboxMessage){
        return CodeQuestionsUpdateOutboxEntity.builder()
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
    public CodeQuestionsUpdateOutboxMessage outboxMessageEntityToCodeQuestionsUpdateOutboxMessage
            (CodeQuestionsUpdateOutboxEntity entity){
        return CodeQuestionsUpdateOutboxMessage.builder()
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
}
