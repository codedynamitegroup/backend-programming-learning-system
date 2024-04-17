package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
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
                .build();
    }

    public List<QuestionResponseEntity> questionListToQueryQuestionResponseList(List<Question> questions) {
        return List.of(questions.stream()
                .map(this::questionToQuestionResponseEntity)
                .toArray(QuestionResponseEntity[]::new));
    }

    public AnswerOfQuestionDeleteResponse answerOfQuestionToAnswerOfQuestionDeleteResponse(UUID answerId) {
        return AnswerOfQuestionDeleteResponse.builder()
                .answerId(answerId)
                .message("Answer deleted successfully")
                .build();
    }
}
