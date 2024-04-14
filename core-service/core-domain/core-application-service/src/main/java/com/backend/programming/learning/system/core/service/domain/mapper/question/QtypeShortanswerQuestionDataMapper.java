package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeShortanswerQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
public class QtypeShortanswerQuestionDataMapper {
        public QtypeShortAnswerQuestion createQuestionCommandToQtypeShortAnswerQuestion(CreateQtypeShortanswerQuestionCommand createQtypeShortanswerQuestionCommand,
                                                                                        QuestionId questionId) {
            return QtypeShortAnswerQuestion.builder()
                    .questionId(questionId)
                    .caseSensitive(createQtypeShortanswerQuestionCommand.getCaseSensitive())
                    .build();
        }
}
