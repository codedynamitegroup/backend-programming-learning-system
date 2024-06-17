package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface QuestionBankCategoryRepository {
    QuestionBankCategory save(QuestionBankCategory questionBankCategory);

    Page<QuestionBankCategory> findAll(Boolean isOrgQuestionBank, UUID organizationId, String search, Integer pageNo, Integer pageSize);

    QuestionBankCategory findById(UUID id);

    Optional<QuestionBankCategory> findQuestionBankCategoryById(UUID questionBankCategoryId);

    void deleteById(UUID value);
}
