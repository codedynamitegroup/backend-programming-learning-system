package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeCodeQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeCodeQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.valueobject.QtypeCodeQuestionId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QtypeCodeQuestionDataMapper {
    private final QuestionDataMapper questionDataMapper;

    public QtypeCodeQuestionDataMapper(QuestionDataMapper questionDataMapper) {
        this.questionDataMapper = questionDataMapper;
    }

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

    public QtypeCodeQuestion updateQtypeCodeQuestionCommandToQtypeCodeQuestion(UpdateQtypeCodeQuestionCommand updateQtypeCodeQuestionCommand,
                                                                               QtypeCodeQuestion qtypeCodeQuestion) {

        return QtypeCodeQuestion.builder()
                .id(new QtypeCodeQuestionId(updateQtypeCodeQuestionCommand.getQtCodeQuestionId()))
                .dslTemplate(updateQtypeCodeQuestionCommand.getDslTemplate())
                .question(questionDataMapper.updateQuestionEntityToQuestion(updateQtypeCodeQuestionCommand.getQuestion(), qtypeCodeQuestion))
                .build();
    }
}
