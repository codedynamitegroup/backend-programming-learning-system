package com.backend.programming.learning.system.code.assessment.service.domain.implement.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.QuestionRequest;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.User;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.QuestionRequestMessageListener;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Validated
@Service
public class QuestionRequestMessageListenerImpl implements QuestionRequestMessageListener {
    private final CodeAssessmentDomainService codeAssessmentDomainService;
    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionDataMapper questionDataMapper;
    private final CodeQuestionRepository codeQuestionRepository;
    private final ValidateHelper validateHelper;

    public QuestionRequestMessageListenerImpl(CodeAssessmentDomainService codeAssessmentDomainService, QuestionOutboxHelper questionOutboxHelper, QuestionDataMapper questionDataMapper, CodeQuestionRepository codeQuestionRepository, ValidateHelper validateHelper) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionDataMapper = questionDataMapper;
        this.codeQuestionRepository = codeQuestionRepository;
        this.validateHelper = validateHelper;
    }

    @Override
    public void deleteQuestion(QuestionRequest questionRequest) {
//        try {
            log.info("Question deleted with id: {}", questionRequest.getId());

            codeQuestionRepository.deleteCodeQuestionByQuestionId(UUID.fromString(questionRequest.getId()));

//            QuestionEventPayload questionEventPayload = questionDataMapper.questionRequestToQuestionEventPayload(questionRequest, CopyState.DELETED);

//            questionOutboxHelper.saveNewQuestionOutboxMessage(questionEventPayload,
//                    CopyState.DELETED,
//                    OutboxStatus.STARTED,
//                    UUID.fromString(questionRequest.getSagaId()));
//        }
//        catch (Exception e) {
//            log.error("Error while sending delete message to topic: {} with message: {}", questionRequest, e.getMessage());
//            QuestionEventPayload questionEventPayload = questionDataMapper.questionRequestToQuestionEventPayload(questionRequest, CopyState.DELETE_FAILED);
//
//            questionOutboxHelper.saveNewQuestionOutboxMessage(questionEventPayload,
//                    CopyState.DELETE_FAILED,
//                    OutboxStatus.STARTED,
//                    UUID.fromString(questionRequest.getSagaId()));
//        }
    }

    @Override
    public void createQuestion(QuestionRequest request) {
        User user = validateHelper.validateUser(UUID.fromString(request.getCreatedBy()));
        CodeQuestion codeQuestion = questionDataMapper.questionRequestToCodeQuestion(request, user);
        codeQuestionRepository.save(codeQuestion);
        codeQuestionRepository.saveCategory(codeQuestion.getId(), request.getCategoryId());

    }

    @Override
    public void updateQuestion(QuestionRequest request) {

    }

    private CodeQuestion findCodeQuestion(UUID questionId) {
        Optional<CodeQuestion> codeQuestion = codeQuestionRepository.findByQuestionId(questionId);

        if (codeQuestion.isEmpty()) {
            log.warn("Code question not found with id: {}", questionId);
            throw new CodeQuestionNotFoundException("Code question not found with id: " + questionId);
        }

        return codeQuestion.get();
    }
}
