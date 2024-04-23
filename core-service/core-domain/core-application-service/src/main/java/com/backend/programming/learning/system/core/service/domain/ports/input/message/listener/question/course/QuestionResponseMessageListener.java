package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.question.course;

import com.backend.programming.learning.system.core.service.domain.dto.method.message.QuestionResponse;

public interface QuestionResponseMessageListener {
    void questionCreated(QuestionResponse questionResponse);
    void questionCreateFailed(QuestionResponse questionResponse);

    void questionDeleted(QuestionResponse questionResponse);
    void questionDeleteFailed(QuestionResponse questionResponse);

    void questionUpdated(QuestionResponse questionResponse);
    void questionUpdateFailed(QuestionResponse questionResponse);
}
