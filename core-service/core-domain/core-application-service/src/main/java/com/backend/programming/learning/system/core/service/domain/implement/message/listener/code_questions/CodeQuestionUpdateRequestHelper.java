package com.backend.programming.learning.system.core.service.domain.implement.message.listener.code_questions;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeQuestionsUpdateRequest;
import com.backend.programming.learning.system.core.service.domain.entity.Organization;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.entity.User;
import com.backend.programming.learning.system.core.service.domain.exception.CoreDomainException;
import com.backend.programming.learning.system.core.service.domain.exception.UserNotFoundException;
import com.backend.programming.learning.system.core.service.domain.mapper.question.QtypeCodeQuestionDataMapper;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdateOutboxMessage;
import com.backend.programming.learning.system.core.service.domain.outbox.model.code_questions.CodeQuestionsUpdatePayload;
import com.backend.programming.learning.system.core.service.domain.outbox.scheduler.code_questions.CodeQuestionsUpdateOutboxHelper;
import com.backend.programming.learning.system.core.service.domain.ports.output.message.publisher.code_questions.CodeQuestionsUpdateResponseMessagePublisher;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.OrganizationRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Component
public class CodeQuestionUpdateRequestHelper {
    private final CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper;
    private final QtypeCodeQuestionRepository codeQuestionRepository;
    private final QtypeCodeQuestionDataMapper codeQuestionDataMapper;
    private final OrganizationRepository organizationRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;
    private final CodeQuestionsUpdateResponseMessagePublisher codeQuestionsUpdateResponseMessagePublisher;


    public CodeQuestionUpdateRequestHelper(CodeQuestionsUpdateOutboxHelper codeQuestionsUpdateOutboxHelper, QtypeCodeQuestionRepository codeQuestionRepository, QtypeCodeQuestionDataMapper codeQuestionDataMapper, OrganizationRepository organizationRepository, UserRepository userRepository, QuestionRepository questionRepository, CodeQuestionsUpdateResponseMessagePublisher codeQuestionsUpdateResponseMessagePublisher) {
        this.codeQuestionsUpdateOutboxHelper = codeQuestionsUpdateOutboxHelper;
        this.codeQuestionRepository = codeQuestionRepository;
        this.codeQuestionDataMapper = codeQuestionDataMapper;
        this.organizationRepository = organizationRepository;
        this.userRepository = userRepository;
        this.questionRepository = questionRepository;
        this.codeQuestionsUpdateResponseMessagePublisher = codeQuestionsUpdateResponseMessagePublisher;
    }

