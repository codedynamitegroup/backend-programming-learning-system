package com.backend.programming.learning.system.course.service.domain.implement.service.question;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.AnswerOfQuestionMessage;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionRequest;
import com.backend.programming.learning.system.course.service.domain.entity.*;
import com.backend.programming.learning.system.course.service.domain.implement.service.answerOfQuestion.AnswerOfQuestionHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionBankCategoryRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * com.backend.programming.learning.system.implement.question
 * Create by Dang Ngoc Tien
 * Date 4/17/2024 - 11:45 PM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionCreateUpdateHelper {
    private final CourseDomainService courseDomainService;
    private final QuestionDataMapper questionDataMapper;
    private final QuestionRepository questionRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final QuestionBankCategoryRepository questionBankCategoryRepository;
    private final AnswerOfQuestionHelper answerOfQuestionCreateHelper;

    @Transactional
    public Question createQuestion(CreateQuestionCommand createQuestionCommand) {
        User createdBy = getUser(createQuestionCommand.createdBy());
        Organization organization = getOrganization(createQuestionCommand.organizationId());

        Question question = questionDataMapper.createQuestionCommandToQuestion(organization, createdBy, createQuestionCommand);
        courseDomainService.createQuestion(question);

        Question questionResult = saveQuestion(question);
        log.info("Question is created with id: {}", questionResult.getId());
        return questionResult;
    }

    @Transactional
    public Question createQuestion(QuestionRequest questionRequest) {
        User createdBy = getUser(UUID.fromString(questionRequest.getCreatedBy()));
        Organization organization = getOrganization(UUID.fromString(questionRequest.getOrganizationId()));
        Question question = questionDataMapper.questionCreateRequestToQuestion(organization, createdBy, questionRequest);
        Question questionResult = saveQuestion(question);

        log.info("Question is created from create question request with id: {}", questionResult.getId());

        answerOfQuestionCreateHelper.saveAnswerOfQuestion(questionRequest.getAnswers());
        log.info("Create question and answer of question successfully for question id: {}", questionResult.getId());
        return questionResult;
    }

    @Transactional
    public Question saveQuestion(QuestionRequest questionRequest) {
        Optional<Question> question = questionRepository.findById(UUID.fromString(questionRequest.getId()));

        if(question.isEmpty()) {
            log.error("Question with id: {} not found", questionRequest.getId());
            throw new QuestionNotFoundException("Question with id: " + questionRequest.getId() + " not found");
        }

        Question result = questionRepository.saveQuestion(questionDataMapper.questionUpdateRequestToQuestion(questionRequest));

        log.info("Question id: {}  is updated with", questionRequest.getId());

        // Handle answer of question
        if (questionRequest.getAnswers().isEmpty()) {
            answerOfQuestionCreateHelper.deleteAllByQuestionId(result.getId().getValue());
            log.info("Deleted all answer of question for question id: {}", questionRequest.getId());
        }
        else {
            // Find the current answer list
            List<AnswerOfQuestion> answerOfQuestionList = answerOfQuestionCreateHelper.findAllByQuestionId(result.getId().getValue());

            // Delete answer list
            List<String> answerIdFromRequest = questionRequest.getAnswers().stream()
                    .map(AnswerOfQuestionMessage::getId)
                    .toList();
            List<UUID> deleteIdList = answerOfQuestionList
                    .stream()
                    .map(AnswerOfQuestion::getId)
                    .map(id -> id.getValue().toString())
                    .filter(answerId -> !answerIdFromRequest.contains(answerId))
                    .map(UUID::fromString)
                    .collect(Collectors.toList());
            log.info("Deleting answer of question with id: {} of question id: {}", deleteIdList, questionRequest.getId());

            answerOfQuestionCreateHelper.deleteAllById(deleteIdList);
            log.info("Answer of question is deleted for question id: {}", deleteIdList);

            // Save answer list
            answerOfQuestionCreateHelper.saveAnswerOfQuestion(questionRequest.getAnswers());
            log.info("Answer of question is updated for question id: {}", questionRequest.getId());
        }

        return result;
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

    public Question saveQuestion(Question question) {
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
