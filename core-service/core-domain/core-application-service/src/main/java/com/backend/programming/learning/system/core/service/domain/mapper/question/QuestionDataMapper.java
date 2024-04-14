package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionResponse;
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
    public User createQuestionCommandToUser(CreateQuestionCommand createQuestionCommand) {
        return User.builder()
                .id(new UserId(createQuestionCommand.getCreatedBy()))
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
                .updatedBy(new UserId(createQuestionCommand.getCreatedBy()))
                .qtype(QuestionType.valueOf(createQuestionCommand.getQType()))
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .build();
    }

    public CreateQuestionResponse questionToCreateQuestionResponse(Question question, String message) {
        return CreateQuestionResponse.builder()
                .questionId(question.getId())
                .message(message)
                .build();
    }
}
