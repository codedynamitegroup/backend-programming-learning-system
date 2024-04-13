package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.Question;

import java.util.Optional;
import java.util.UUID;

public interface QuestionRepository {
    Optional<Question> findQuestionInformation(UUID questionId);
}
