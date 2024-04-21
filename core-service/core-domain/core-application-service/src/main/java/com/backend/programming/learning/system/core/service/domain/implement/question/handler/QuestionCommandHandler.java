package com.backend.programming.learning.system.core.service.domain.implement.question.handler;

import com.backend.programming.learning.system.core.service.domain.dto.method.delete.question.QuestionDeleteResponse;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.event.question.event.QuestionDeletedEvent;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.delete.QuestionDeleteHelper;
import com.backend.programming.learning.system.core.service.domain.implement.question.method.query.QuestionQueryHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Slf4j
public class QuestionCommandHandler {
    private final QuestionQueryHelper questionQueryHelper;
    private final QuestionDeleteHelper questionDeleteHelper;

    public QuestionCommandHandler(QuestionQueryHelper questionQueryHelper, QuestionDeleteHelper questionDeleteHelper) {
        this.questionQueryHelper = questionQueryHelper;
        this.questionDeleteHelper = questionDeleteHelper;
    }

    public QuestionResponseEntity queryQuestionById(UUID questionId) {
        return questionQueryHelper
                .queryQuestionById(questionId);
    }

    public List<QuestionResponseEntity> queryAllQuestion() {
        return questionQueryHelper
                .queryAllQuestion();
    }

    public QuestionDeleteResponse deleteQuestionById(UUID questionId) {
        QuestionDeletedEvent questionDeletedEvent = questionDeleteHelper.deleteQuestionById(questionId);



        return QuestionDeleteResponse.builder()
                .questionId(questionId)
                .qtypeId(questionDeletedEvent.getQtypeID())
                .message("Question deleted successfully")
                .build();
    }
}
