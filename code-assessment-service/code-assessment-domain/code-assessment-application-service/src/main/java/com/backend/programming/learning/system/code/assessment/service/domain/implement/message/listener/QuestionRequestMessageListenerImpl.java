package com.backend.programming.learning.system.code.assessment.service.domain.implement.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.QuestionRequest;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Question;
import com.backend.programming.learning.system.code.assessment.service.domain.exeption.code_question.CodeQuestionNotFoundException;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.QuestionDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.model.question.QuestionEventPayload;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.outbox.scheduler.question.QuestionOutboxScheduler;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener.QuestionRequestMessageListener;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.code_question.CodeQuestionRepository;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import com.backend.programming.learning.system.outbox.OutboxStatus;
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

    public QuestionRequestMessageListenerImpl(CodeAssessmentDomainService codeAssessmentDomainService,
                                              QuestionOutboxHelper questionOutboxHelper,
                                              QuestionDataMapper questionDataMapper,
                                              CodeQuestionRepository codeQuestionRepository) {
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionDataMapper = questionDataMapper;
        this.codeQuestionRepository = codeQuestionRepository;
    }


    @Override
    public void deleteQuestion(QuestionRequest questionRequest) {
        try {
            log.info("Question deleted with id: {}", questionRequest.getId());
            CodeQuestion codeQuestion = findCodeQuestion(UUID.fromString(questionRequest.getId()));
            codeQuestionRepository.deleteCodeQuestionById(codeQuestion.getId().getValue());

            QuestionEventPayload questionEventPayload = questionDataMapper.questionRequestToQuestionEventPayload(questionRequest, CopyState.DELETED);

            questionOutboxHelper.saveNewQuestionOutboxMessage(questionEventPayload,
                    CopyState.DELETED,
                    OutboxStatus.STARTED,
                    UUID.fromString(questionRequest.getSagaId()));
        }
        catch (Exception e) {
            log.error("Error while sending delete message to topic: {} with message: {}", questionRequest, e.getMessage());
            QuestionEventPayload questionEventPayload = questionDataMapper.questionRequestToQuestionEventPayload(questionRequest, CopyState.DELETE_FAILED);

            questionOutboxHelper.saveNewQuestionOutboxMessage(questionEventPayload,
                    CopyState.DELETE_FAILED,
                    OutboxStatus.STARTED,
                    UUID.fromString(questionRequest.getSagaId()));
        }
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
