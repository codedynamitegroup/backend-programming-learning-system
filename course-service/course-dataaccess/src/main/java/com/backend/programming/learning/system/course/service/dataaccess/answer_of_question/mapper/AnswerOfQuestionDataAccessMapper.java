package com.backend.programming.learning.system.course.service.dataaccess.answer_of_question.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.answer_of_question.entity.AnswerOfQuestionEntity;
import com.backend.programming.learning.system.course.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.course.service.domain.valueobject.AnswerOfQuestionId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AnswerOfQuestionDataAccessMapper {
    private AnswerOfQuestionEntity answerOfQuestionToAnswerOfQuestionEntity(AnswerOfQuestion answerOfQuestion) {
        return AnswerOfQuestionEntity.builder()
                .id(answerOfQuestion.getId().getValue())
                .questionId(answerOfQuestion.getQuestionId().getValue())
                .answer(answerOfQuestion.getAnswer())
                .feedback(answerOfQuestion.getFeedback())
                .fraction(answerOfQuestion.getFraction())
                .build();

    }

    private AnswerOfQuestion answerOfQuestionEntityToAnswerOfQuestion(AnswerOfQuestionEntity answerOfQuestionEntity) {
        return AnswerOfQuestion.builder()
                .id(new AnswerOfQuestionId(answerOfQuestionEntity.getId()))
                .questionId(new QuestionId(answerOfQuestionEntity.getQuestionId()))
                .answer(answerOfQuestionEntity.getAnswer())
                .feedback(answerOfQuestionEntity.getFeedback())
                .fraction(answerOfQuestionEntity.getFraction())
                .build();
    }

    public List<AnswerOfQuestion> answerOfQuestionEntityListToAnswerOfQuestionList(List<AnswerOfQuestionEntity> answerOfQuestionEntityList) {
        return answerOfQuestionEntityList.stream()
                .map(this::answerOfQuestionEntityToAnswerOfQuestion)
                .toList();
    }
    public List<AnswerOfQuestionEntity> answerOfQuestionListToAnswerOfQuestionEntityList(List<AnswerOfQuestion> answerOfQuestionList) {
        return answerOfQuestionList.stream()
                .map(this::answerOfQuestionToAnswerOfQuestionEntity)
                .toList();
    }
}
