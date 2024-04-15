package com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.entity.QuestionBankCategoryEntity;
import com.backend.programming.learning.system.entity.QuestionBankCategory;
import com.backend.programming.learning.system.valueobject.QuestionBankCategoryId;
import org.springframework.stereotype.Component;

@Component
public class QuestionBankCategoryDataAccessMapper {
    public QuestionBankCategoryEntity questionBankCategoryToQuestionBankCategoryEntity(QuestionBankCategory questionBankCategory) {
        return QuestionBankCategoryEntity.builder()
                .id(questionBankCategory.getId().getValue())
                .name(questionBankCategory.getName())
                .build();
    }

    public QuestionBankCategory questionBankCategoryEntityToQuestionBankCategory(QuestionBankCategoryEntity questionBankCategoryEntity) {
        return QuestionBankCategory.builder()
                .id(new QuestionBankCategoryId(questionBankCategoryEntity.getId()))
                .name(questionBankCategoryEntity.getName())
                .build();
    }
}
