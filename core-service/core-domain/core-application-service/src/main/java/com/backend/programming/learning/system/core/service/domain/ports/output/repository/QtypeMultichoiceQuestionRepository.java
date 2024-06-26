package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QtypeMultichoiceQuestionRepository {
    QtypeMultiChoiceQuestion saveQtypeMultipleChoiceQuestion(QtypeMultiChoiceQuestion question);
    Optional<QtypeMultiChoiceQuestion> findQtypeMultipleChoiceQuestion(UUID qtMultipleChoiceQuestionId);
    Optional<QtypeMultiChoiceQuestion> findQtypeMultipleChoiceQuestionByQuestionId(UUID questionId);
    List<QtypeMultiChoiceQuestion> findAllQtypeMultipleChoiceQuestion();
    void deleteQtypeMultipleChoiceQuestion(UUID qtMultipleChoiceQuestionId);
    UUID getId(UUID questionId);
    void updateQtypeMultichoiceQuestion(QtypeMultiChoiceQuestion qtypeMultichoiceQuestion);

    Optional<QtypeMultiChoiceQuestion> findByQuestionId(UUID questionId);
}
