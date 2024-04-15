package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeShortanswerQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import org.springframework.stereotype.Component;

@Component
public class QtypeShortanswerQuestionDataMapper {
        public QtypeShortAnswerQuestion createQuestionCommandToQtypeShortAnswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand,
                                                                                        Question question) {
            return QtypeShortAnswerQuestion.builder()
                    .question(question)
                    .caseSensitive(createQtypeShortanswerQuestionCommand.getCaseSensitive())
                    .build();
        }

        public QueryQtypeShortanswerQuestionResponse qtypeShortanswerQuestionToQueryQtypeShortanswerQuestionByIdResponse(QtypeShortAnswerQuestion qtypeShortanswerQuestion) {
            return QueryQtypeShortanswerQuestionResponse.builder()
                    .qtypeShortAnswerQuestion(qtypeShortanswerQuestion)
                    .build();
        }
}
