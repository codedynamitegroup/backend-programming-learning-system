package com.backend.programming.learning.system.mapper.question_bank_category;

import com.backend.programming.learning.system.dto.method.create.question_bank_category.CreateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.dto.method.create.question_bank_category.CreateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryResponse;
import com.backend.programming.learning.system.dto.method.update.question_bank_category.UpdateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.dto.responseentity.question_bank_category.QuestionBankCategoryEntity;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.entity.QuestionBankCategory;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.mapper.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:27 AM
 * Description: ...
 */
@Component
public class QuestionBankCategoryDataMapper {
    public QuestionBankCategory createQuestionBankCategoryCommandToQuestionBankCategory(QuestionBank questionBank, CreateQuestionBankCategoryCommand createQuestionBankCategoryCommand) {
        return QuestionBankCategory.builder()
                .name(createQuestionBankCategoryCommand.name())
                .questionBank(questionBank)
                .build();
    }

    public CreateQuestionBankCategoryResponse questionBankCategoryToCreateQuestionBankCategoryResponse(QuestionBankCategory questionBankCategory) {
        return CreateQuestionBankCategoryResponse.builder()
                .questionBankCategoryId(questionBankCategory.getId().getValue())
                .name(questionBankCategory.getName())
                .questionBankId(questionBankCategory.getQuestionBank().getId().getValue())
                .message("Question bank category is created successfully")
                .build();
    }

    public QueryAllQuestionBankCategoryResponse pageQuestionBankCategoryToQueryAllQuestionBankCategoryResponse(Page<QuestionBankCategory> questionBankCategoryPage) {
        return QueryAllQuestionBankCategoryResponse.builder()
                .questionBankCategories(questionBankCategoryPage.map(this::questionBankCategoryToQuestionBankCategoryEntity).toList())
                .message("Query all question bank category successfully")
                .build();
    }
    public QuestionBankCategoryEntity questionBankCategoryToQuestionBankCategoryEntity(QuestionBankCategory questionBankCategory) {
        return QuestionBankCategoryEntity.builder()
                .questionBankCategoryId(questionBankCategory.getId().getValue())
                .name(questionBankCategory.getName())
                .questionBankId(questionBankCategory.getQuestionBank().getId().getValue())
                .build();
    }

    public UpdateQuestionBankCategoryResponse questionBankCategoryToUpdateQuestionBankCategoryResponse(QuestionBankCategory questionBankCategory) {
        return UpdateQuestionBankCategoryResponse.builder()
                .questionBankCategoryId(questionBankCategory.getId().getValue())
                .name(questionBankCategory.getName())
                .questionBankId(questionBankCategory.getQuestionBank().getId().getValue())
                .message("Question bank category is updated successfully")
                .build();
    }
}
