package com.backend.programming.learning.system.core.service.domain.implement.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionCreateSaga;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionDeleteSaga;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.saga.QuestionUpdateSaga;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.question.course.QuestionResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class QuestionResponseMessageListenerImpl implements QuestionResponseMessageListener {
    private final QuestionCreateSaga questionCreateSaga;
    private final QuestionDeleteSaga questionDeleteSaga;
    private final QuestionUpdateSaga questionUpdateSaga;

    public QuestionResponseMessageListenerImpl(QuestionCreateSaga questionCreateSaga,
                                               QuestionDeleteSaga questionDeleteSaga,
                                               QuestionUpdateSaga questionUpdateSaga) {
        this.questionCreateSaga = questionCreateSaga;
        this.questionDeleteSaga = questionDeleteSaga;
        this.questionUpdateSaga = questionUpdateSaga;
    }

    @Override
    public void questionCreated(QuestionResponse questionResponse) {
        questionCreateSaga.process(questionResponse);
    }

    @Override
    public void questionCreateFailed(QuestionResponse questionResponse) {
        questionCreateSaga.rollback(questionResponse);
    }

    @Override
    public void questionDeleted(QuestionResponse questionResponse) {
        questionDeleteSaga.process(questionResponse);
    }

    @Override
    public void questionDeleteFailed(QuestionResponse questionResponse) {
        questionDeleteSaga.rollback(questionResponse);
    }

    @Override
    public void questionUpdated(QuestionResponse questionResponse) {
        questionUpdateSaga.process(questionResponse);
    }

    @Override
    public void questionUpdateFailed(QuestionResponse questionResponse) {
        questionUpdateSaga.rollback(questionResponse);
    }
}
