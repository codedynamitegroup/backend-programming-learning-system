package com.backend.programming.learning.system.code.assessment.service.domain.mapper;


import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.QuestionRequest;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.domain.DomainConstants;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class QuestionDataMapper {

    public QuestionEventPayload questionRequestToQuestionEventPayload(QuestionRequest questionRequest, CopyState copyState) {
        return QuestionEventPayload.builder()
                .id(questionRequest.getId())
                .sagaId(questionRequest.getSagaId())
                .organizationId(questionRequest.getOrganizationId())
                .createdBy(questionRequest.getCreatedBy())
                .updatedBy(questionRequest.getUpdatedBy())
                .difficulty(questionRequest.getDifficulty())
                .name(questionRequest.getName())
                .questionText(questionRequest.getQuestionText())
                .generalFeedback(questionRequest.getGeneralFeedback())
                .defaultMark(questionRequest.getDefaultMark())
                .qType(questionRequest.getQType())
                .copyState(copyState)
                .build();
    }
}
