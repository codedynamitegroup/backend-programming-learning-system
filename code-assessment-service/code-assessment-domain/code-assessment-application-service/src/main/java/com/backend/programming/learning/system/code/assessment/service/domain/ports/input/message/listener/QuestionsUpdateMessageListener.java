package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.message.listener;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.message.QuestionsUpdate;

public interface QuestionsUpdateMessageListener {
    void createQuestion(QuestionsUpdate questionsUpdate);
    void updateQuestion(QuestionsUpdate questionsUpdate);
    void deleteQuestion(QuestionsUpdate questionsUpdate);
}
