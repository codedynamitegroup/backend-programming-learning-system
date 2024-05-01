package com.backend.programming.learning.system.core.service.messaging.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.domain.valueobject.QuestionResponseStatus;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionCreateRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionDeleteRequestAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionResponseAvroModel;
import com.backend.programming.learning.system.kafka.core.avro.model.QuestionUpdateRequestAvroModel;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class QuestionMessagingDataMapper {
    public QuestionCreateRequestAvroModel questionCreatedToQuestionCreateRequestAvroModel(QuestionCreatedEvent questionCreatedEvent) {
        Question question = questionCreatedEvent.getQuestion();

        return QuestionCreateRequestAvroModel.newBuilder()
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

    public QuestionDeleteRequestAvroModel questionDeletedToQuestionDeleteRequestAvroModel(QuestionDeletedEvent questionDeletedEvent) {
        Question question = questionDeletedEvent.getQuestion();

        return QuestionDeleteRequestAvroModel.newBuilder()
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

    public QuestionUpdateRequestAvroModel questionUpdatedToQuestionUpdateRequestAvroModel(QuestionUpdatedEvent questionUpdatedEvent) {
        Question question = questionUpdatedEvent.getQuestion();

        return QuestionUpdateRequestAvroModel.newBuilder()
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
                .questionResponseStatus(QuestionResponseStatus.valueOf(questionResponseAvroModel.getQuestionResponseStatus().toString()))
                .build();
    }
}
