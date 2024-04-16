package com.backend.programming.learning.system.core.service.domain.implement.question;

import com.backend.programming.learning.system.core.service.domain.dto.query.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.implement.question.handler.QuestionCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.QuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
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
    public QuestionResponseEntity queryQuestionById(UUID questionId) {
        return questionQueryCommandHandler.queryQuestionById(questionId);
    }

    @Override
    public List<QuestionResponseEntity> queryAllQuestion() {
        return questionQueryCommandHandler.queryAllQuestion();
    }
}
