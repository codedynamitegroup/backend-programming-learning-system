package com.backend.programming.learning.system.course.service.domain.implement.service.question_bank_category;

import com.backend.programming.learning.system.course.service.domain.CourseDomainService;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.question_bank_category.CreateQuestionBankCategoryCommand;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.mapper.question_bank_category.QuestionBankCategoryDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionBankCategoryRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
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
    private final QuestionBankCategoryRepository questionBankCategoryRepository;
    private final UserRepository userRepository;
    private final QuestionBankCategoryDataMapper questionBankCategoryDataMapper;

    public QuestionBankCategory createQuestionBankCategory(CreateQuestionBankCategoryCommand createQuestionBankCategoryCommand) {
        User user = userRepository.findUser(createQuestionBankCategoryCommand.createdBy())
                .orElseThrow(() -> new RuntimeException("User not found"));
        QuestionBankCategory questionBankCategory = questionBankCategoryDataMapper
                .createQuestionBankCategoryCommandToQuestionBankCategory(user, createQuestionBankCategoryCommand);
        courseDomainService.createQuestionBankCategory(questionBankCategory);
        return saveQuestionBankCategory(questionBankCategory);
    }

    private QuestionBankCategory saveQuestionBankCategory(QuestionBankCategory questionBankCategory) {
        QuestionBankCategory questionBankCategoryResult = questionBankCategoryRepository.save(questionBankCategory);
        log.info("QuestionBankCategory is created with id: {}", questionBankCategoryResult.getId());
        return questionBankCategoryResult;
    }
}
