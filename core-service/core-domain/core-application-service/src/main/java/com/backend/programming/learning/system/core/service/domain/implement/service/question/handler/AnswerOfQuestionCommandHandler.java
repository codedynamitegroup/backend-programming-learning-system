package com.backend.programming.learning.system.core.service.domain.implement.service.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.AnswerOfQuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryAnswerOfQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.delete.AnswerOfQuestionDeleteHelper;
import com.backend.programming.learning.system.core.service.domain.implement.service.question.method.delete.AnswerOfQuestionQueryHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class AnswerOfQuestionCommandHandler {
    private final AnswerOfQuestionDeleteHelper answerOfQuestionDeleteHelper;
    private final AnswerOfQuestionQueryHelper answerOfQuestionQueryHelper;


    public AnswerOfQuestionDeleteResponse deleteAnswerOfQuestionByQuestionId(UUID answerId) {
        return answerOfQuestionDeleteHelper.deleteAnswerOfQuestionById(answerId);
    }

    public List<QueryAnswerOfQuestionResponse> getAnswerOfQuestionByQuestionId(UUID questionId) {
        return answerOfQuestionQueryHelper.getAnswerOfQuestionByQuestionId(questionId);
    }
}
