package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;

import java.util.List;

public interface AnswerOfQuestionRepository {
    AnswerOfQuestion saveAnswerOfQuestion(AnswerOfQuestion answerOfQuestion);
    List<AnswerOfQuestion> saveAllAnswerOfQuestion(List<AnswerOfQuestion> answerOfQuestionList);
}
