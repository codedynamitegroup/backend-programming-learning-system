package com.backend.programming.learning.system.course.service.messaging.mapper;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.AnswerOfQuestionMessage;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionRequest;
import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.ServiceName;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuestionMessagingMapper {
    public QuestionRequest questionRequestAvroModelToQuestionDeleteRequest(QuestionRequestAvroModel questionDeleteRequestAvroModel) {
        return QuestionRequest.builder()
                .id(questionDeleteRequestAvroModel.getId().toString())
                .sagaId(questionDeleteRequestAvroModel.getSagaId())
                .organizationId(questionDeleteRequestAvroModel.getOrganizationId().toString())
                .createdBy(questionDeleteRequestAvroModel.getCreatedBy().toString())
                .updatedBy(questionDeleteRequestAvroModel.getUpdatedBy().toString())
                .difficulty(questionDeleteRequestAvroModel.getDifficulty())
                .name(questionDeleteRequestAvroModel.getName())
                .questionText(questionDeleteRequestAvroModel.getQuestionText())
                .generalFeedback(questionDeleteRequestAvroModel.getGeneralFeedback())
                .defaultMark(questionDeleteRequestAvroModel.getDefaultMark())
                .qType(questionDeleteRequestAvroModel.getQType())
                .answers(answerOfQuestionAvroModelListToAnswerOfQuestionList(questionDeleteRequestAvroModel.getAnswers()))
                .build();
    }

    public QuestionRequest questionRequestAvroModelToQuestionCreateRequest(QuestionRequestAvroModel questionCreateRequestAvroModel) {
        return QuestionRequest.builder()
                .id(questionCreateRequestAvroModel.getId().toString())
                .sagaId(questionCreateRequestAvroModel.getSagaId())
                .organizationId(questionCreateRequestAvroModel.getOrganizationId().toString())
                .createdBy(questionCreateRequestAvroModel.getCreatedBy().toString())
                .updatedBy(questionCreateRequestAvroModel.getUpdatedBy().toString())
                .difficulty(questionCreateRequestAvroModel.getDifficulty())
                .name(questionCreateRequestAvroModel.getName())
                .questionText(questionCreateRequestAvroModel.getQuestionText())
                .generalFeedback(questionCreateRequestAvroModel.getGeneralFeedback())
                .defaultMark(questionCreateRequestAvroModel.getDefaultMark())
                .qType(questionCreateRequestAvroModel.getQType())
                .answers(answerOfQuestionAvroModelListToAnswerOfQuestionList(questionCreateRequestAvroModel.getAnswers()))
                .build();
    }

    public QuestionRequest questionRequestAvroModelToQuestionUpdateRequest(QuestionRequestAvroModel questionUpdateRequestAvroModel) {
        return QuestionRequest.builder()
                .id(questionUpdateRequestAvroModel.getId().toString())
                .sagaId(questionUpdateRequestAvroModel.getSagaId())
                .organizationId(questionUpdateRequestAvroModel.getOrganizationId().toString())
                .createdBy(questionUpdateRequestAvroModel.getCreatedBy().toString())
                .updatedBy(questionUpdateRequestAvroModel.getUpdatedBy().toString())
                .difficulty(questionUpdateRequestAvroModel.getDifficulty())
                .name(questionUpdateRequestAvroModel.getName())
                .questionText(questionUpdateRequestAvroModel.getQuestionText())
                .generalFeedback(questionUpdateRequestAvroModel.getGeneralFeedback())
                .defaultMark(questionUpdateRequestAvroModel.getDefaultMark())
                .qType(questionUpdateRequestAvroModel.getQType())
                .answers(answerOfQuestionAvroModelListToAnswerOfQuestionList(questionUpdateRequestAvroModel.getAnswers()))
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

    private AnswerOfQuestionMessage answerOfQuestionAvroModelToAnswerOfQuestionMessage(com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion answerOfQuestionAvroModel) {
        return AnswerOfQuestionMessage.builder()
                .id(answerOfQuestionAvroModel.getId().toString())
                .questionId(answerOfQuestionAvroModel.getQuestionId().toString())
                .feedback(answerOfQuestionAvroModel.getFeedback())
                .answer(answerOfQuestionAvroModel.getAnswer())
                .fraction(answerOfQuestionAvroModel.getFraction().floatValue())
                .build();
    }

    private List<AnswerOfQuestionMessage> answerOfQuestionAvroModelListToAnswerOfQuestionList(List<com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion> answerOfQuestionAvroModelList) {
        return answerOfQuestionAvroModelList.stream()
                .map(this::answerOfQuestionAvroModelToAnswerOfQuestionMessage)
                .collect(Collectors.toList());
    }
}
