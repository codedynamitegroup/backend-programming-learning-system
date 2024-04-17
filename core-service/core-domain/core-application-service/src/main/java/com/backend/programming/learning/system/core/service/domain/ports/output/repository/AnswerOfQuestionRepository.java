package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.AnswerOfQuestion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnswerOfQuestionRepository {
    AnswerOfQuestion saveAnswerOfQuestion(AnswerOfQuestion answerOfQuestion);
    List<AnswerOfQuestion> saveAllAnswerOfQuestion(List<AnswerOfQuestion> answerOfQuestionList);
    void deleteAnswerOfQuestion(UUID answerId);
    void deleteAllAnswerOfQuestionByQuestionId(UUID questionId);
    Optional<AnswerOfQuestion> getAnswerOfQuestionById(UUID answerId);
}
