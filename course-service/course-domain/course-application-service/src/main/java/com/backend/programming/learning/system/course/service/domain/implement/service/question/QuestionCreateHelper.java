package com.backend.programming.learning.system.course.service.domain.implement.service.question;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionRequest;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionBankCategoryRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * com.backend.programming.learning.system.implement.question
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 11:45 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionCreateHelper {
    private final CourseDomainService courseDomainService;
    private final QuestionDataMapper questionDataMapper;
    private final QuestionRepository questionRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final QuestionBankCategoryRepository questionBankCategoryRepository;

    public Question createQuestion(CreateQuestionCommand createQuestionCommand) {
        User createdBy = getUser(createQuestionCommand.createdBy());
        Organization organization = getOrganization(createQuestionCommand.organizationId());

        Question question = questionDataMapper.createQuestionCommandToQuestion(organization, createdBy, createQuestionCommand);
        courseDomainService.createQuestion(question);

        Question questionResult = saveQuestion(question);
        log.info("Question is created with id: {}", questionResult.getId());
        return questionResult;
    }

    public Question createQuestion(QuestionRequest questionRequest) {
        User createdBy = getUser(UUID.fromString(questionRequest.getCreatedBy()));
        Organization organization = getOrganization(UUID.fromString(questionRequest.getOrganizationId()));
        Question question = questionDataMapper.questionCreateRequestToQuestion(organization, createdBy, questionRequest);
        Question questionResult = saveQuestion(question);

        log.info("Question is created from create question request with id: {}", questionResult.getId());
        return questionResult;
    }

    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new RuntimeException("User not found");
        }
        return user.get();
    }

    private Organization getOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganizationById(organizationId);
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new RuntimeException("Organization not found");
        }
        return organization.get();
    }

    private Question saveQuestion(Question question) {
        Question savedQuestion = questionRepository.saveQuestion(question);

        if (savedQuestion == null) {
            log.error("Failed to save question");
            throw new RuntimeException("Failed to save question");
        }
        log.info("Question saved successfully with id: {}", savedQuestion.getId());
        return savedQuestion;
    }

    public Question createQuestionBank(CreateQuestionCommand createQuestionCommand) {
        User createdBy = getUser(createQuestionCommand.createdBy());
        Organization organization = getOrganization(createQuestionCommand.organizationId());

        Question question = null;
        if (Objects.isNull(createQuestionCommand.questionBankCategoryId())) {
            question = questionDataMapper.createQuestionCommandToQuestionBank(organization, createdBy, createQuestionCommand);
        } else {
            QuestionBankCategory questionBankCategory = questionBankCategoryRepository
                    .findQuestionBankCategoryById(createQuestionCommand.questionBankCategoryId())
                    .orElseThrow(() -> new RuntimeException("Question bank category not found"));
            question = questionDataMapper.createQuestionCommandToQuestionBank(organization, questionBankCategory, createdBy, createQuestionCommand);
        }
        courseDomainService.createQuestion(question);

        Question questionResult = saveQuestion(question);
        log.info("Question bank is created with id: {}", questionResult.getId());
        return questionResult;
    }
}
