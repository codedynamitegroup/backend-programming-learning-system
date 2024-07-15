package com.backend.programming.learning.system.course.service.domain.ports.input.message.listener.code_question;


import com.backend.programming.learning.system.course.service.domain.dto.messaging.CodeQuestionsUpdateRequest;

public interface CodeQuestionUpdateRequestMessageListener {
    public void persistCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest);
    public void updateCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest);
    public void deleteCodeQuestion(CodeQuestionsUpdateRequest codeQuestionsUpdateRequest);
}
