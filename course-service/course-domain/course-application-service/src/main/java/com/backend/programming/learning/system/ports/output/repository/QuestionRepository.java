package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Question;

public interface QuestionRepository {
    Question saveQuestion(Question question);
}
