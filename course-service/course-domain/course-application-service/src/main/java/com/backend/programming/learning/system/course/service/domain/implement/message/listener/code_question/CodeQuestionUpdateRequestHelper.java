package com.backend.programming.learning.system.course.service.domain.implement.message.listener.code_question;

import com.backend.programming.learning.system.course.service.domain.dto.messaging.CodeQuestionsUpdateRequest;
import com.backend.programming.learning.system.course.service.domain.entity.Organization;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.code_question.QtypeCodeQuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionBankCategoryRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.exception.user.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class CodeQuestionUpdateRequestHelper {
    private final QtypeCodeQuestionDataMapper codeQuestionDataMapper;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final QuestionBankCategoryRepository questionBankCategoryRepository;


    public CodeQuestionUpdateRequestHelper(QtypeCodeQuestionDataMapper codeQuestionDataMapper, OrganizationRepository organizationRepository, UserRepository userRepository, QuestionRepository questionRepository, QuestionBankCategoryRepository questionBankCategoryRepository) {
        this.codeQuestionDataMapper = codeQuestionDataMapper;
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.questionBankCategoryRepository = questionBankCategoryRepository;
    }

    private User getUser(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        if (user.isEmpty()) {
            log.warn("User with email: {} not found", email);
            throw new UserNotFoundException("Could not find user with email: " + email);
        }
        return user.get();
    }
    @Transactional
    public void persistCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest){


        User createdBy =  getUser(codeQuestionsUpdateRequest.getEmail());
        User updatedBy = getUser(codeQuestionsUpdateRequest.getEmail());
        Optional<QuestionBankCategory> questionBankCategory = questionBankCategoryRepository.findQuestionBankCategoryById(codeQuestionsUpdateRequest.getCategoryBank());
        Optional<Organization> organization = codeQuestionsUpdateRequest.getOrgId() == null?Optional.empty() :organizationRepository.findOrganizationById(codeQuestionsUpdateRequest.getOrgId());
        Question question = codeQuestionDataMapper.codeQuestionsUpdateRequestToQuestion(codeQuestionsUpdateRequest, organization.orElse(null), createdBy, updatedBy, questionBankCategory.orElse(null));

        Question question1 = questionRepository.saveQuestion(question);
//        log.info("{}",question1);
        log.info("Received CodeQuestionsUpdateRequest for code question id: {}", codeQuestionsUpdateRequest.getCodeQuestionId());

    }
    @Transactional
    public void updateCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest){


        Optional<Question> oldQuestion = questionRepository.findById(codeQuestionsUpdateRequest.getQuestionId());
        User updatedBy = getUser(codeQuestionsUpdateRequest.getEmail());
        User createdBy =  oldQuestion.isPresent()? oldQuestion.get().getCreatedBy() : updatedBy;
        Optional<QuestionBankCategory> questionBankCategory = questionBankCategoryRepository.findQuestionBankCategoryById(codeQuestionsUpdateRequest.getCategoryBank());

        Optional<Organization> organization = codeQuestionsUpdateRequest.getOrgId() == null?Optional.empty() :organizationRepository.findOrganizationById(codeQuestionsUpdateRequest.getOrgId());
        Question question = codeQuestionDataMapper.codeQuestionsUpdateRequestToQuestion(codeQuestionsUpdateRequest, organization.orElse(null), createdBy, updatedBy, questionBankCategory.orElse(null));

        questionRepository.saveQuestion(question);

        log.info("Received CodeQuestionsUpdateRequest for code question id: {}", codeQuestionsUpdateRequest.getCodeQuestionId());

    }
    @Transactional
    public void deleteCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest){

        questionRepository.deleteById(codeQuestionsUpdateRequest.getQuestionId());

        log.info("Received CodeQuestionsUpdateRequest for code question id: {}", codeQuestionsUpdateRequest.getCodeQuestionId());

    }
}
