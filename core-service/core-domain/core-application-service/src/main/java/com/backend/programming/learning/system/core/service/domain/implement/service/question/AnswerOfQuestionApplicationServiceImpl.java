package com.backend.programming.learning.system.core.service.domain.implement.service.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.handler.AnswerOfQuestionCommandHandler;
import com.backend.programming.learning.system.core.service.domain.ports.input.service.question.AnswerOfQuestionApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Slf4j
@Validated
public class AnswerOfQuestionApplicationServiceImpl implements AnswerOfQuestionApplicationService {
    private final AnswerOfQuestionCommandHandler answerOfQuestionCommandHandler;

    public AnswerOfQuestionApplicationServiceImpl(AnswerOfQuestionCommandHandler answerOfQuestionCommandHandler) {
        this.answerOfQuestionCommandHandler = answerOfQuestionCommandHandler;
    }

    @Override
    public AnswerOfQuestionDeleteResponse deleteAnswerOfQuestionById(UUID answerId) {
        return answerOfQuestionCommandHandler.deleteAnswerOfQuestionByQuestionId(answerId);
    }
}
