package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;

import java.util.Optional;
import java.util.UUID;

public interface QtypeEssayQuestionRepository {
    QtypeEssayQuestion saveQtypeEssayQuestion(QtypeEssayQuestion question);
    Optional<QtypeEssayQuestion> findQtypeEssayQuestion(UUID qtEssayQuestionId);
}
