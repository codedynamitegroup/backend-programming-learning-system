package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.AnswerOfQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.valueobject.AnswerId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerOfQuestionDataAccessMapper {
    public AnswerOfQuestion answerOfQuestionEntityToAnswerOfQuestion(AnswerOfQuestionEntity answerOfQuestionEntity) {
        return AnswerOfQuestion.builder()
                .id(new AnswerId(answerOfQuestionEntity.getId()))
                .questionId(new QuestionId(answerOfQuestionEntity.getQuestionId()))
                .feedback(answerOfQuestionEntity.getFeedback())
                .answer(answerOfQuestionEntity.getAnswer())
                .fraction(answerOfQuestionEntity.getFraction())
                .build();
    }

    public AnswerOfQuestionEntity answerOfQuestionToAnswerOfQuestionEntity(AnswerOfQuestion answerOfQuestion) {
        return AnswerOfQuestionEntity.builder()
                .id(answerOfQuestion.getId().getValue())
                .questionId(answerOfQuestion.getQuestionId().getValue())
                .feedback(answerOfQuestion.getFeedback())
                .answer(answerOfQuestion.getAnswer())
                .fraction(answerOfQuestion.getFraction())
                .build();
    }

    public List<AnswerOfQuestionEntity> answerOfQuestionListToAnswerOfQuestionEntityList(List<AnswerOfQuestion> answerOfQuestionList) {
        return List.of(answerOfQuestionList.stream()
                .map(this::answerOfQuestionToAnswerOfQuestionEntity)
                .toArray(AnswerOfQuestionEntity[]::new));
    }

    public List<AnswerOfQuestion> answerOfQuestionEntityListToAnswerOfQuestionList(List<AnswerOfQuestionEntity> answerOfQuestionEntityList) {
        return List.of(answerOfQuestionEntityList.stream()
                .map(this::answerOfQuestionEntityToAnswerOfQuestion)
                .toArray(AnswerOfQuestion[]::new));
    }
}
