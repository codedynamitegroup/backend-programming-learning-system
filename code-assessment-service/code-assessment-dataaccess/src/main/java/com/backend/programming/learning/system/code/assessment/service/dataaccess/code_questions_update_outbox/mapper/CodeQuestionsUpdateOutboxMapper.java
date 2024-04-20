package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_questions_update_outbox.entity.CodeQuestionsUpdateOutboxEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.code_questions_update_outbox.CodeQuestionsUpdateOutboxMessage;
import org.springframework.stereotype.Component;

@Component
public class CodeQuestionsUpdateOutboxMapper {
    public CodeQuestionsUpdateOutboxEntity
    codeQuestionsUpdateOutboxMessageToOutboxEntity
            (CodeQuestionsUpdateOutboxMessage codeQuestionsUpdateOutboxMessage){
        return CodeQuestionsUpdateOutboxEntity.builder()
                .id(codeQuestionsUpdateOutboxMessage.getId())
                .sagaId(codeQuestionsUpdateOutboxMessage.getSagaId())
                .createdAt(codeQuestionsUpdateOutboxMessage.getCreatedAt())
                .processedAt(codeQuestionsUpdateOutboxMessage.getProcessedAt())
                .type(codeQuestionsUpdateOutboxMessage.getType())
                .payload(codeQuestionsUpdateOutboxMessage.getPayload())
                .copyState(codeQuestionsUpdateOutboxMessage.getCopyState())
                .outboxStatus(codeQuestionsUpdateOutboxMessage.getOutboxStatus())
                .version(codeQuestionsUpdateOutboxMessage.getVersion())
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
                .version(entity.getVersion())
                .build();
    }
}
