package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.domain.entity.Question;

public interface QuestionRepository {
    Question saveQuestion(Question question);
}
