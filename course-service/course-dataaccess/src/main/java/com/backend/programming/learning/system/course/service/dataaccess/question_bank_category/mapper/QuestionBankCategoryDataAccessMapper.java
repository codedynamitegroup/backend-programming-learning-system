package com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank.entity.QuestionBankEntity;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank.mapper.QuestionBankDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.entity.QuestionBankCategoryEntity;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.entity.QuestionBankCategory;
import com.backend.programming.learning.system.valueobject.QuestionBankCategoryId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class QuestionBankCategoryDataAccessMapper {
    final QuestionBankDataAccessMapper questionBankDataAccessMapper;
    public QuestionBankCategoryEntity questionBankCategoryToQuestionBankCategoryEntity(QuestionBankCategory questionBankCategory) {
        QuestionBankEntity questionBankEntity = questionBankDataAccessMapper
                .questionBankToQuestionBankEntity(questionBankCategory.getQuestionBank());
        return QuestionBankCategoryEntity.builder()
                .id(questionBankCategory.getId().getValue())
                .questionBank(questionBankEntity)
                .name(questionBankCategory.getName())
                .build();
    }

    public QuestionBankCategory questionBankCategoryEntityToQuestionBankCategory(QuestionBankCategoryEntity questionBankCategoryEntity) {
        QuestionBank questionBank = questionBankDataAccessMapper.questionBankEntityToQuestionBank(questionBankCategoryEntity.getQuestionBank());
        QuestionBankCategory response = QuestionBankCategory.builder()
                .name(questionBankCategoryEntity.getName())
                .questionBank(questionBank)
                .build();
        response.setId(new QuestionBankCategoryId(questionBankCategoryEntity.getId()));
        return response;
    }
}
