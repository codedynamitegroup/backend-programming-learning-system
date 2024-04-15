package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;

import java.util.Optional;
import java.util.UUID;

public interface QtypeMultichoiceQuestionRepository {
    QtypeMultiChoiceQuestion saveQtypeMultipleChoiceQuestion(QtypeMultiChoiceQuestion question);
    Optional<QtypeMultiChoiceQuestion> findQtypeMultipleChoiceQuestion(UUID qtMultipleChoiceQuestionId);
}
