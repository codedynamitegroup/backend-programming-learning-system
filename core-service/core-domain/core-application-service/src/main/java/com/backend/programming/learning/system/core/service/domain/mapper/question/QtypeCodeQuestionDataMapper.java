package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

@Component
public class QtypeCodeQuestionDataMapper {
    public QtypeCodeQuestion createQuestionCommandToQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand,
                                                                      QuestionId questionId) {
        return QtypeCodeQuestion.builder()
                .questionId(questionId)
                .dslTemplate(createQtypeCodeQuestionCommand.getDslTemplate())
                .build();
    }
}
