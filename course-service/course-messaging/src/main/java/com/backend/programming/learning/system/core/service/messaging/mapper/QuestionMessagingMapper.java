package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.dto.method.message.QuestionCreateRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionDeleteRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionUpdateRequest;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionDeleteRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionUpdateRequestAvroModel;
import org.springframework.stereotype.Component;

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
}
