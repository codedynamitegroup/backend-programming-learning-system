package com.backend.programming.learning.system.course.service.dataaccess.question.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.domain.valueobject.QuestionId;
import com.backend.programming.learning.system.entity.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionDataAccessMapper {
    public QuestionEntity questionToQuestionEntity(Question question) {
      return QuestionEntity.builder()
              .id(question.getId().getValue())
              .name(question.getName())
              .questionText(question.getQuestionText())
              .generalFeedback(question.getGeneralFeedback())
              .defaultMark(question.getDefaultMark())
              .qtype(question.getqtype())
//              .qdifficulty(question.getDifficulty())
              .build();
    }

    public Question questionEntityToQuestion(QuestionEntity questionEntity) {
      return Question.builder()
              .id(new QuestionId(questionEntity.getId()))
              .name(questionEntity.getName())
              .questionText(questionEntity.getQuestionText())
              .generalFeedback(questionEntity.getGeneralFeedback())
              .defaultMark(questionEntity.getDefaultMark())
              .qtype(questionEntity.getQtype())
              .difficulty(questionEntity.getDifficulty())
              .build();
    }
}
