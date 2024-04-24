package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.domain.valueobject.QuestionResponseStatus;
import com.backend.programming.learning.system.dto.method.message.QuestionCreateRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionDeleteRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.dto.method.message.QuestionUpdateRequest;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.event.question.event.QuestionEvent;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionDeleteRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionUpdateRequestAvroModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class QuestionMessagingMapper {
    public QuestionDeleteRequest questionDeleteRequestAvroModelToQuestionDeleteRequest(QuestionDeleteRequestAvroModel questionDeleteRequestAvroModel) {
        return QuestionDeleteRequest.builder()
                .id(questionDeleteRequestAvroModel.getId())
                .build();
    }

    public QuestionCreateRequest questionCreateRequestAvroModelToQuestionCreateRequest(QuestionCreateRequestAvroModel questionCreateRequestAvroModel) {
        return QuestionCreateRequest.builder()
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

    public QuestionUpdateRequest questionUpdateRequestAvroModelToQuestionUpdateRequest(QuestionUpdateRequestAvroModel questionUpdateRequestAvroModel) {
        return QuestionUpdateRequest.builder()
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
                .questionResponseStatus(QuestionResponseStatus.valueOf(questionResponseAvroModel.getQuestionResponseStatus().toString()))
                .build();
    }

    public QuestionResponseAvroModel questionResponseToQuestionResponseAvroModel(QuestionEvent questionEvent) {
        return QuestionResponseAvroModel.newBuilder()
                .setId(questionEvent.getQuestion().getId().getValue().toString())
                .setSagaId("")
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
                .setQuestionResponseStatus(com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseStatus.valueOf(questionEvent.getStatus().toString()))
                .build();
    }
}
