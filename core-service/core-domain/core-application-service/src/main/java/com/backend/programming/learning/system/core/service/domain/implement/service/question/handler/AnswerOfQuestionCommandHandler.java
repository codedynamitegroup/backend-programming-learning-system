package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.delete.AnswerOfQuestionDeleteHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class AnswerOfQuestionCommandHandler {
    private final AnswerOfQuestionDeleteHelper answerOfQuestionDeleteHelper;

    public AnswerOfQuestionCommandHandler(AnswerOfQuestionDeleteHelper answerOfQuestionDeleteHelper) {
        this.answerOfQuestionDeleteHelper = answerOfQuestionDeleteHelper;
    }

    public AnswerOfQuestionDeleteResponse deleteAnswerOfQuestionByQuestionId(UUID answerId) {
        return answerOfQuestionDeleteHelper.deleteAnswerOfQuestionById(answerId);
    }
}
