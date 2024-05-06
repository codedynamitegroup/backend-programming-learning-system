package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionRequest;
import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.ServiceName;
import org.springframework.stereotype.Component;

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
                .build();
    }

    public QuestionResponseAvroModel questionEventPayloadToQuestionResponseAvroModel(QuestionEventPayload questionEventPayload) {
        return QuestionResponseAvroModel.newBuilder()
                .setId(questionEventPayload.getId())
                .setSagaId(questionEventPayload.getSagaId())
                .setOrganizationId(questionEventPayload.getOrganizationId())
                .setCreatedBy(questionEventPayload.getCreatedBy())
                .setUpdatedBy(questionEventPayload.getUpdatedBy())
                .setDifficulty(questionEventPayload.getDifficulty())
                .setName(questionEventPayload.getName())
                .setQuestionText(questionEventPayload.getQuestionText())
                .setGeneralFeedback(questionEventPayload.getGeneralFeedback())
                .setDefaultMark(questionEventPayload.getDefaultMark())
                .setQType(questionEventPayload.getQType())
                .setCopyState(com.backend.programming.learning.system.kafka.core.avro.model.CopyState.valueOf(questionEventPayload.getCopyState().toString()))
                .setServiceName(com.backend.programming.learning.system.kafka.core.avro.model.ServiceName.valueOf(ServiceName.COURSE_SERVICE.name()))
                .build();
    }
}
