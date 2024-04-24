package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.Question;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface QuestionRepository {
    Question saveQuestion(Question question);

    Page<Question> findAll(
            UUID questionBankCategoryId,
            String search,
            Integer page,
            Integer size);

    Question findById(UUID questionId);

    void deleteById(UUID questionId);
}
