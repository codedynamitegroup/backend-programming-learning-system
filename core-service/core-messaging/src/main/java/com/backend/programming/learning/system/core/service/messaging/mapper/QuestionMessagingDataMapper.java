package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class QuestionMessagingDataMapper {
    public QuestionResponse questionResponseAvroModelToQuestionResponse(QuestionResponseAvroModel questionResponseAvroModel) {
        return QuestionResponse.builder()
                .id(questionResponseAvroModel.getId())
                .sagaId(questionResponseAvroModel.getSagaId())
                .organizationId(questionResponseAvroModel.getOrganizationId())
                .createdBy(questionResponseAvroModel.getCreatedBy())
                .updatedBy(questionResponseAvroModel.getUpdatedBy())
                .difficulty(questionResponseAvroModel.getDifficulty())
                .name(questionResponseAvroModel.getName())
                .questionText(questionResponseAvroModel.getQuestionText())
                .generalFeedback(questionResponseAvroModel.getGeneralFeedback())
                .defaultMark(questionResponseAvroModel.getDefaultMark())
                .qType(questionResponseAvroModel.getQType())
                .answers(questionResponseAvroModel.getAnswers())
                .copyState(CopyState.valueOf(questionResponseAvroModel.getCopyState().toString()))
                .build();
    }

    public QuestionRequestAvroModel questionEventPayloadToQuestionRequestAvroModel(String sagaId,
                                                                                   QuestionEventPayload questionEventPayload) {
        return QuestionRequestAvroModel.newBuilder()
                .setId(questionEventPayload.getId())
                .setSagaId(sagaId)
                .setOrganizationId(questionEventPayload.getOrganizationId())
                .setCreatedBy(questionEventPayload.getCreatedBy())
                .setUpdatedBy(questionEventPayload.getUpdatedBy())
                .setDifficulty(questionEventPayload.getDifficulty())
                .setName(questionEventPayload.getName())
                .setQuestionText(questionEventPayload.getQuestionText())
                .setGeneralFeedback(questionEventPayload.getGeneralFeedback())
                .setDefaultMark(questionEventPayload.getDefaultMark())
                .setQType(questionEventPayload.getQType())
                .setAnswers(questionEventPayload
                        .getAnswers()
                        .stream()
                        .map(answerOfQuestion -> answerOfQuestion.getId().toString())
                        .collect(Collectors.toList()))
                .setCreatedBy(questionEventPayload.getCreatedBy())
                .setUpdatedBy(questionEventPayload.getUpdatedBy())
                .setCopyState(com.backend.programming.learning.system.kafka.core.avro.model.CopyState.valueOf(questionEventPayload.getCopyState().name()))
                .build();
    }
}
