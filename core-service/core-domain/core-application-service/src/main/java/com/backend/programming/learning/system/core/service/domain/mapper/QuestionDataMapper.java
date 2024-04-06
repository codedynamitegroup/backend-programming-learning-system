package com.backend.programming.learning.system.core.service.domain.mapper;

import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.CreateQuestionResponse;
import com.backend.programming.learning.system.domain.entity.Organization;
import com.backend.programming.learning.system.domain.entity.Question;
import com.backend.programming.learning.system.domain.entity.User;
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
}
