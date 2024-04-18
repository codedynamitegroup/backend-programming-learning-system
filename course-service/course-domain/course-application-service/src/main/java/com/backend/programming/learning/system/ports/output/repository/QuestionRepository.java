package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Question;
import org.springframework.data.domain.Page;

public interface QuestionRepository {
    Question saveQuestion(Question question);

    Page<Question> findAll(Integer page, Integer size);
}
