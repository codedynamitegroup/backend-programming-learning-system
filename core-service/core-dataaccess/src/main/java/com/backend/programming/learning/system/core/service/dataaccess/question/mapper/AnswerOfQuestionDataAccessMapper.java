package com.backend.programming.learning.system.core.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.AnswerOfQuestionEntity;
import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;
import com.backend.programming.learning.system.core.service.domain.valueobject.AnswerId;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

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
        AnswerOfQuestionEntity.AnswerOfQuestionEntityBuilder builder = AnswerOfQuestionEntity.builder();

        builder.id(answerOfQuestion.getId().getValue());
        builder.questionId(answerOfQuestion.getQuestionId().getValue());

        if (answerOfQuestion.getFeedback() != null)
            builder.feedback(answerOfQuestion.getFeedback());
        if (answerOfQuestion.getAnswer() != null)
            builder.answer(answerOfQuestion.getAnswer());
        if (answerOfQuestion.getFraction() != null)
            builder.fraction(answerOfQuestion.getFraction());

        return builder.build();
    }

    public List<AnswerOfQuestionEntity> answerOfQuestionListToAnswerOfQuestionEntityList(List<AnswerOfQuestion> answerOfQuestionList) {
        return List.of(answerOfQuestionList.stream()
                .map(this::answerOfQuestionToAnswerOfQuestionEntity)
                .toArray(AnswerOfQuestionEntity[]::new));
    }

    public List<AnswerOfQuestion> answerOfQuestionEntityListToAnswerOfQuestionList(List<AnswerOfQuestionEntity> answerOfQuestionEntityList) {
        if(answerOfQuestionEntityList == null)
            return List.of();

        return List.of(answerOfQuestionEntityList.stream()
                .map(this::answerOfQuestionEntityToAnswerOfQuestion)
                .toArray(AnswerOfQuestion[]::new));
    }

    public List<AnswerOfQuestionEntity> setAnswerOfQuestionEntityList(List<AnswerOfQuestionEntity> answerOfQuestionEntityList,
                                                                      List<AnswerOfQuestion> answerOfQuestionList) {
        // Map for easy lookup
        Map<UUID, AnswerOfQuestion> answerOfQuestionMap = answerOfQuestionList.stream()
                .collect(Collectors.toMap(answer -> answer.getId().getValue(), Function.identity()));

        for(AnswerOfQuestionEntity entity : answerOfQuestionEntityList) {
            AnswerOfQuestion answerOfQuestion = answerOfQuestionMap.get(entity.getId());

            if(answerOfQuestion == null)
                continue;

            if (answerOfQuestion.getFeedback() != null)
                entity.setFeedback(answerOfQuestion.getFeedback());
            if (answerOfQuestion.getAnswer() != null)
                entity.setAnswer(answerOfQuestion.getAnswer());
            if (answerOfQuestion.getFraction() != null)
                entity.setFraction(answerOfQuestion.getFraction());
        }

        return answerOfQuestionEntityList;
    }
}
