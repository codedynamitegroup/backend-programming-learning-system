package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.Question;

import java.util.Optional;
import java.util.UUID;

public interface QuestionRepository {
    Question saveQuestion(Question question);

    Optional<Question> findQuestion(UUID id);
}
