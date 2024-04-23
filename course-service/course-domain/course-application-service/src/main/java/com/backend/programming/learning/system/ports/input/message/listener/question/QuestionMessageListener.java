package com.backend.programming.learning.system.ports.input.message.listener.question;

import com.backend.programming.learning.system.dto.method.message.QuestionCreateRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionDeleteRequest;
import com.backend.programming.learning.system.dto.method.message.QuestionUpdateRequest;

public interface QuestionMessageListener {
    void createQuestion(QuestionCreateRequest questionCreateRequest);
    void updateQuestion(QuestionUpdateRequest questionUpdateRequest);
    void deleteQuestion(QuestionDeleteRequest questionDeleteRequest);
}