    private boolean publishIfOutboxMessageUpdatingForCodeQuestion(CodeQuestionsUpdateRequest request,
                                                                  CopyState copyState) {
        Optional<CodeQuestionsUpdateOutboxMessage> outboxMessage =
                codeQuestionsUpdateOutboxHelper.getCompletedCodeQuestionsUpdateOutboxMessageBySagaIdAndCopyState(
                        request.getSagaId(),
                        copyState);
        if (outboxMessage.isPresent()) {
            codeQuestionsUpdateResponseMessagePublisher.publish(outboxMessage.get(), codeQuestionsUpdateOutboxHelper::updateOutboxMessage);
            return true;
        }
        return false;
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

        if (publishIfOutboxMessageUpdatingForCodeQuestion(codeQuestionsUpdateRequest, CopyState.CREATED)) {
            log.info("An outbox message with saga id: {} is already saved to database!",
                    codeQuestionsUpdateRequest.getSagaId());
            return;
        }
        CodeQuestionsUpdatePayload payload = codeQuestionDataMapper.codeQuestionsUpdateRequestToCodeQuestionsUpdatePayload(codeQuestionsUpdateRequest);

//        boolean saveSucceed = false;
//        try {
//            QtypeCodeQuestion codeQuestion = codeQuestionDataMapper.codeQuestionsUpdateRequestToQtypeCodeQuestion(codeQuestionsUpdateRequest);
//            codeQuestionRepository.saveQtypeCodeQuestion(codeQuestion);
//            saveSucceed = true;
//
//        } catch (Exception e) {
//            log.error("an error occur in CodeQuestionUpdateRequestHelper {}", e.getMessage());
//            payload.setFailureMessages(Collections.singletonList(e.getMessage()));
//        }
//        CopyState copyState = CopyState.CREATED;
//        if(!saveSucceed)
//            copyState = CopyState.CREATE_FAILED;
//        payload.setState(copyState.name());
        User createdBy =  getUser(codeQuestionsUpdateRequest.getEmail());
        User updatedBy = getUser(codeQuestionsUpdateRequest.getEmail());
        Optional<Organization> organization = codeQuestionsUpdateRequest.getOrgId() == null?Optional.empty() :organizationRepository.findOrganization(codeQuestionsUpdateRequest.getOrgId());
        Question question = codeQuestionDataMapper.codeQuestionsUpdateRequestToQuestion(codeQuestionsUpdateRequest, organization.orElse(null), createdBy, updatedBy, CopyState.CREATED);
        QtypeCodeQuestion codeQuestion = codeQuestionDataMapper.codeQuestionsUpdateRequestToQtypeCodeQuestion(codeQuestionsUpdateRequest);

        questionRepository.saveQuestion(question);
        codeQuestionRepository.saveQtypeCodeQuestion(codeQuestion);
        payload.setState(CopyState.CREATED.name());

        codeQuestionsUpdateOutboxHelper.saveCodeQuestionsUpdateOutboxMessage(
                payload,
                CopyState.CREATED,
                OutboxStatus.STARTED,
                codeQuestionsUpdateRequest.getSagaId()
        );
        log.info("Received CodeQuestionsUpdateRequest for code question id: {}", codeQuestionsUpdateRequest.getCodeQuestionId());

    }
    @Transactional
    public void updateCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest){
        if (publishIfOutboxMessageUpdatingForCodeQuestion(codeQuestionsUpdateRequest, CopyState.UPDATED)) {
            log.info("An outbox message with saga id: {} is already saved to database!",
                    codeQuestionsUpdateRequest.getSagaId());
            return;
        }
        //this gonna change if we actually have updated cases
        CodeQuestionsUpdatePayload payload = codeQuestionDataMapper.codeQuestionsUpdateRequestToCodeQuestionsUpdatePayload(codeQuestionsUpdateRequest);

//        boolean saveSucceed = false;
//        try {
//            QtypeCodeQuestion codeQuestion = codeQuestionDataMapper.codeQuestionsUpdateRequestToQtypeCodeQuestion(codeQuestionsUpdateRequest);
//            codeQuestionRepository.saveQtypeCodeQuestion(codeQuestion);
//            saveSucceed = true;
//
//        } catch (Exception e) {
//            log.error("an error occur in CodeQuestionUpdateRequestHelper {}", e.getMessage());
//            payload.setFailureMessages(Collections.singletonList(e.getMessage()));
//        }
//        CopyState copyState = CopyState.UPDATED;
//        if(!saveSucceed)
//            copyState = CopyState.UPDATE_FAILED;
//        payload.setState(copyState.name());

        Optional<Question> oldQuestion = questionRepository.findQuestion(codeQuestionsUpdateRequest.getQuestionId());
        User updatedBy = getUser(codeQuestionsUpdateRequest.getEmail());
        User createdBy =  oldQuestion.isPresent()? oldQuestion.get().getCreatedBy() : updatedBy;

        Optional<Organization> organization = codeQuestionsUpdateRequest.getOrgId() == null?Optional.empty() :organizationRepository.findOrganization(codeQuestionsUpdateRequest.getOrgId());
        Question question = codeQuestionDataMapper.codeQuestionsUpdateRequestToQuestion(codeQuestionsUpdateRequest, organization.orElse(null), createdBy, updatedBy, CopyState.UPDATED);
        QtypeCodeQuestion codeQuestion = codeQuestionDataMapper.codeQuestionsUpdateRequestToQtypeCodeQuestion(codeQuestionsUpdateRequest);

        questionRepository.saveQuestion(question);
        codeQuestionRepository.saveQtypeCodeQuestion(codeQuestion);
        payload.setState(CopyState.UPDATED.name());


        codeQuestionsUpdateOutboxHelper.saveCodeQuestionsUpdateOutboxMessage(
                payload,
                CopyState.UPDATED,
                OutboxStatus.STARTED,
                codeQuestionsUpdateRequest.getSagaId()
        );
        log.info("Received CodeQuestionsUpdateRequest for code question id: {}", codeQuestionsUpdateRequest.getCodeQuestionId());

    }
    @Transactional
    public void deleteCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest){
        if (publishIfOutboxMessageUpdatingForCodeQuestion(codeQuestionsUpdateRequest, CopyState.DELETED)) {
            log.info("An outbox message with saga id: {} is already saved to database!",
                    codeQuestionsUpdateRequest.getSagaId());
            return;
        }

        CodeQuestionsUpdatePayload payload = codeQuestionDataMapper.codeQuestionsUpdateRequestToCodeQuestionsUpdatePayload(codeQuestionsUpdateRequest);

//        boolean saveSucceed = false;
//        try {
//            codeQuestionRepository.deleteById(UUID.fromString(payload.getCodeQuestionId()));
//            saveSucceed = true;
//
//        } catch (Exception e) {
//            log.error("an error occur in CodeQuestionUpdateRequestHelper {}", e.getMessage());
//            payload.setFailureMessages(Collections.singletonList(e.getMessage()));
//        }
//        CopyState copyState = CopyState.DELETED;
//        if(!saveSucceed)
//            copyState = CopyState.DELETE_FAILED;
//        payload.setState(copyState.name());

        questionRepository.deleteQuestion(codeQuestionsUpdateRequest.getQuestionId());
        payload.setState(CopyState.DELETED.name());

        codeQuestionsUpdateOutboxHelper.saveCodeQuestionsUpdateOutboxMessage(
                payload,
                CopyState.DELETED,
                OutboxStatus.STARTED,
                codeQuestionsUpdateRequest.getSagaId()
        );
        log.info("Received CodeQuestionsUpdateRequest for code question id: {}", codeQuestionsUpdateRequest.getCodeQuestionId());

    }
}
