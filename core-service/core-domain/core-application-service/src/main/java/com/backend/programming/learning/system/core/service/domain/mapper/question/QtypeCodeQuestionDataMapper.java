package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QtypeCodeQuestionDataMapper {
    public QtypeCodeQuestion createQuestionCommandToQtypeCodeQuestion(CreateQtypeCodeQuestionCommand createQtypeCodeQuestionCommand,
                                                                      Question question) {
        return QtypeCodeQuestion.builder()
                .question(question)
                .dslTemplate(createQtypeCodeQuestionCommand.getDslTemplate())
                .build();
    }

    public QueryQtypeCodeQuestionResponse qtypeCodeQuestionToQueryQtypeCodeQuestionResponse(QtypeCodeQuestion qtypeCodeQuestion) {
        return QueryQtypeCodeQuestionResponse.builder()
                .qtypeCodeQuestion(qtypeCodeQuestion)
                .build();
    }

    public List<QueryQtypeCodeQuestionResponse> qtypeCodeQuestionsToQueryQtypeCodeQuestionResponses(List<QtypeCodeQuestion> qtypeCodeQuestions) {
        return List.of(qtypeCodeQuestions.stream()
                .map(this::qtypeCodeQuestionToQueryQtypeCodeQuestionResponse)
                .toArray(QueryQtypeCodeQuestionResponse[]::new));
    }
}
