package com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.question;

import com.backend.programming.learning.system.course.service.domain.dto.method.message.QuestionRequest;

public interface QuestionMessageListener {
    void createQuestion(QuestionRequest questionCreateRequest);
    void updateQuestion(QuestionRequest questionUpdateRequest);
    void deleteQuestion(QuestionRequest questionDeleteRequest);
}
