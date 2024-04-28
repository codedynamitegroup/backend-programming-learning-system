package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.create;

import com.backend.programming.learning.system.core.service.domain.CoreDomainService;
import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.*;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class QuestionCreateHelper {
    private final CoreDomainService coreDomainService;
    private final QuestionRepository questionRepository;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final QuestionDataMapper questionDataMapper;
    private final AnswerOfQuestionRepository answerOfQuestionRepository;


    public QuestionCreateHelper(CoreDomainService coreDomainService,
                                QuestionRepository questionRepository,
                                OrganizationRepository organizationRepository,
                                UserRepository userRepository,
                                QuestionDataMapper questionDataMapper,
                                AnswerOfQuestionRepository answerOfQuestionRepository) {
        this.coreDomainService = coreDomainService;
        this.questionRepository = questionRepository;
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.questionDataMapper = questionDataMapper;
        this.answerOfQuestionRepository = answerOfQuestionRepository;
    }

    // Create and save question
    @Transactional
    public Question persistQuestion(CreateQuestionCommand createQuestionCommand) {
        User createdBy =  getUser(createQuestionCommand.getCreatedBy());
        User updatedBy = getUser(createQuestionCommand.getUpdatedBy());
        Organization organization = getOrganization(createQuestionCommand.getOrganizationId());

        Question question = questionDataMapper.createQuestionCommandToQuestion(createQuestionCommand, organization, createdBy, updatedBy);
        coreDomainService.createQuestion(question);
        saveQuestion(question);

        // save answer
        List<AnswerOfQuestion> answerEntityList = questionDataMapper.answerOfQuestionListToAnswerOfQuestionEntityList(createQuestionCommand.getAnswers(), question.getId());

        for (AnswerOfQuestion answerOfQuestion : answerEntityList) {
            coreDomainService.createAnswerOfQuestion(answerOfQuestion);
            saveAnswer(answerOfQuestion);
        }

        log.info("Answers for question with id {} saved", question.getId().getValue());
        log.info("Question created with id: {}", question.getId().getValue());

        return questionDataMapper.setQuestionWithAnswers(question, answerEntityList);
    }

    // Check if user exists
    private User getUser(UUID userId) {
        Optional<User> user = userRepository.findUser(userId);
        if (user.isEmpty()) {
            log.warn("User with id: {} not found", userId);
            throw new UserNotFoundException("Could not find user with id: " + userId);
        }
        return user.get();
    }

    // Check if organization exists
    private Organization getOrganization(UUID organizationId) {
        Optional<Organization> organization = organizationRepository.findOrganization(organizationId);
        if (organization.isEmpty()) {
            log.warn("Organization with id: {} not found", organizationId);
            throw new CoreDomainException("Could not find organization with id: " + organizationId);
        }
        return organization.get();
    }

    // Save question to database
    private void saveQuestion(Question question) {
        Question savedQuestion = questionRepository.saveQuestion(question);

        if (savedQuestion == null) {
            log.error("Could not save question");

            throw new CoreDomainException("Could not save question");
        }
        log.info("Question saved with id: {}", savedQuestion.getId().getValue());
    }

    private void saveAnswer(AnswerOfQuestion answerOfQuestion) {
        AnswerOfQuestion savedAnswer = answerOfQuestionRepository.saveAnswerOfQuestion(answerOfQuestion);

        if (savedAnswer == null) {
            log.error("Could not save answer");

            throw new CoreDomainException("Could not save answer");
        }
        log.info("Answer saved with id {} and questionId {}", savedAnswer.getId().getValue(), savedAnswer.getId().getValue());
    }
}




















