package com.backend.programming.learning.system.core.service.domain.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.*;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.*;
import org.springframework.stereotype.Component;

@Component
public class QuestionDataMapper {
    public User createQuestionCommandToUser(CreateQuestionCommand createQuestionCommand) {
        return User.builder()
                .userId(new UserId(createQuestionCommand.getCreatedBy()))
                .build();
    }

    public Organization createQuestionCommandToOrganization(CreateQuestionCommand createQuestionCommand) {
        return Organization.builder()
                .organizationId(new OrganizationId(createQuestionCommand.getOrganizationId()))
                .build();
    }

    public Question createQuestionCommandToQuestion(CreateQuestionCommand createQuestionCommand) {
        return Question.builder()
                .organizationId(new OrganizationId(createQuestionCommand.getOrganizationId()))
                .name(createQuestionCommand.getName())
                .questionText(createQuestionCommand.getQuestionText())
                .generalFeedback(createQuestionCommand.getGeneralFeedback())
                .defaultMark(createQuestionCommand.getDefaultMark().floatValue())
                .difficulty(QuestionDifficulty.valueOf(createQuestionCommand.getDifficulty()))
                .createdBy(new UserId(createQuestionCommand.getCreatedBy()))
                .updatedBy(new UserId(createQuestionCommand.getUpdatedBy()))
                .qType(QuestionType.valueOf(createQuestionCommand.getQType()))
                .build();
    }

    public CreateQuestionResponse questionToCreateQuestionResponse(Question question, String message) {
        return CreateQuestionResponse.builder()
                .questionId(question.getId())
                .message(message)
                .build();
    }

    public QtypeCodeQuestion createQuestionCommandToQtypeCodeQuestion(CreateQuestionCommand createQuestionCommand,
                                                                      QuestionId questionId) {
        return QtypeCodeQuestion.builder()
                .questionId(questionId)
                .dslTemplate(createQuestionCommand.getDslTemplate())
                .build();
    }

    public QtypeShortAnswerQuestion createQuestionCommandToQtypeShortAnswerQuestion(CreateQuestionCommand createQuestionCommand,
                                                                                    QuestionId questionId) {
        return QtypeShortAnswerQuestion.builder()
                .questionId(questionId)
                .caseSensitive(createQuestionCommand.getCaseSensitive())
                .build();
    }

    public QtypeEssayQuestion createQuestionCommandToQtypeEssayQuestion(CreateQuestionCommand createQuestionCommand,
                                                                        QuestionId questionId) {
        return QtypeEssayQuestion.builder()
                .questionId(questionId)
                .responseFormat(createQuestionCommand.getResponseFormat())
                .responseRequired(createQuestionCommand.getResponseRequired())
                .responseFieldLines(createQuestionCommand.getResponseFieldLines())
                .minWordLimit(createQuestionCommand.getMinWordLimit())
                .maxWordLimit(createQuestionCommand.getMaxWordLimit())
                .attachments(createQuestionCommand.getAttachments())
                .attachmentsRequired(createQuestionCommand.getAttachmentsRequired())
                .graderInfo(createQuestionCommand.getGraderInfo())
                .graderInfoFormat(createQuestionCommand.getGraderInfoFormat())
                .responseTemplate(createQuestionCommand.getResponseTemplate())
                .maxBytes(createQuestionCommand.getMaxBytes())
                .fileTypesList(createQuestionCommand.getFileTypesList())
                .build();
    }

    public QtypeMultiChoiceQuestion createQuestionCommandToQtypeMultiChoiceQuestion(CreateQuestionCommand createQuestionCommand,
                                                                                    QuestionId questionId) {
        return QtypeMultiChoiceQuestion.builder()
                .questionId(questionId)
                .single(createQuestionCommand.getSingle())
                .shuffleAnswers(createQuestionCommand.getShuffleAnswers())
                .correctFeedback(createQuestionCommand.getCorrectFeedback())
                .partiallyCorrectFeedback(createQuestionCommand.getPartiallyCorrectFeedback())
                .incorrectFeedback(createQuestionCommand.getIncorrectFeedback())
                .answerNumbering(createQuestionCommand.getAnswerNumbering())
                .showNumCorrect(createQuestionCommand.getShowNumCorrect())
                .showStandardInstructions(createQuestionCommand.getShowStandardInstructions())
                .build();
    }
}
