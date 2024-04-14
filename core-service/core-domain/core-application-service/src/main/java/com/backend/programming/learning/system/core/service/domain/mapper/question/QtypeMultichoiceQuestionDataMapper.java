package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

@Component
public class QtypeMultichoiceQuestionDataMapper {
        public QtypeMultiChoiceQuestion createQuestionCommandToQtypeMultiChoiceQuestion(CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand,
                                                                                        QuestionId questionId) {
            return QtypeMultiChoiceQuestion.builder()
                    .questionId(questionId)
                    .single(createQtypeMultichoiceQuestionCommand.getSingle())
                    .shuffleAnswers(createQtypeMultichoiceQuestionCommand.getShuffleAnswers())
                    .correctFeedback(createQtypeMultichoiceQuestionCommand.getCorrectFeedback())
                    .partiallyCorrectFeedback(createQtypeMultichoiceQuestionCommand.getPartiallyCorrectFeedback())
                    .incorrectFeedback(createQtypeMultichoiceQuestionCommand.getIncorrectFeedback())
                    .answerNumbering(createQtypeMultichoiceQuestionCommand.getAnswerNumbering())
                    .showNumCorrect(createQtypeMultichoiceQuestionCommand.getShowNumCorrect())
                    .showStandardInstructions(createQtypeMultichoiceQuestionCommand.getShowStandardInstructions())
                    .build();
    }
}
