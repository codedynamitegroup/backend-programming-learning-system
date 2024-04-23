package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.QuestionBankCategory;
import com.backend.programming.learning.system.valueobject.QuestionBankCategoryId;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface QuestionBankCategoryRepository {
    QuestionBankCategory save(QuestionBankCategory questionBankCategory);

    Page<QuestionBankCategory> findAll(String search, Integer pageNo, Integer pageSize);

    QuestionBankCategory findById(UUID id);

    Optional<QuestionBankCategory> findQuestionBankCategoryById(UUID questionBankCategoryId);
}
