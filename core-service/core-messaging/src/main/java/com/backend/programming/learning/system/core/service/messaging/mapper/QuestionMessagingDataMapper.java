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
    public QuestionRequestAvroModel questionCreatedToQuestionCreateRequestAvroModel(QuestionCreatedEvent questionCreatedEvent) {
        Question question = questionCreatedEvent.getQuestion();

        return QuestionRequestAvroModel.newBuilder()
                .setId(question.getId().getValue().toString())
                .setSagaId(UUID.randomUUID().toString())
                .setOrganizationId(question.getOrganization().getId().getValue().toString())
                .setCreatedBy(question.getCreatedBy().getId().getValue().toString())
                .setUpdatedBy(question.getUpdatedBy().getId().getValue().toString())
                .setDifficulty(question.getDifficulty().toString())
                .setName(question.getName())
                .setQuestionText(question.getQuestionText())
                .setGeneralFeedback(question.getGeneralFeedback())
                .setDefaultMark(BigDecimal.valueOf(question.getDefaultMark()))
                .setQType(question.getqtype().toString())
                .setAnswers(answerListToAnswerIdList(question.getAnswers()))
                .build();
    }

    public QuestionRequestAvroModel questionDeletedToQuestionDeleteRequestAvroModel(QuestionDeletedEvent questionDeletedEvent) {
        Question question = questionDeletedEvent.getQuestion();

        return QuestionRequestAvroModel.newBuilder()
                .setId(question.getId().getValue().toString())
                .setSagaId(UUID.randomUUID().toString())
                .setOrganizationId(question.getOrganization().getId().getValue().toString())
                .setCreatedBy(question.getCreatedBy().getId().getValue().toString())
                .setUpdatedBy(question.getUpdatedBy().getId().getValue().toString())
                .setDifficulty(question.getDifficulty().toString())
                .setName(question.getName())
                .setQuestionText(question.getQuestionText())
                .setGeneralFeedback(question.getGeneralFeedback())
                .setDefaultMark(BigDecimal.valueOf(question.getDefaultMark()))
                .setQType(question.getqtype().toString())
                .setAnswers(answerListToAnswerIdList(question.getAnswers()))
                .build();
    }

    public QuestionRequestAvroModel questionUpdatedToQuestionUpdateRequestAvroModel(QuestionUpdatedEvent questionUpdatedEvent) {
        Question question = questionUpdatedEvent.getQuestion();

        return QuestionRequestAvroModel.newBuilder()
                .setId(question.getId().getValue().toString())
                .setSagaId(UUID.randomUUID().toString())
                .setOrganizationId(question.getOrganization().getId().getValue().toString())
                .setCreatedBy(question.getCreatedBy().getId().getValue().toString())
                .setUpdatedBy(question.getUpdatedBy().getId().getValue().toString())
                .setDifficulty(question.getDifficulty().toString())
                .setName(question.getName())
                .setQuestionText(question.getQuestionText())
                .setGeneralFeedback(question.getGeneralFeedback())
                .setDefaultMark(BigDecimal.valueOf(question.getDefaultMark()))
                .setQType(question.getqtype().toString())
                .setAnswers(answerListToAnswerIdList(question.getAnswers()))
                .build();
    }

    private List<String> answerListToAnswerIdList(List<AnswerOfQuestion> answers) {
        return answers.stream()
                .map(answer -> answer.getId().getValue().toString())
                .collect(Collectors.toList());
    }

    public QuestionResponse questionResponseAvroModelToQuestionResponse(QuestionResponseAvroModel questionResponseAvroModel) {
        return QuestionResponse.builder()
                .id(questionResponseAvroModel.getId())
                .sagaId(UUID.randomUUID().toString())
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
                .setId(UUID.randomUUID().toString())
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
