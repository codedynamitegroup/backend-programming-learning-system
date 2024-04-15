package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.implement.question.handler.QuestionCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
public class QuestionApplicationServiceImpl implements QuestionApplicationService {
    private final QuestionCommandHandler questionQueryCommandHandler;

    public QuestionApplicationServiceImpl(QuestionCommandHandler questionQueryCommandHandler) {
        this.questionQueryCommandHandler = questionQueryCommandHandler;
    }

    @Override
    public QueryQuestionResponse queryQuestionById(UUID questionId) {
        return questionQueryCommandHandler.queryQuestionById(questionId);
    }
}
