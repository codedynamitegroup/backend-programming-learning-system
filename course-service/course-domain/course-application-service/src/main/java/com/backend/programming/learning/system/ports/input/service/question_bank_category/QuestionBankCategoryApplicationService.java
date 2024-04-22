package com.backend.programming.learning.system.ports.input.service.question_bank_category;

import com.backend.programming.learning.system.dto.method.create.question_bank_category.CreateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.dto.method.create.question_bank_category.CreateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryCommand;
import com.backend.programming.learning.system.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryResponse;
import com.backend.programming.learning.system.dto.method.update.question_bank_category.UpdateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.dto.method.update.question_bank_category.UpdateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.dto.responseentity.question_bank_category.QuestionBankCategoryEntity;
import com.backend.programming.learning.system.valueobject.QuestionBankCategoryId;

import javax.validation.Valid;

/**
 * com.backend.programming.learning.system.ports.input.service.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:28 AM
 * Description: ...
 */
public interface QuestionBankCategoryApplicationService {
    CreateQuestionBankCategoryResponse createQuestionBankCategoryCommand(
            @Valid CreateQuestionBankCategoryCommand createQuestionBankCategoryCommand);

    QueryAllQuestionBankCategoryResponse queryAllQuestionBankCategory(
            @Valid QueryAllQuestionBankCategoryCommand queryAllQuestionBankCategoryCommand);

    QuestionBankCategoryEntity queryQuestionBankCategory(
            @Valid QuestionBankCategoryId questionBankCategoryId);

    UpdateQuestionBankCategoryResponse updateQuestionBankCategory(
            @Valid QuestionBankCategoryId questionBankCategoryId,
            @Valid UpdateQuestionBankCategoryCommand updateQuestionBankCategoryCommand);
}
