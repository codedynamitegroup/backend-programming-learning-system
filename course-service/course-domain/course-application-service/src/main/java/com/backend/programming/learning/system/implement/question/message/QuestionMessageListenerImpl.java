package com.backend.programming.learning.system.implement.question.message;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.domain.valueobject.QuestionResponseStatus;
import com.backend.programming.learning.system.dto.method.message.QuestionCreateRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionDeleteRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionUpdateRequest;
import com.backend.programming.learning.system.event.question.event.QuestionCreatedEvent;
import com.backend.programming.learning.system.mapper.question.QuestionDataMapper;
import com.backend.programming.learning.system.ports.input.message.listener.question.QuestionMessageListener;
import com.backend.programming.learning.system.ports.output.message.publisher.question.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class QuestionMessageListenerImpl implements QuestionMessageListener {
    private final QuestionCreatedResponseMessagePublisher questionCreatedResponseMessagePublisher;
//    private final QuestionCreateFailedResponseMessagePublisher questionCreateFailedResponseMessagePublisher;
//    private final QuestionDeletedResponseMessagePublisher questionDeletedResponseMessagePublisher;
//    private final QuestionDeleteFailedResponseMessagePublisher questionDeleteFailedResponseMessagePublisher;
//    private final QuestionUpdatedResponseMessagePublisher questionUpdatedResponseMessagePublisher;
//    private final QuestionUpdateFailedResponseMessagePublisher questionUpdateFailedResponseMessagePublisher;
    private final QuestionDataMapper questionDataMapper;
    private final CourseDomainService courseDomainService;

    public QuestionMessageListenerImpl(QuestionCreatedResponseMessagePublisher questionCreatedResponseMessagePublisher,
//                                       QuestionCreateFailedResponseMessagePublisher questionCreateFailedResponseMessagePublisher,
//                                       QuestionDeletedResponseMessagePublisher questionDeletedResponseMessagePublisher,
//                                       QuestionDeleteFailedResponseMessagePublisher questionDeleteFailedResponseMessagePublisher,
//                                       QuestionUpdatedResponseMessagePublisher questionUpdatedResponseMessagePublisher,
//                                       QuestionUpdateFailedResponseMessagePublisher questionUpdateFailedResponseMessagePublisher,
                                       QuestionDataMapper questionDataMapper, CourseDomainService courseDomainService) {
        this.questionCreatedResponseMessagePublisher = questionCreatedResponseMessagePublisher;
//        this.questionCreateFailedResponseMessagePublisher = questionCreateFailedResponseMessagePublisher;
//        this.questionDeletedResponseMessagePublisher = questionDeletedResponseMessagePublisher;
//        this.questionDeleteFailedResponseMessagePublisher = questionDeleteFailedResponseMessagePublisher;
//        this.questionUpdatedResponseMessagePublisher = questionUpdatedResponseMessagePublisher;
//        this.questionUpdateFailedResponseMessagePublisher = questionUpdateFailedResponseMessagePublisher;
        this.questionDataMapper = questionDataMapper;
        this.courseDomainService = courseDomainService;
    }

    @Override
    public void createQuestion(QuestionCreateRequest questionCreateRequest) {
        QuestionCreatedEvent questionCreatedEvent = courseDomainService
                .createQuestionEvent(questionDataMapper.questionCreateRequestToQuestion(questionCreateRequest));
        questionCreatedResponseMessagePublisher.publish(questionCreatedEvent);
    }

    @Override
    public void updateQuestion(QuestionUpdateRequest questionUpdateRequest) {

    }

    @Override
    public void deleteQuestion(QuestionDeleteRequest questionDeleteRequest) {

    }
}
