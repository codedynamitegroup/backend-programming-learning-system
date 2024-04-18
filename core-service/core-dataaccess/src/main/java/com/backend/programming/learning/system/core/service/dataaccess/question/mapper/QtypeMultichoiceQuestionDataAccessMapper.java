package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeMultichoiceQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import com.backend.programming.learning.system.domain.valueobject.QtypeMultiChoiceQuestionId;
import org.springframework.stereotype.Component;

@Component
public class QtypeMultichoiceQuestionDataAccessMapper {
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public QtypeMultichoiceQuestionDataAccessMapper(QuestionDataAccessMapper questionDataAccessMapper) {
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    public QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionToQtypeMultichoiceQuestionEntity(
            QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        return QtypeMultichoiceQuestionEntity.builder()
                .id(qtypeMultichoiceQuestion.getId().getValue())
                .question(questionDataAccessMapper.questionToQuestionEntity(qtypeMultichoiceQuestion.getQuestion()))
                .single(qtypeMultichoiceQuestion.getSingle())
                .shuffleAnswers(qtypeMultichoiceQuestion.getShuffleAnswers())
                .correctFeedback(qtypeMultichoiceQuestion.getCorrectFeedback())
                .partiallyCorrectFeedback(qtypeMultichoiceQuestion.getPartiallyCorrectFeedback())
                .incorrectFeedback(qtypeMultichoiceQuestion.getIncorrectFeedback())
                .answerNumbering(qtypeMultichoiceQuestion.getAnswerNumbering())
                .showNumCorrect(qtypeMultichoiceQuestion.getShowNumCorrect())
                .showStandardInstruction(qtypeMultichoiceQuestion.getShowStandardInstructions())
                .build();
    }

    public QtypeMultiChoiceQuestion qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion(QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionEntity) {
        return QtypeMultiChoiceQuestion.builder()
                .id(new QtypeMultiChoiceQuestionId(qtypeMultichoiceQuestionEntity.getId()))
                .question(questionDataAccessMapper.questionEntityToQuestion(qtypeMultichoiceQuestionEntity.getQuestion()))
                .single(qtypeMultichoiceQuestionEntity.getSingle())
                .shuffleAnswers(qtypeMultichoiceQuestionEntity.getShuffleAnswers())
                .correctFeedback(qtypeMultichoiceQuestionEntity.getCorrectFeedback())
                .partiallyCorrectFeedback(qtypeMultichoiceQuestionEntity.getPartiallyCorrectFeedback())
                .incorrectFeedback(qtypeMultichoiceQuestionEntity.getIncorrectFeedback())
                .answerNumbering(qtypeMultichoiceQuestionEntity.getAnswerNumbering())
                .showNumCorrect(qtypeMultichoiceQuestionEntity.getShowNumCorrect())
                .showStandardInstructions(qtypeMultichoiceQuestionEntity.getShowStandardInstruction())
                .build();
    }
}
