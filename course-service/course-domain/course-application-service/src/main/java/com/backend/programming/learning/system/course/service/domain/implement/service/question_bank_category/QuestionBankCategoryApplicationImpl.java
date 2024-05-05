package com.backend.programming.learning.system.course.service.domain.implement.service.question_bank_category;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.question_bank_category.UpdateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.question_bank_category.UpdateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question_bank_category.QuestionBankCategoryEntity;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.question_bank_category.QuestionBankCategoryApplicationService;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionBankCategoryId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * com.backend.programming.learning.system.implement.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:24 AM
 * Description: ...
 */
@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class QuestionBankCategoryApplicationImpl implements QuestionBankCategoryApplicationService {
    private final QuestionBankCategoryCommandHandler questionBankCategoryCommandHandler;
    @Override
    public CreateQuestionBankCategoryResponse createQuestionBankCategoryCommand(CreateQuestionBankCategoryCommand createQuestionBankCategoryCommand) {
        return questionBankCategoryCommandHandler.createQuestionBankCategory(createQuestionBankCategoryCommand);
    }

    @Override
    public QueryAllQuestionBankCategoryResponse queryAllQuestionBankCategory(QueryAllQuestionBankCategoryCommand queryAllQuestionBankCategoryCommand) {
        return questionBankCategoryCommandHandler.queryAllQuestionBankCategory(queryAllQuestionBankCategoryCommand);
    }

    @Override
    public QuestionBankCategoryEntity queryQuestionBankCategory(QuestionBankCategoryId questionBankCategoryId) {
        return questionBankCategoryCommandHandler.queryQuestionBankCategory(questionBankCategoryId);
    }

    @Override
    public UpdateQuestionBankCategoryResponse updateQuestionBankCategory(QuestionBankCategoryId questionBankCategoryId, UpdateQuestionBankCategoryCommand updateQuestionBankCategoryCommand) {
        return questionBankCategoryCommandHandler.updateQuestionBankCategory(questionBankCategoryId, updateQuestionBankCategoryCommand);
    }
}
