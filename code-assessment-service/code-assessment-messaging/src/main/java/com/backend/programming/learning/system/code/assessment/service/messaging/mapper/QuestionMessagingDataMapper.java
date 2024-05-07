package com.backend.programming.learning.system.code.assessment.service.messaging.mapper;

import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.QuestionRequest;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import org.springframework.stereotype.Component;

@Component
public class QuestionMessagingDataMapper {
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
                .setServiceName(com.backend.programming.learning.system.kafka.core.avro.model.ServiceName.valueOf(
                        ServiceName.CODE_ASSESSMENT_SERVICE.name()))
                .build();
    }

}
