package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionRepository {
    Question saveQuestion(Question question);
    Optional<Question> findQuestion(UUID id);
    List<QuestionResponseEntity> findAllQuestion();
    void deleteQuestion(UUID id);
    QuestionType getQtype(UUID id);

    // Update Question and Answer of Question
    void updateQuestion(Question question);
}
