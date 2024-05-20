package com.backend.programming.learning.system.course.service.domain.implement.service.question_bank_category;

import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionBankCategoryRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.QuestionBankCategoryId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * com.backend.programming.learning.system.implement.question_bank_category
 * Create by Dang Ngoc Tien
 * Date 4/22/2024 - 1:26 AM
 * Description: ...
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionBankCategoryDeleteHelper {
    private final QuestionBankCategoryRepository questionBankCategoryRepository;
    public void deleteQuestionBankCategory(QuestionBankCategoryId questionBankCategoryId) {
        questionBankCategoryRepository.deleteById(questionBankCategoryId.getValue());
    }
}
