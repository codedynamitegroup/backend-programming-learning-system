package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import org.springframework.stereotype.Component;

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
                .copyState(CopyState.valueOf(questionResponseAvroModel.getCopyState().toString()))
                .serviceName(ServiceName.valueOf(questionResponseAvroModel.getServiceName().toString()))
                .build();
    }

    public QuestionRequestAvroModel questionEventPayloadToQuestionRequestAvroModel(String sagaId,
                                                                                   QuestionEventPayload questionEventPayload,
                                                                                   ServiceName serviceName) {
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
                .setCreatedBy(questionEventPayload.getCreatedBy())
                .setUpdatedBy(questionEventPayload.getUpdatedBy())
                .setCopyState(com.backend.programming.learning.system.kafka.core.avro.model.CopyState.valueOf(questionEventPayload.getCopyState().name()))
                .setServiceName(com.backend.programming.learning.system.kafka.core.avro.model.ServiceName.valueOf(serviceName.name()))
                .build();
    }
}
