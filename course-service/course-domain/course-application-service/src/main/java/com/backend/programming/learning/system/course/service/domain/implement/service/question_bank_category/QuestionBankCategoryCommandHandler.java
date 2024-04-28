package com.backend.programming.learning.system.course.service.domain.implement.question_bank_category;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.question_bank_category.QueryAllQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.question_bank_category.UpdateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.question_bank_category.UpdateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.question_bank_category.QuestionBankCategoryEntity;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.mapper.question_bank_category.QuestionBankCategoryDataMapper;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionBankCategoryId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * com.backend.programming.learning.system.implement.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:24 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionBankCategoryCommandHandler {
    private final QuestionBankCategoryCreateHelper questionBankCategoryCreateHelper;
    private final QuestionBankCategoryQueryHelper questionBankCategoryQueryHelper;
    private final QuestionBankCategoryUpdateHelper questionBankCategoryUpdateHelper;
    private final QuestionBankCategoryDataMapper questionBankCategoryDataMapper;
    @Transactional
    public CreateQuestionBankCategoryResponse createQuestionBankCategory(CreateQuestionBankCategoryCommand createQuestionBankCategoryCommand) {
        log.info("Creating question bank category");
        QuestionBankCategory questionBankCategory = questionBankCategoryCreateHelper
                .createQuestionBankCategory(createQuestionBankCategoryCommand);
        return questionBankCategoryDataMapper.questionBankCategoryToCreateQuestionBankCategoryResponse(questionBankCategory);
    }

    @Transactional(readOnly = true)
    public QueryAllQuestionBankCategoryResponse queryAllQuestionBankCategory(QueryAllQuestionBankCategoryCommand queryAllQuestionBankCategoryCommand) {
        log.info("Querying all question bank category");
        Page<QuestionBankCategory> questionBankCategoryPage = questionBankCategoryQueryHelper
                .queryAllQuestionBankCategory(queryAllQuestionBankCategoryCommand);
        return questionBankCategoryDataMapper.pageQuestionBankCategoryToQueryAllQuestionBankCategoryResponse(questionBankCategoryPage);
    }

    public QuestionBankCategoryEntity queryQuestionBankCategory(QuestionBankCategoryId questionBankCategoryId) {
        log.info("Querying question bank category");
        QuestionBankCategory questionBankCategory = questionBankCategoryQueryHelper
                .queryQuestionBankCategory(questionBankCategoryId);
        return questionBankCategoryDataMapper.questionBankCategoryToQuestionBankCategoryEntity(questionBankCategory);
    }

    @Transactional
    public UpdateQuestionBankCategoryResponse updateQuestionBankCategory(QuestionBankCategoryId questionBankCategoryId, UpdateQuestionBankCategoryCommand updateQuestionBankCategoryCommand) {
        log.info("Updating question bank category");
        QuestionBankCategory questionBankCategory = questionBankCategoryUpdateHelper
                .updateQuestionBankCategory(questionBankCategoryId, updateQuestionBankCategoryCommand);
        return questionBankCategoryDataMapper.questionBankCategoryToUpdateQuestionBankCategoryResponse(questionBankCategory);
    }
}
