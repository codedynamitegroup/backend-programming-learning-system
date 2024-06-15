package com.backend.programming.learning.system.course.service.domain.implement.service.listener;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionRequest;
import com.backend.programming.learning.system.course.service.domain.entity.Question;
import com.backend.programming.learning.system.course.service.domain.event.question.event.*;
import com.backend.programming.learning.system.course.service.domain.implement.service.question.QuestionCreateUpdateHelper;
import com.backend.programming.learning.system.course.service.domain.implement.service.question.QuestionDeleteHelper;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.outbox.scheduler.question.QuestionOutboxHelper;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.question.QuestionMessageListener;
import com.backend.programming.learning.system.outbox.OutboxStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Slf4j
@Validated
@Service
public class QuestionMessageListenerImpl implements QuestionMessageListener {
    private final QuestionDataMapper questionDataMapper;
    private final CourseDomainService courseDomainService;
    private final QuestionOutboxHelper questionOutboxHelper;
    private final QuestionCreateUpdateHelper questionCreateUpdateHelper;
    private final QuestionDeleteHelper questionDeleteHelper;

    public QuestionMessageListenerImpl(QuestionDataMapper questionDataMapper,
                                       CourseDomainService courseDomainService,
                                       QuestionOutboxHelper questionOutboxHelper,
                                       QuestionCreateUpdateHelper questionCreateUpdateHelper,
                                       QuestionDeleteHelper questionDeleteHelper) {
        this.questionDataMapper = questionDataMapper;
        this.courseDomainService = courseDomainService;
        this.questionOutboxHelper = questionOutboxHelper;
        this.questionCreateUpdateHelper = questionCreateUpdateHelper;
        this.questionDeleteHelper = questionDeleteHelper;
    }

    @Override
    public void createQuestion(QuestionRequest questionCreateRequest) {
        try {
            Question question =  questionCreateUpdateHelper.createQuestion(questionCreateRequest);
            QuestionCreatedEvent questionCreatedEvent = courseDomainService.createQuestionEvent(question, questionCreateRequest.getSagaId());

            questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionEventToQuestionEventPayload(questionCreatedEvent),
                    questionCreatedEvent.getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(questionCreateRequest.getSagaId()));
        }
        catch (Exception e) {
            log.error("Error while sending create message to topic: {} with message: {}", questionCreateRequest, e.getMessage());

            QuestionCreateFailedEvent questionCreateFailedEvent = courseDomainService
                    .createQuestionFailedEvent(questionDataMapper.questionCreateRequestToQuestion(questionCreateRequest),
                            questionCreateRequest.getSagaId());

            questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionEventToQuestionEventPayload(questionCreateFailedEvent),
                    questionCreateFailedEvent.getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(questionCreateRequest.getSagaId()));
        }
    }

    @Override
    public void updateQuestion(QuestionRequest questionUpdateRequest) {
        try {
            Question question = questionCreateUpdateHelper.saveQuestion(questionUpdateRequest);

            QuestionUpdatedEvent questionUpdatedEvent = courseDomainService.updateQuestionEvent(question, questionUpdateRequest.getSagaId());

            questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionEventToQuestionEventPayload(questionUpdatedEvent),
                    questionUpdatedEvent.getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(questionUpdateRequest.getSagaId()));
        }
        catch (Exception e) {
            log.error("Error while sending update message to topic: {} with message: {}", questionUpdateRequest, e.getMessage());

            QuestionUpdateFailedEvent questionUpdateFailedEvent = courseDomainService
                    .updateQuestionFailedEvent(questionDataMapper.questionUpdateRequestToQuestion(questionUpdateRequest),
                            questionUpdateRequest.getSagaId());

            questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionEventToQuestionEventPayload(questionUpdateFailedEvent),
                    questionUpdateFailedEvent.getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(questionUpdateRequest.getSagaId()));
        }
    }

    @Override
    public void deleteQuestion(QuestionRequest questionDeleteRequest) {
        try {
            Question question = questionDataMapper.questionDeleteRequestToQuestion(questionDeleteRequest);
            questionDeleteHelper.deleteById(UUID.fromString(questionDeleteRequest.getId()));

            QuestionDeletedEvent questionDeletedEvent = courseDomainService.deleteQuestionEvent(question, questionDeleteRequest.getSagaId());

            questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionEventToQuestionEventPayload(questionDeletedEvent),
                    questionDeletedEvent.getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(questionDeleteRequest.getSagaId()));
        }
        catch (Exception e) {
            log.error("Error while sending delete message to topic: {} with message: {}", questionDeleteRequest, e.getMessage());

            QuestionDeleteFailedEvent questionDeleteFailedEvent = courseDomainService
                    .deleteQuestionFailedEvent(questionDataMapper.questionDeleteRequestToQuestion(questionDeleteRequest),
                            questionDeleteRequest.getSagaId());

            questionOutboxHelper.saveNewQuestionOutboxMessage(questionDataMapper.questionEventToQuestionEventPayload(questionDeleteFailedEvent),
                    questionDeleteFailedEvent.getCopyState(),
                    OutboxStatus.STARTED,
                    UUID.fromString(questionDeleteRequest.getSagaId()));
        }

    }
}