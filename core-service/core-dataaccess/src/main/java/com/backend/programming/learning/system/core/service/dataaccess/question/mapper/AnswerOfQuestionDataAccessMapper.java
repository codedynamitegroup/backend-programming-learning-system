package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.AnswerOfQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.valueobject.AnswerId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerOfQuestionDataAccessMapper {
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public AnswerOfQuestionDataAccessMapper(QuestionDataAccessMapper questionDataAccessMapper) {
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    public AnswerOfQuestion answerOfQuestionEntityToAnswerOfQuestion(AnswerOfQuestionEntity answerOfQuestionEntity) {
        return AnswerOfQuestion.builder()
                .id(new AnswerId(answerOfQuestionEntity.getId()))
                .question(questionDataAccessMapper.questionEntityToQuestion(answerOfQuestionEntity.getQuestion()))
                .feedback(answerOfQuestionEntity.getFeedback())
                .answer(answerOfQuestionEntity.getAnswer())
                .fraction(answerOfQuestionEntity.getFraction())
                .build();
    }

    public AnswerOfQuestionEntity answerOfQuestionToAnswerOfQuestionEntity(AnswerOfQuestion answerOfQuestion) {
        return AnswerOfQuestionEntity.builder()
                .id(answerOfQuestion.getId().getValue())
                .question(questionDataAccessMapper.questionToQuestionEntity(answerOfQuestion.getQuestion()))
                .feedback(answerOfQuestion.getFeedback())
                .answer(answerOfQuestion.getAnswer())
                .fraction(answerOfQuestion.getFraction())
                .build();
    }

    public List<AnswerOfQuestionEntity> answerOfQuestionListToAnswerOfQuestionEntityList(List<AnswerOfQuestion> answerOfQuestionList) {
        return null;
    }
}
