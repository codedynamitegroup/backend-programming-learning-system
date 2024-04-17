package com.backend.programming.learning.system.implement.question;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.dto.method.query.exam.QueryExamCommand;
import com.backend.programming.learning.system.entity.Exam;
import com.backend.programming.learning.system.entity.Organization;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.entity.User;
import com.backend.programming.learning.system.implement.exam.ExamCommandHandler;
import com.backend.programming.learning.system.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.ports.output.repository.ExamRepository;
import com.backend.programming.learning.system.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.valueobject.ExamId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

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

    public Question createQuestion(CreateQuestionCommand createQuestionCommand) {
        User createdBy =  getUser(createQuestionCommand.getCreatedBy());
        User updatedBy = getUser(createQuestionCommand.getUpdatedBy());
        Organization organization = getOrganization(createQuestionCommand.getOrganizationId());

        Question question = questionDataMapper.createQuestionCommandToQuestion(organization, createdBy, updatedBy, createQuestionCommand);
        courseDomainService.createQuestion(question);

        Question questionResult = saveQuestion(question);
        log.info("Question is created with id: {}", questionResult.getId());
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
        Optional<Organization> organization = organizationRepository.findOrganization(organizationId);
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
}
