package com.backend.programming.learning.system.course.service.domain.mapper.question;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionRequest;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QuestionExamDTO;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question.QuestionWithPageResponseEntity;
import com.backend.programming.learning.system.course.service.domain.event.question.event.QuestionEvent;
import com.backend.programming.learning.system.course.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.domain.valueobject.*;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question.CreateQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question.QueryAllQuestionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
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
                .questionText(createQuestionCommand.questionText())
                .difficulty(createQuestionCommand.difficulty())
                .name(createQuestionCommand.name())
                .generalFeedback(createQuestionCommand.generalFeedback())
                .defaultMark(createQuestionCommand.defaultMark())
                .qtype(createQuestionCommand.qtype())
                .isOrgQuestionBank(false)
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
                .qtype(question.getQtype())
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
                .id(question.getId().getValue())
                .organizationId(question.getOrganization().getId().getValue())
                .difficulty(question.getDifficulty())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .generalFeedback(question.getGeneralFeedback())
                .defaultMark(question.getDefaultMark())
                .qtype(question.getQtype())
                .createdAt(question.getCreatedAt())
                .updatedAt(question.getUpdatedAt())
                .build();
    }

    public Question createQuestionCommandToQuestionBank(Organization organization, User createdBy, CreateQuestionCommand createQuestionCommand) {
        return Question.builder()
                .organization(organization)
                .questionText(createQuestionCommand.questionText())
                .difficulty(createQuestionCommand.difficulty())
                .name(createQuestionCommand.name())
                .generalFeedback(createQuestionCommand.generalFeedback())
                .defaultMark(createQuestionCommand.defaultMark())
                .qtype(createQuestionCommand.qtype())
                .isOrgQuestionBank(true)
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .build();
    }
    public Question createQuestionCommandToQuestionBank(
            Organization organization, QuestionBankCategory questionBankCategory, User createdBy, CreateQuestionCommand createQuestionCommand) {
        return Question.builder()
                .organization(organization)
                .questionText(createQuestionCommand.questionText())
                .difficulty(createQuestionCommand.difficulty())
                .name(createQuestionCommand.name())
                .generalFeedback(createQuestionCommand.generalFeedback())
                .defaultMark(createQuestionCommand.defaultMark())
                .qtype(createQuestionCommand.qtype())
                .isOrgQuestionBank(true)
                .questionBankCategory(questionBankCategory)
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .build();
    }

    public Question questionCreateRequestToQuestion(QuestionRequest questionCreateRequest) {
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
                .isOrgQuestionBank(false)
                .build();
    }

    public Question questionCreateRequestToQuestion(Organization organization, User createdBy, QuestionRequest questionCreateRequest) {
        return Question.builder()
                .id( new QuestionId(UUID.fromString(questionCreateRequest.getId())))
                .organization(organization)
                .createdBy(createdBy)
                .updatedBy(createdBy)
                .createdAt(ZonedDateTime.now())
                .updatedAt(ZonedDateTime.now())
                .questionText(questionCreateRequest.getQuestionText())
                .difficulty(QuestionDifficulty.valueOf(questionCreateRequest.getDifficulty()))
                .name(questionCreateRequest.getName())
                .generalFeedback(questionCreateRequest.getGeneralFeedback())
                .defaultMark(questionCreateRequest.getDefaultMark().floatValue())
                .qtype(QuestionType.valueOf(questionCreateRequest.getQType()))
                .isOrgQuestionBank(false)
                .build();
    }

    public Question questionUpdateRequestToQuestion(QuestionRequest questionUpdateRequest) {
        return Question.builder()
                .id(new QuestionId(UUID.fromString(questionUpdateRequest.getId())))
                .organization(Organization.builder()
                        .id(new OrganizationId(UUID.fromString(questionUpdateRequest.getOrganizationId())))
                        .build())
                .createdBy(User.builder()
                        .id(new UserId(UUID.fromString(questionUpdateRequest.getCreatedBy())))
                        .build())
                .updatedBy(User.builder()
                        .id(new UserId(UUID.fromString(questionUpdateRequest.getUpdatedBy())))
                        .build())
                .questionText(questionUpdateRequest.getQuestionText())
                .difficulty(QuestionDifficulty.valueOf(questionUpdateRequest.getDifficulty()))
                .name(questionUpdateRequest.getName())
                .generalFeedback(questionUpdateRequest.getGeneralFeedback())
                .defaultMark(questionUpdateRequest.getDefaultMark().floatValue())
                .qtype(QuestionType.valueOf(questionUpdateRequest.getQType()))
                .isOrgQuestionBank(false)
                .build();
    }

    public Question questionDeleteRequestToQuestion(QuestionRequest questionDeleteRequest) {
        return Question.builder()
                .id(new QuestionId(UUID.fromString(questionDeleteRequest.getId())))
                .organization(Organization.builder()
                        .id(new OrganizationId(UUID.fromString(questionDeleteRequest.getOrganizationId())))
                        .build())
                .createdBy(User.builder()
                        .id(new UserId(UUID.fromString(questionDeleteRequest.getCreatedBy())))
                        .build())
                .updatedBy(User.builder()
                        .id(new UserId(UUID.fromString(questionDeleteRequest.getUpdatedBy())))
                        .build())
                .questionText(questionDeleteRequest.getQuestionText())
                .difficulty(QuestionDifficulty.valueOf(questionDeleteRequest.getDifficulty()))
                .name(questionDeleteRequest.getName())
                .generalFeedback(questionDeleteRequest.getGeneralFeedback())
                .defaultMark(questionDeleteRequest.getDefaultMark().floatValue())
                .qtype(QuestionType.valueOf(questionDeleteRequest.getQType()))
                .isOrgQuestionBank(false)
                .build();
    }

    public QuestionEventPayload questionEventToQuestionEventPayload(QuestionEvent questionEvent) {
        return QuestionEventPayload.builder()
                .id(questionEvent.getQuestion().getId().getValue().toString())
                .sagaId(questionEvent.getSagaId())
                .organizationId(questionEvent.getQuestion().getOrganization().getId().getValue().toString())
                .createdBy(questionEvent.getQuestion().getCreatedBy().getId().getValue().toString())
                .updatedBy(questionEvent.getQuestion().getUpdatedBy().getId().getValue().toString())
                .difficulty(questionEvent.getQuestion().getDifficulty().name())
                .name(questionEvent.getQuestion().getName())
                .questionText(questionEvent.getQuestion().getQuestionText())
                .generalFeedback(questionEvent.getQuestion().getGeneralFeedback())
                .defaultMark(BigDecimal.valueOf(questionEvent.getQuestion().getDefaultMark()))
                .qType(questionEvent.getQuestion().getQtype().name())
                .copyState(questionEvent.getCopyState())
                .build();
    }

    private QuestionWithPageResponseEntity questionToQuestionWithPageResponseEntity(QuestionExamDTO question) {
        return QuestionWithPageResponseEntity.builder()
                .id(question.getId())
                .difficulty(question.getDifficulty())
                .name(question.getName())
                .questionText(question.getQuestionText())
                .page(question.getPage())
                .qtype(question.getQtype())
                .defaultMark(question.getDefaultMark())
                .build();
    }

    public List<QuestionWithPageResponseEntity> questionListToQuestionResponseEntityList(List<QuestionExamDTO> questions) {
        return questions.stream().map(this::questionToQuestionWithPageResponseEntity).toList();
    }
}
