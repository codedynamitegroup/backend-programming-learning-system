package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.AnswerOfQuestion;

import java.util.List;
import java.util.UUID;

public interface AnswerOfQuestionRepository {
    List<AnswerOfQuestion> saveAnswerOfQuestion(List<AnswerOfQuestion> answerList);
    void deleteAnswerOfQuestionByQuestionId(List<UUID> answerOfQuestionIdList);
    List<AnswerOfQuestion> findAllByQuestionId(UUID questionId);
    void deleteAllByQuestionId(UUID questionId);
}
