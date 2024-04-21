package com.backend.programming.learning.system.implement.question_bank_category;

import com.backend.programming.learning.system.CourseDomainService;
import com.backend.programming.learning.system.dto.method.create.question_bank_category.CreateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.dto.method.create.question_bank_category.CreateQuestionBankCategoryResponse;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.entity.QuestionBankCategory;
import com.backend.programming.learning.system.mapper.question_bank_category.QuestionBankCategoryDataMapper;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankCategoryRepository;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class QuestionBankCategoryCreateHelper {
    private final CourseDomainService courseDomainService;
    private final QuestionBankRepository questionBankRepository;
    private final QuestionBankCategoryRepository questionBankCategoryRepository;
    private final QuestionBankCategoryDataMapper questionBankCategoryDataMapper;

    public QuestionBankCategory createQuestionBankCategory(CreateQuestionBankCategoryCommand createQuestionBankCategoryCommand) {
        QuestionBank questionBank = questionBankRepository.findById(createQuestionBankCategoryCommand.questionBankId());
        QuestionBankCategory questionBankCategory = questionBankCategoryDataMapper
                .createQuestionBankCategoryCommandToQuestionBankCategory(questionBank, createQuestionBankCategoryCommand);
        courseDomainService.createQuestionBankCategory(questionBankCategory);
        return saveQuestionBankCategory(questionBankCategory);
    }

    private QuestionBankCategory saveQuestionBankCategory(QuestionBankCategory questionBankCategory) {
        QuestionBankCategory questionBankCategoryResult = questionBankCategoryRepository.save(questionBankCategory);
        log.info("QuestionBankCategory is created with id: {}", questionBankCategoryResult.getId());
        return questionBankCategoryResult;
    }
}
