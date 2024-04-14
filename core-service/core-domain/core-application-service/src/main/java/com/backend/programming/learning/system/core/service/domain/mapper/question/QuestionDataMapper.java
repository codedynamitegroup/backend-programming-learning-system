package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQuestionByIdCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.domain.valueobject.OrganizationId;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;

@Component
public class QuestionDataMapper {
    // create question command to question
    public Question createQuestionCommandToQuestion(CreateQuestionCommand createQuestionCommand) {
        return Question.builder()
                .organizationId(new OrganizationId(createQuestionCommand.getOrganizationId()))
                .name(createQuestionCommand.getName())
                .questionText(createQuestionCommand.getQuestionText())
                .generalFeedback(createQuestionCommand.getGeneralFeedback())
                .defaultMark(createQuestionCommand.getDefaultMark().floatValue())
                .difficulty(QuestionDifficulty.valueOf(createQuestionCommand.getDifficulty()))
                .createdBy(new UserId(createQuestionCommand.getCreatedBy()))
                .updatedBy(new UserId(createQuestionCommand.getCreatedBy()))
                .qtype(QuestionType.valueOf(createQuestionCommand.getQType()))
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
    }

    // question to create question response
    public CreateQuestionResponse questionToCreateQuestionResponse(Question question, String message) {
        return CreateQuestionResponse.builder()
                .questionId(question.getId())
                .message(message)
                .build();
    }

    // query question by id command to question
    public Question queryQuestionByIdCommandToQuestion(QueryQuestionByIdCommand queryQuestionByIdCommand) {
        return Question.builder()

                .build();
    }

    // question to query question response
    public QueryQuestionResponse questionToQueryQuestionResponse(Question question) {
        return QueryQuestionResponse.builder()
                .question(question)
                .build();
    }
}
