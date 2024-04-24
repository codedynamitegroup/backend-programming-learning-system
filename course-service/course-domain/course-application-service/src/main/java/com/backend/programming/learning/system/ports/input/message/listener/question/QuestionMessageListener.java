package com.backend.programming.learning.system.ports.input.message.listener.question;

import com.backend.programming.learning.system.dto.method.message.QuestionDeleteRequest;

public interface QuestionMessageListener {
    void createQuestion();
    void updateQuestion();
    void deleteQuestion(QuestionDeleteRequest questionDeleteRequest);
}
