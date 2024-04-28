package com.backend.programming.learning.system.core.service.domain.implement.service.question.method.update;

import com.backend.programming.learning.system.core.service.domain.mapper.question.QuestionDataMapper;
import org.springframework.stereotype.Component;

@Component
public class QuestionUpdateHelper {
    private final QuestionDataMapper questionDataAccessMapper;
    private final QtypeCodeQuestionUpdateHelper qtypeCodeQuestionUpdateHelper;

    public QuestionUpdateHelper(QuestionDataMapper questionDataAccessMapper,
                                QtypeCodeQuestionUpdateHelper qtypeCodeQuestionUpdateHelper) {
        this.questionDataAccessMapper = questionDataAccessMapper;
        this.qtypeCodeQuestionUpdateHelper = qtypeCodeQuestionUpdateHelper;
    }
}
