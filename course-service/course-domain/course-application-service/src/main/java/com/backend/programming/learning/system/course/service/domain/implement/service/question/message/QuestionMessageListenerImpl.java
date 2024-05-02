package com.backend.programming.learning.system.course.service.domain.implement.service.question.message;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionRequest;
import com.backend.programming.learning.system.course.service.domain.event.question.event.*;
import com.backend.programming.learning.system.course.service.domain.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.question.QuestionMessageListener;
import com.backend.programming.learning.system.course.service.domain.ports.output.message.publisher.question.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class QuestionMessageListenerImpl implements QuestionMessageListener {
    private final QuestionCreatedResponseMessagePublisher questionCreatedResponseMessagePublisher;
    private final QuestionCreateFailedResponseMessagePublisher questionCreateFailedResponseMessagePublisher;
    private final QuestionDeletedResponseMessagePublisher questionDeletedResponseMessagePublisher;
    private final QuestionDeleteFailedResponseMessagePublisher questionDeleteFailedResponseMessagePublisher;
    private final QuestionUpdatedResponseMessagePublisher questionUpdatedResponseMessagePublisher;
    private final QuestionUpdateFailedResponseMessagePublisher questionUpdateFailedResponseMessagePublisher;
    private final QuestionDataMapper questionDataMapper;
    private final CourseDomainService courseDomainService;

    public QuestionMessageListenerImpl(QuestionCreatedResponseMessagePublisher questionCreatedResponseMessagePublisher,
                                       QuestionCreateFailedResponseMessagePublisher questionCreateFailedResponseMessagePublisher,
                                       QuestionDeletedResponseMessagePublisher questionDeletedResponseMessagePublisher,
                                       QuestionDeleteFailedResponseMessagePublisher questionDeleteFailedResponseMessagePublisher,
                                       QuestionUpdatedResponseMessagePublisher questionUpdatedResponseMessagePublisher,
                                       QuestionUpdateFailedResponseMessagePublisher questionUpdateFailedResponseMessagePublisher,
                                       QuestionDataMapper questionDataMapper, CourseDomainService courseDomainService) {
        this.questionCreatedResponseMessagePublisher = questionCreatedResponseMessagePublisher;
        this.questionCreateFailedResponseMessagePublisher = questionCreateFailedResponseMessagePublisher;
        this.questionDeletedResponseMessagePublisher = questionDeletedResponseMessagePublisher;
        this.questionDeleteFailedResponseMessagePublisher = questionDeleteFailedResponseMessagePublisher;
        this.questionUpdatedResponseMessagePublisher = questionUpdatedResponseMessagePublisher;
        this.questionUpdateFailedResponseMessagePublisher = questionUpdateFailedResponseMessagePublisher;
        this.questionDataMapper = questionDataMapper;
        this.courseDomainService = courseDomainService;
    }

    @Override
    public void createQuestion(QuestionRequest questionCreateRequest) {
        try {
            QuestionCreatedEvent questionCreatedEvent = courseDomainService
                    .createQuestionEvent(questionDataMapper.questionCreateRequestToQuestion(questionCreateRequest),
                            questionCreateRequest.getSagaId());
            questionCreatedResponseMessagePublisher.publish(questionCreatedEvent);
        }
        catch (Exception e) {
            log.error("Error while sending message to topic: {} with message: {}", questionCreateRequest, e.getMessage());

            QuestionCreateFailedEvent questionCreateFailedEvent = courseDomainService
                    .createQuestionFailedEvent(questionDataMapper.questionCreateRequestToQuestion(questionCreateRequest),
                            questionCreateRequest.getSagaId());
            questionCreateFailedResponseMessagePublisher.publish(questionCreateFailedEvent);
        }

    }

    @Override
    public void updateQuestion(QuestionRequest questionUpdateRequest) {
        try {
            QuestionUpdatedEvent questionUpdatedEvent = courseDomainService
                    .updateQuestionEvent(questionDataMapper.questionUpdateRequestToQuestion(questionUpdateRequest),
                            questionUpdateRequest.getSagaId());
            questionUpdatedResponseMessagePublisher.publish(questionUpdatedEvent);
        }
        catch (Exception e) {
            log.error("Error while sending message to topic: {} with message: {}", questionUpdateRequest, e.getMessage());

            QuestionUpdateFailedEvent questionUpdateFailedEvent = courseDomainService
                    .updateQuestionFailedEvent(questionDataMapper.questionUpdateRequestToQuestion(questionUpdateRequest),
                            questionUpdateRequest.getSagaId());
            questionUpdateFailedResponseMessagePublisher.publish(questionUpdateFailedEvent);
        }
    }

    @Override
    public void deleteQuestion(QuestionRequest questionDeleteRequest) {
        try {
            QuestionDeletedEvent questionDeletedEvent = courseDomainService
                    .deleteQuestionEvent(questionDataMapper.questionDeleteRequestToQuestion(questionDeleteRequest),
                            questionDeleteRequest.getSagaId());
            questionDeletedResponseMessagePublisher.publish(questionDeletedEvent);
        }
        catch (Exception e) {
            log.error("Error while sending message to topic: {} with message: {}", questionDeleteRequest, e.getMessage());

            QuestionDeleteFailedEvent questionDeleteFailedEvent = courseDomainService
                    .deleteQuestionFailedEvent(questionDataMapper.questionDeleteRequestToQuestion(questionDeleteRequest),
                            questionDeleteRequest.getSagaId());
            questionDeleteFailedResponseMessagePublisher.publish(questionDeleteFailedEvent);
        }

    }
}