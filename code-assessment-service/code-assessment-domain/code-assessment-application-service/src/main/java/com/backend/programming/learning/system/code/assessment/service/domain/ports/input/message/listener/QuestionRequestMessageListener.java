package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.QuestionRequest;

public interface QuestionRequestMessageListener {
    void deleteQuestion(QuestionRequest questionRequest);
}
