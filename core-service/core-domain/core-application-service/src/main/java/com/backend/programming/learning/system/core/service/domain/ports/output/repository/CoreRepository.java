package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.domain.entity.Question;

public interface CoreRepository {
    Question saveQuestion(Question question);
}
