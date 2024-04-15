package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QueryQtypeMultichoiceQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QtypeMultichoiceQuestionDataMapper {
        public QtypeMultiChoiceQuestion createQuestionCommandToQtypeMultiChoiceQuestion(CreateQtypeMultichoiceQuestionCommand createQtypeMultichoiceQuestionCommand,
                                                                                        Question question) {
            return QtypeMultiChoiceQuestion.builder()
                    .question(question)
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

    public QueryQtypeMultichoiceQuestionResponse qtypeMultichoiceQuestionToQueryQtypeMultichoiceQuestionResponse(QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        return QueryQtypeMultichoiceQuestionResponse.builder()
                .qtypeMultichoiceQuestion(qtypeMultichoiceQuestion)
                .build();
    }

    public List<QueryQtypeMultichoiceQuestionResponse> qtypeMultichoiceQuestionsToQueryQtypeMultichoiceQuestionResponse(List<QtypeMultiChoiceQuestion> qtypeMultichoiceQuestions) {
        return List.of(qtypeMultichoiceQuestions.stream()
                .map(this::qtypeMultichoiceQuestionToQueryQtypeMultichoiceQuestionResponse)
                .toArray(QueryQtypeMultichoiceQuestionResponse[]::new));
    }
}
