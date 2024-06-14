package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventAnswer;
import com.backend.programming.learning.system.core.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.domain.valueobject.ServiceName;
import com.backend.programming.learning.system.kafka.core.avro.model.AnswerOfQuestion;
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
                .copyState(CopyState.valueOf(questionResponseAvroModel.getCopyState().toString()))
                .serviceName(ServiceName.valueOf(questionResponseAvroModel.getServiceName().toString()))
                .build();
    }

    public QuestionRequestAvroModel questionEventPayloadToQuestionRequestAvroModel(String sagaId,
                                                                                   QuestionEventPayload questionEventPayload) {
        return QuestionRequestAvroModel.newBuilder()
                .setId(UUID.fromString(questionEventPayload.getId()))
                .setSagaId(sagaId)
                .setOrganizationId(UUID.fromString(questionEventPayload.getOrganizationId()))
                .setCreatedBy(UUID.fromString(questionEventPayload.getCreatedBy()))
                .setUpdatedBy(UUID.fromString(questionEventPayload.getUpdatedBy()))
                .setDifficulty(questionEventPayload.getDifficulty())
                .setName(questionEventPayload.getName())
                .setQuestionText(questionEventPayload.getQuestionText())
                .setGeneralFeedback(questionEventPayload.getGeneralFeedback())
                .setDefaultMark(questionEventPayload.getDefaultMark())
                .setQType(questionEventPayload.getQType())
                .setCopyState(com.backend.programming.learning.system.kafka.core.avro.model.CopyState.valueOf(questionEventPayload.getCopyState().name()))
                .setAnswers(questionEventAnswersToAnswerOfQuestions(questionEventPayload.getAnswers()))
                .build();


    }

    private AnswerOfQuestion questionEventAnswerToAnswerOfQuestion(QuestionEventAnswer questionEventAnswer) {
        return AnswerOfQuestion.newBuilder()
                .setId(UUID.fromString(questionEventAnswer.getId()))
                .setQuestionId(UUID.fromString(questionEventAnswer.getQuestionId()))
                .setAnswer(questionEventAnswer.getAnswer())
                .setFraction(BigDecimal.valueOf(questionEventAnswer.getFraction()))
                .setFeedback(questionEventAnswer.getFeedback())
                .build();
    }

    private List<AnswerOfQuestion> questionEventAnswersToAnswerOfQuestions(List<QuestionEventAnswer> questionEventAnswers) {
        return questionEventAnswers.stream()
                .map(this::questionEventAnswerToAnswerOfQuestion)
                .collect(Collectors.toList());
    }
}
