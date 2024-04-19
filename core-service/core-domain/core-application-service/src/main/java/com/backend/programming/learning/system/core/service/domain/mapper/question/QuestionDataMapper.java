package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.AnswerOfQuestionUpdateEntity;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.valueobject.AnswerId;
import com.backend.programming.learning.system.domain.valueobject.*;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Component
public class QuestionDataMapper {
    // create question command to question
    public Question createQuestionCommandToQuestion(CreateQuestionCommand createQuestionCommand,
                                                    Organization organization,
                                                    User createdBy,
                                                    User updatedBy) {
        return Question.builder()
                .organization(organization)
                .name(createQuestionCommand.getName())
                .questionText(createQuestionCommand.getQuestionText())
                .generalFeedback(createQuestionCommand.getGeneralFeedback())
                .defaultMark(createQuestionCommand.getDefaultMark().floatValue())
                .difficulty(QuestionDifficulty.valueOf(createQuestionCommand.getDifficulty()))
                .createdBy(createdBy)
                .updatedBy(updatedBy)
                .qtype(QuestionType.valueOf(createQuestionCommand.getQType()))
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
    }

    public List<AnswerOfQuestion> answerOfQuestionListToAnswerOfQuestionEntityList(List<com.backend.programming.learning.system.core.service.domain.dto.method.create.question.AnswerOfQuestion> answerOfQuestions
            , QuestionId questionId) {
        return List.of(answerOfQuestions.stream()
                .map(answerOfQuestion -> AnswerOfQuestion.builder()
                        .questionId(questionId)
                        .answer(answerOfQuestion.getAnswer())
                        .fraction(answerOfQuestion.getFraction())
                        .feedback(answerOfQuestion.getFeedback())
                        .build())
                .toArray(AnswerOfQuestion[]::new));
    }

    // question to create question response
    public CreateQuestionResponse questionCreatedEventToCreateQuestionResponse(QuestionCreatedEvent questionCreatedEvent, String message) {
        return CreateQuestionResponse.builder()
                .questionId(questionCreatedEvent.getQuestion().getId().getValue())
                .qtypeId(questionCreatedEvent.getQtypeID())
                .message(message)
                .build();
    }

    // question to query question response
    public QuestionResponseEntity questionToQuestionResponseEntity(Question question) {
        return QuestionResponseEntity.builder()
                .id(question.getId().getValue().toString())
                .organization(question.getOrganization())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .difficulty(question.getDifficulty())
                .createdBy(question.getCreatedBy())
                .updatedBy(question.getUpdatedBy())
                .qtype(question.getqtype())
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .answers(question.getAnswers())
                .build();
    }

    public AnswerOfQuestionDeleteResponse answerOfQuestionToAnswerOfQuestionDeleteResponse(UUID answerId) {
        return AnswerOfQuestionDeleteResponse.builder()
                .answerId(answerId)
                .message("Answer deleted successfully")
                .build();
    }

    public Question updateQuestionEntityToQuestion(UpdateQuestionEntity updateQuestionEntity,
                                                   QuestionId questionId,
                                                   Organization organization,
                                                   User createdBy,
                                                   QuestionType qtype,
                                                   List<AnswerOfQuestion> answers) {
        if (updateQuestionEntity == null) return null;

        if (updateQuestionEntity.getAnswers() != null) {
//            answers = updateQuestionEntity.getAnswers()
//                    .stream()
//                    .map(answer -> answerOfQuestionUpdateEntityToAnswerOfQuestion(answer, new QuestionId(
//                            updateQuestionEntity.getQuestionId())))
//                    .toList();

            answers = updateQuestionEntity.getAnswers()
                    .stream()
                    .map(answer -> answerOfQuestionUpdateEntityToAnswerOfQuestion(answer, new QuestionId(UUID.randomUUID())))
                    .toList();
        }

        return Question.builder()
                .questionId(questionId)
                .organization(organization)
                .name(updateQuestionEntity.getName())
                .questionText(updateQuestionEntity.getQuestionText())
                .generalFeedback(updateQuestionEntity.getGeneralFeedback())
                .defaultMark(updateQuestionEntity.getDefaultMark())
                .difficulty(updateQuestionEntity.getDifficulty())
                .updatedBy(User.builder()
                        .id(new UserId(updateQuestionEntity.getUpdatedBy()))
                        .build())
                .updatedAt(ZonedDateTime.now())
                .answers(answers)
                .qtype(qtype)
                .createdBy(createdBy)
                .build();
    }

    public AnswerOfQuestion answerOfQuestionUpdateEntityToAnswerOfQuestion(AnswerOfQuestionUpdateEntity answerOfQuestionUpdateEntity,
                                                                           QuestionId questionId) {
        return AnswerOfQuestion.builder()
                .id(new AnswerId(answerOfQuestionUpdateEntity.getAnswerId()))
//                .questionId(questionId)
                .answer(answerOfQuestionUpdateEntity.getAnswer())
                .fraction(answerOfQuestionUpdateEntity.getFraction())
                .feedback(answerOfQuestionUpdateEntity.getFeedback())
                .build();
    }

    public UpdateQuestionResponse questionUpdatedEventToUpdateQuestionRespond(QuestionUpdatedEvent questionUpdatedEvent, String qtypeCodeQuestionUpdatedSuccessfully) {
        return UpdateQuestionResponse.builder()
                .questionId(questionUpdatedEvent.getQuestion().getId().getValue())
                .qtypeId(questionUpdatedEvent.getQtypeID())
                .message(qtypeCodeQuestionUpdatedSuccessfully)
                .build();
    }
}
