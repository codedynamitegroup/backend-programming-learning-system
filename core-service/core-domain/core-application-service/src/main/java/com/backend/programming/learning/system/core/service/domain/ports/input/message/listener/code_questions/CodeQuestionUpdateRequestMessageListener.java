package com.backend.programming.learning.system.core.service.domain.ports.input.message.listener.code_questions;

import com.backend.programming.learning.system.core.service.domain.dto.message.CodeQuestionsUpdateRequest;

public interface CodeQuestionUpdateRequestMessageListener {
    public void persistCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest);
    public void updateCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest);
    public void deleteCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest);
}
