package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionRequest;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.course.service.domain.event.question.event.QuestionEvent;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class QuestionMessagingMapper {
    public QuestionRequest questionRequestAvroModelToQuestionDeleteRequest(QuestionRequestAvroModel questionDeleteRequestAvroModel) {
        return QuestionRequest.builder()
                .id(questionDeleteRequestAvroModel.getId())
                .sagaId(questionDeleteRequestAvroModel.getSagaId())
                .organizationId(questionDeleteRequestAvroModel.getOrganizationId())
                .createdBy(questionDeleteRequestAvroModel.getCreatedBy())
                .updatedBy(questionDeleteRequestAvroModel.getUpdatedBy())
                .difficulty(questionDeleteRequestAvroModel.getDifficulty())
                .name(questionDeleteRequestAvroModel.getName())
                .questionText(questionDeleteRequestAvroModel.getQuestionText())
                .generalFeedback(questionDeleteRequestAvroModel.getGeneralFeedback())
                .defaultMark(questionDeleteRequestAvroModel.getDefaultMark())
                .qType(questionDeleteRequestAvroModel.getQType())
                .answers(questionDeleteRequestAvroModel.getAnswers())
                .build();
    }

    public QuestionRequest questionRequestAvroModelToQuestionCreateRequest(QuestionRequestAvroModel questionCreateRequestAvroModel) {
        return QuestionRequest.builder()
                .id(questionCreateRequestAvroModel.getId())
                .sagaId(questionCreateRequestAvroModel.getSagaId())
                .organizationId(questionCreateRequestAvroModel.getOrganizationId())
                .createdBy(questionCreateRequestAvroModel.getCreatedBy())
                .updatedBy(questionCreateRequestAvroModel.getUpdatedBy())
                .difficulty(questionCreateRequestAvroModel.getDifficulty())
                .name(questionCreateRequestAvroModel.getName())
                .questionText(questionCreateRequestAvroModel.getQuestionText())
                .generalFeedback(questionCreateRequestAvroModel.getGeneralFeedback())
                .defaultMark(questionCreateRequestAvroModel.getDefaultMark())
                .qType(questionCreateRequestAvroModel.getQType())
                .answers(questionCreateRequestAvroModel.getAnswers())
                .build();
    }

    public QuestionRequest questionRequestAvroModelToQuestionUpdateRequest(QuestionRequestAvroModel questionUpdateRequestAvroModel) {
        return QuestionRequest.builder()
                .id(questionUpdateRequestAvroModel.getId())
                .sagaId(questionUpdateRequestAvroModel.getSagaId())
                .organizationId(questionUpdateRequestAvroModel.getOrganizationId())
                .createdBy(questionUpdateRequestAvroModel.getCreatedBy())
                .updatedBy(questionUpdateRequestAvroModel.getUpdatedBy())
                .difficulty(questionUpdateRequestAvroModel.getDifficulty())
                .name(questionUpdateRequestAvroModel.getName())
                .questionText(questionUpdateRequestAvroModel.getQuestionText())
                .generalFeedback(questionUpdateRequestAvroModel.getGeneralFeedback())
                .defaultMark(questionUpdateRequestAvroModel.getDefaultMark())
                .qType(questionUpdateRequestAvroModel.getQType())
                .answers(questionUpdateRequestAvroModel.getAnswers())
                .build();
    }

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

    public QuestionResponseAvroModel questionResponseToQuestionResponseAvroModel(QuestionEvent questionEvent) {
        return QuestionResponseAvroModel.newBuilder()
                .setId(questionEvent.getQuestion().getId().getValue().toString())
                .setSagaId(questionEvent.getSagaId())
                .setOrganizationId(questionEvent.getQuestion().getOrganization().getId().getValue().toString())
                .setCreatedBy(questionEvent.getQuestion().getCreatedBy().getId().getValue().toString())
                .setUpdatedBy(questionEvent.getQuestion().getUpdatedBy().getId().getValue().toString())
                .setDifficulty(questionEvent.getQuestion().getDifficulty().toString())
                .setName(questionEvent.getQuestion().getName())
                .setQuestionText(questionEvent.getQuestion().getQuestionText())
                .setGeneralFeedback(questionEvent.getQuestion().getGeneralFeedback())
                .setDefaultMark(BigDecimal.valueOf(questionEvent.getQuestion().getDefaultMark()))
                .setQType(questionEvent.getQuestion().getQtype().toString())
                .setAnswers(questionEvent.getQuestion().getAnswers())
                .setCopyState(com.backend.programming.learning.system.kafka.core.avro.model.CopyState.valueOf(questionEvent.getCopyState().toString()))
                .build();
    }
}
