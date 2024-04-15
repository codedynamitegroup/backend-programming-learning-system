package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;

import java.util.Optional;
import java.util.UUID;

public interface QtypeShortanswerQuestionRepository {
    QtypeShortAnswerQuestion saveQtypeShortAnswerQuestion(QtypeShortAnswerQuestion question);
    Optional<QtypeShortAnswerQuestion> findQtypeShortAnswerQuestion(UUID qtShortAnswerQuestionId);
}
