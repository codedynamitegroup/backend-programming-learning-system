package com.backend.programming.learning.system.implement.question_bank_category;

import com.backend.programming.learning.system.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryCommand;
import com.backend.programming.learning.system.entity.QuestionBankCategory;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankCategoryRepository;
import com.backend.programming.learning.system.valueobject.QuestionBankCategoryId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:25 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionBankCategoryQueryHelper {
    private final QuestionBankCategoryRepository questionBankCategoryRepository;
    public Page<QuestionBankCategory> queryAllQuestionBankCategory(QueryAllQuestionBankCategoryCommand queryAllQuestionBankCategoryCommand) {
        return questionBankCategoryRepository.findAll(
                queryAllQuestionBankCategoryCommand.search(),
                queryAllQuestionBankCategoryCommand.pageNo(),
                queryAllQuestionBankCategoryCommand.pageSize());
    }

    public QuestionBankCategory queryQuestionBankCategory(QuestionBankCategoryId questionBankCategoryId) {
        return questionBankCategoryRepository.findById(questionBankCategoryId.getValue());
    }
}
