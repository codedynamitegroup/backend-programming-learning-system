package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.AnswerOfQuestionUpdateEntity;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionUpdateEntity;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionUpdatedEvent;
import com.backend.programming.learning.system.core.service.domain.valueobject.AnswerId;
import com.backend.programming.learning.system.domain.valueobject.*;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Question updateQuestionEntityToQuestion(UpdateQuestionUpdateEntity updateQuestionUpdateEntity,
                                                   Organization organization,
                                                   QuestionType qtype,
                                                   User createdBy,
                                                   List<AnswerOfQuestion> answers) {
        if (updateQuestionUpdateEntity == null) return null;

//        if (updateQuestionUpdateEntity.getAnswers() != null) {
//            answers = updateQuestionUpdateEntity.getAnswers()
//                    .stream()
//                    .map(this::answerOfQuestionUpdateEntityToAnswerOfQuestion)
//                    .toList();
//        }

        return Question.builder()
                .questionId(new QuestionId(updateQuestionUpdateEntity.getQuestionId()))
                .organization(organization)
                .name(updateQuestionUpdateEntity.getName())
                .questionText(updateQuestionUpdateEntity.getQuestionText())
                .generalFeedback(updateQuestionUpdateEntity.getGeneralFeedback())
                .defaultMark(updateQuestionUpdateEntity.getDefaultMark())
                .difficulty(updateQuestionUpdateEntity.getDifficulty())
                .updatedBy(User.builder()
                        .id(new UserId(updateQuestionUpdateEntity.getUpdatedBy()))
                        .build())
                .updatedAt(ZonedDateTime.now())
                .answers(answers)
                .qtype(qtype)
                .createdBy(createdBy)
                .build();
    }

    public AnswerOfQuestion answerOfQuestionUpdateEntityToAnswerOfQuestion(AnswerOfQuestionUpdateEntity answerOfQuestionUpdateEntity) {
        return AnswerOfQuestion.builder()
                .id(new AnswerId(answerOfQuestionUpdateEntity.getAnswerId()))
                .questionId(new QuestionId(answerOfQuestionUpdateEntity.getQuestionId()))
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
