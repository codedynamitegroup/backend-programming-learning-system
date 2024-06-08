package com.backend.programming.learning.system.course.service.domain.mapper.question_bank_category;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.question_bank_category.UpdateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question_bank_category.QuestionBankCategoryEntity;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.entity.User;
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
    public QuestionBankCategory createQuestionBankCategoryCommandToQuestionBankCategory(
            User user, CreateQuestionBankCategoryCommand createQuestionBankCategoryCommand) {
        return QuestionBankCategory.builder()
                .name(createQuestionBankCategoryCommand.name())
                .description(createQuestionBankCategoryCommand.description())
                .isOrgQuestionBank(createQuestionBankCategoryCommand.isOrgQuestionBank())
                .createdBy(user)
                .updatedBy(user)
                .build();
    }

    public CreateQuestionBankCategoryResponse questionBankCategoryToCreateQuestionBankCategoryResponse(QuestionBankCategory questionBankCategory) {
        return CreateQuestionBankCategoryResponse.builder()
                .id(questionBankCategory.getId().getValue())
                .name(questionBankCategory.getName())
                .description(questionBankCategory.getDescription())
                .isOrgQuestionBank(questionBankCategory.getIsOrgQuestionBank())
                .createdBy(questionBankCategory.getCreatedBy().getId().getValue())
                .updatedBy(questionBankCategory.getUpdatedBy().getId().getValue())
                .createdAt(questionBankCategory.getCreatedAt())
                .updatedAt(questionBankCategory.getUpdatedAt())
                .message("Question bank category is created successfully")
                .build();
    }

    public QueryAllQuestionBankCategoryResponse pageQuestionBankCategoryToQueryAllQuestionBankCategoryResponse(Page<QuestionBankCategory> questionBankCategoryPage) {
        return QueryAllQuestionBankCategoryResponse.builder()
                .questionBankCategories(questionBankCategoryPage
                        .map(this::questionBankCategoryToQuestionBankCategoryEntity).toList())
                .currentPage(questionBankCategoryPage.getNumber())
                .totalItems(questionBankCategoryPage.getTotalElements())
                .totalPages(questionBankCategoryPage.getTotalPages())
                .build();
    }
    public QuestionBankCategoryEntity questionBankCategoryToQuestionBankCategoryEntity(QuestionBankCategory questionBankCategory) {
        return QuestionBankCategoryEntity.builder()
                .id(questionBankCategory.getId().getValue())
                .name(questionBankCategory.getName())
                .description(questionBankCategory.getDescription())
                .createdBy(questionBankCategory.getCreatedBy().getId().getValue())
                .createdByName(questionBankCategory.getCreatedBy().getName())
                .updatedBy(questionBankCategory.getUpdatedBy().getId().getValue())
                .updatedByName(questionBankCategory.getUpdatedBy().getName())
                .createdAt(questionBankCategory.getCreatedAt())
                .updatedAt(questionBankCategory.getUpdatedAt())
                .build();
    }

    public UpdateQuestionBankCategoryResponse questionBankCategoryToUpdateQuestionBankCategoryResponse(QuestionBankCategory questionBankCategory) {
        return UpdateQuestionBankCategoryResponse.builder()
                .questionBankCategoryId(questionBankCategory.getId().getValue())
                .name(questionBankCategory.getName())
                .description(questionBankCategory.getDescription())
                .createdBy(questionBankCategory.getCreatedBy().getId().getValue())
                .updatedBy(questionBankCategory.getUpdatedBy().getId().getValue())
                .createdAt(questionBankCategory.getCreatedAt())
                .updatedAt(questionBankCategory.getUpdatedAt())
                .message("Question bank category is updated successfully")
                .build();
    }

}
