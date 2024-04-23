package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;
import com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.question.course.QuestionResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class QuestionResponseMessageListenerImpl implements QuestionResponseMessageListener {
    @Override
    public void questionCreated(QuestionResponse questionResponse) {

    }

    @Override
    public void questionCreateFailed(QuestionResponse questionResponse) {

    }

    @Override
    public void questionDeleted(QuestionResponse questionResponse) {

    }

    @Override
    public void questionDeleteFailed(QuestionResponse questionResponse) {

    }

    @Override
    public void questionUpdated(QuestionResponse questionResponse) {

    }

    @Override
    public void questionUpdateFailed(QuestionResponse questionResponse) {

    }
}
