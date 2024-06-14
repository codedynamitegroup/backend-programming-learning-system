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

    public QtypeMultichoiceQuestionEntity setQtypeMultichoiceQuestionEntity(QtypeMultichoiceQuestionEntity qtypeMultichoiceQuestionEntity,
                                                                            QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        if(qtypeMultichoiceQuestion.getSingle() != null)
            qtypeMultichoiceQuestionEntity.setSingle(qtypeMultichoiceQuestion.getSingle());
        if(qtypeMultichoiceQuestion.getShuffleAnswers() != null)
            qtypeMultichoiceQuestionEntity.setShuffleAnswers(qtypeMultichoiceQuestion.getShuffleAnswers());
        if(qtypeMultichoiceQuestion.getCorrectFeedback() != null)
            qtypeMultichoiceQuestionEntity.setCorrectFeedback(qtypeMultichoiceQuestion.getCorrectFeedback());
        if(qtypeMultichoiceQuestion.getPartiallyCorrectFeedback() != null)
            qtypeMultichoiceQuestionEntity.setPartiallyCorrectFeedback(qtypeMultichoiceQuestion.getPartiallyCorrectFeedback());
        if(qtypeMultichoiceQuestion.getIncorrectFeedback() != null)
            qtypeMultichoiceQuestionEntity.setIncorrectFeedback(qtypeMultichoiceQuestion.getIncorrectFeedback());
        if(qtypeMultichoiceQuestion.getAnswerNumbering() != null)
            qtypeMultichoiceQuestionEntity.setAnswerNumbering(qtypeMultichoiceQuestion.getAnswerNumbering());
        if(qtypeMultichoiceQuestion.getShowNumCorrect() != null)
            qtypeMultichoiceQuestionEntity.setShowNumCorrect(qtypeMultichoiceQuestion.getShowNumCorrect());
        if(qtypeMultichoiceQuestion.getShowStandardInstructions() != null)
            qtypeMultichoiceQuestionEntity.setShowStandardInstruction(qtypeMultichoiceQuestion.getShowStandardInstructions());

        return qtypeMultichoiceQuestionEntity;
    }
}
