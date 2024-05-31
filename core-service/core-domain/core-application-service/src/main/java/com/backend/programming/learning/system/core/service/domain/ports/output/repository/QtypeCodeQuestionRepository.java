package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QtypeCodeQuestionRepository {
    QtypeCodeQuestion saveQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
    Optional<QtypeCodeQuestion> findQtypeCodeQuestion(UUID qtCodeQuestionId);
    Optional<QtypeCodeQuestion> findQtypeCodeQuestionByQuestionId(UUID questionId);
    List<QtypeCodeQuestion> findAllQtypeCodeQuestions();
    UUID getId(UUID questionId);
    void updateQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
    void deleteById(UUID id);

    Optional<QtypeCodeQuestion> findQuestionId(UUID questionId);
}
