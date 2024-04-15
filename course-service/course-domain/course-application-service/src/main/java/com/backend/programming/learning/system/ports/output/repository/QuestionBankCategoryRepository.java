package com.backend.programming.learning.system.ports.output.repository;

import com.backend.programming.learning.system.entity.QuestionBankCategory;

public interface QuestionBankCategoryRepository {
    QuestionBankCategory saveQuestionBankCategory(QuestionBankCategory questionBankCategory);
}
