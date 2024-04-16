package com.backend.programming.learning.system.core.service.domain.implement.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.query.QuestionQueryHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QuestionCommandHandler {
    private final QuestionQueryHelper questionQueryHelper;

    public QuestionCommandHandler(QuestionQueryHelper questionQueryHelper) {
        this.questionQueryHelper = questionQueryHelper;
    }

    public QueryQuestionResponse queryQuestionById(UUID questionId) {
        return questionQueryHelper
                .queryQuestionById(questionId);
    }

    public List<QueryQuestionResponse> queryAllQuestion() {
        return questionQueryHelper
                .queryAllQuestion();
    }
}
