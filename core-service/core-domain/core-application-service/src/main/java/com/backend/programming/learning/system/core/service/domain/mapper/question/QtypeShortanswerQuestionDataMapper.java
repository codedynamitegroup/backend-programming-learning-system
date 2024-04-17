package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QtypeShortanswerQuestionDataMapper {
        public QtypeShortAnswerQuestion createQuestionCommandToQtypeShortAnswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand,
                                                                                        Question question) {
            return QtypeShortAnswerQuestion.builder()
                    .question(question)
                    .caseSensitive(createQtypeShortanswerQuestionCommand.getCaseSensitive())
                    .build();
        }

        public QueryQtypeShortanswerQuestionResponse qtypeShortanswerQuestionToQueryQtypeShortanswerQuestionResponse(QtypeShortAnswerQuestion qtypeShortanswerQuestion) {
            return QueryQtypeShortanswerQuestionResponse.builder()
                    .qtypeShortAnswerQuestion(qtypeShortanswerQuestion)
                    .build();
        }

    public List<QueryQtypeShortanswerQuestionResponse> qtypeShortanswerQuestionsListToQueryQtypeShortanswerQuestionResponseList(List<QtypeShortAnswerQuestion> qtypeShortanswerQuestions) {
        return List.of(qtypeShortanswerQuestions.stream()
                .map(this::qtypeShortanswerQuestionToQueryQtypeShortanswerQuestionResponse)
                .toArray(QueryQtypeShortanswerQuestionResponse[]::new));
    }
}
