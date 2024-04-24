package com.backend.programming.learning.system.core.service.domain.mapper.question;

import com.backend.programming.learning.system.core.service.domain.dto.method.create.question.CreateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.dto.method.query.question.QueryQtypeMultichoiceQuestionResponse;
import com.backend.programming.learning.system.core.service.domain.dto.method.update.question.UpdateQtypeMultichoiceQuestionCommand;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.valueobject.QtypeMultiChoiceQuestionId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QtypeMultichoiceQuestionDataMapper {
        private final QuestionDataMapper questionDataMapper;

        public QtypeMultichoiceQuestionDataMapper(QuestionDataMapper questionDataMapper) {
            this.questionDataMapper = questionDataMapper;
        }

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

    public QtypeMultiChoiceQuestion updateQtypeMultichoiceQuestionCommandToQtypeMultiChoiceQuestion(
            UpdateQtypeMultichoiceQuestionCommand updateQtypeMultichoiceQuestionCommand,
            QtypeMultiChoiceQuestion qtypeMultiChoiceQuestion) {
        return QtypeMultiChoiceQuestion.builder()
                .id(new QtypeMultiChoiceQuestionId(updateQtypeMultichoiceQuestionCommand.getQtMultichoiceQuestionId()))
                .single(updateQtypeMultichoiceQuestionCommand.getSingle())
                .shuffleAnswers(updateQtypeMultichoiceQuestionCommand.getShuffleAnswers())
                .correctFeedback(updateQtypeMultichoiceQuestionCommand.getCorrectFeedback())
                .partiallyCorrectFeedback(updateQtypeMultichoiceQuestionCommand.getPartiallyCorrectFeedback())
                .incorrectFeedback(updateQtypeMultichoiceQuestionCommand.getIncorrectFeedback())
                .answerNumbering(updateQtypeMultichoiceQuestionCommand.getAnswerNumbering())
                .showNumCorrect(updateQtypeMultichoiceQuestionCommand.getShowNumCorrect())
                .showStandardInstructions(updateQtypeMultichoiceQuestionCommand.getShowStandardInstructions())
                .question(questionDataMapper
                        .updateQuestionEntityToQuestion(updateQtypeMultichoiceQuestionCommand.getQuestion(),
                                qtypeMultiChoiceQuestion.getQuestion().getId(),
                                qtypeMultiChoiceQuestion.getQuestion().getOrganization(),
                                qtypeMultiChoiceQuestion.getQuestion().getCreatedBy(),
                                qtypeMultiChoiceQuestion.getQuestion().getqtype(),
                                qtypeMultiChoiceQuestion.getQuestion().getAnswers()))
                .build();
    }
}
