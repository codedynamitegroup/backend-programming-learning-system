package com.backend.programming.learning.system.course.service.domain.implement.service.question_bank_category;

import com.backend.programming.learning.system.course.service.domain.dto.method.update.question_bank_category.UpdateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionBankCategoryRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionBankCategoryId;
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
public class QuestionBankCategoryUpdateHelper {
    private final QuestionBankCategoryRepository questionBankCategoryRepository;
    public QuestionBankCategory updateQuestionBankCategory(QuestionBankCategoryId questionBankCategoryId, UpdateQuestionBankCategoryCommand updateQuestionBankCategoryCommand) {
        QuestionBankCategory questionBankCategory = questionBankCategoryRepository.findById(questionBankCategoryId.getValue());
        questionBankCategory.setName(updateQuestionBankCategoryCommand.name());
        return questionBankCategoryRepository.save(questionBankCategory);
    }
}
