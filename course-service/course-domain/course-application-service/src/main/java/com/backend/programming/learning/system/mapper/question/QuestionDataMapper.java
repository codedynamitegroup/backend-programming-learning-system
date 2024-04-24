package com.backend.programming.learning.system.mapper.question;

import com.backend.programming.learning.system.domain.valueobject.*;
import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.dto.method.message.QuestionCreateRequest;
import com.backend.programming.learning.system.dto.method.query.question.QueryAllQuestionResponse;
import com.backend.programming.learning.system.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.entity.QuestionBankCategory;
import com.backend.programming.learning.system.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.mapper.question
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 11:37 PM
 * Description: ...
 */
@Component
public class QuestionDataMapper {
    public Question createQuestionCommandToQuestion(Organization organization,
                                                    User createdBy,
                                                    CreateQuestionCommand createQuestionCommand) {
        return Question.builder()
                .organization(organization)
                .questionText(createQuestionCommand.getQuestionText())
                .difficulty(createQuestionCommand.getDifficulty())
                .name(createQuestionCommand.getName())
                .generalFeedback(createQuestionCommand.getGeneralFeedback())
                .defaultMark(createQuestionCommand.getDefaultMark())
                .qtype(createQuestionCommand.getQtype())
                .isQuestionBank(false)
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .build();
    }

    public CreateQuestionResponse questionToCreateQuestionResponse(Question question, String message) {
        return CreateQuestionResponse.builder()
                .questionId(question.getId())
                .organizationId(question.getOrganization().getId())
                .difficulty(question.getDifficulty())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .message(message)
                .build();
    }

    public QueryAllQuestionResponse questionsToQueryAllQuestionResponse(Page<Question> questions) {
        List<QuestionResponseEntity> questionResponseEntities = new ArrayList<>();
        questions.forEach(question -> questionResponseEntities.add(questionToQueryQuestionResponse(question)));
        return QueryAllQuestionResponse.builder()
                .questions(questionResponseEntities)
                .currentPage(questions.getNumber())
                .totalPages(questions.getTotalPages())
                .totalItems(questions.getTotalElements())
                .build();
    }

    public QuestionResponseEntity questionToQueryQuestionResponse(Question question) {
        return QuestionResponseEntity.builder()
                .questionId(question.getId())
                .organizationId(question.getOrganization().getId())
                .difficulty(question.getDifficulty())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .build();
    }

    public Question createQuestionCommandToQuestionBank(Organization organization, User createdBy, CreateQuestionCommand createQuestionCommand) {
        return Question.builder()
                .organization(organization)
                .questionText(createQuestionCommand.getQuestionText())
                .difficulty(createQuestionCommand.getDifficulty())
                .name(createQuestionCommand.getName())
                .generalFeedback(createQuestionCommand.getGeneralFeedback())
                .defaultMark(createQuestionCommand.getDefaultMark())
                .qtype(createQuestionCommand.getQtype())
                .isQuestionBank(true)
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .build();
    }
    public Question createQuestionCommandToQuestionBank(
            Organization organization, QuestionBankCategory questionBankCategory, User createdBy, CreateQuestionCommand createQuestionCommand) {
        return Question.builder()
                .organization(organization)
                .questionText(createQuestionCommand.getQuestionText())
                .difficulty(createQuestionCommand.getDifficulty())
                .name(createQuestionCommand.getName())
                .generalFeedback(createQuestionCommand.getGeneralFeedback())
                .defaultMark(createQuestionCommand.getDefaultMark())
                .qtype(createQuestionCommand.getQtype())
                .isQuestionBank(true)
                .questionBankCategory(questionBankCategory)
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .build();
    }

    public Question questionCreateRequestToQuestion(QuestionCreateRequest questionCreateRequest) {
        return Question.builder()
                .id( new QuestionId(UUID.fromString(questionCreateRequest.getId())))
                .organization(Organization.builder()
                        .id(new OrganizationId(UUID.fromString(questionCreateRequest.getOrganizationId())))
                        .build())
                .createdBy(User.builder()
                        .id(new UserId(UUID.fromString(questionCreateRequest.getCreatedBy())))
                        .build())
                .updatedBy(User.builder()
                        .id(new UserId(UUID.fromString(questionCreateRequest.getUpdatedBy())))
                        .build())
                .questionText(questionCreateRequest.getQuestionText())
                .difficulty(QuestionDifficulty.valueOf(questionCreateRequest.getDifficulty()))
                .name(questionCreateRequest.getName())
                .generalFeedback(questionCreateRequest.getGeneralFeedback())
                .defaultMark(questionCreateRequest.getDefaultMark().floatValue())
                .qtype(QuestionType.valueOf(questionCreateRequest.getQType()))
                .isQuestionBank(false)
                .answers(questionCreateRequest.getAnswers())
                .build();
    }
}
