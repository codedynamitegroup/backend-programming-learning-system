package com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.mapper.QuestionBankCategoryDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.repository.QuestionBankCategoryJpaRepository;
import com.backend.programming.learning.system.entity.QuestionBankCategory;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankCategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionBankCategoryRepositoryImpl implements QuestionBankCategoryRepository {
    private final QuestionBankCategoryJpaRepository questionBankCategoryJpaRepository;
    private final QuestionBankCategoryDataAccessMapper questionBankCategoryDataAccessMapper;

    public QuestionBankCategoryRepositoryImpl(QuestionBankCategoryJpaRepository questionBankCategoryJpaRepository, QuestionBankCategoryDataAccessMapper questionBankCategoryDataAccessMapper) {
        this.questionBankCategoryJpaRepository = questionBankCategoryJpaRepository;
        this.questionBankCategoryDataAccessMapper = questionBankCategoryDataAccessMapper;
    }


    @Override
    public QuestionBankCategory saveQuestionBankCategory(QuestionBankCategory questionBankCategory) {
        return questionBankCategoryDataAccessMapper
                .questionBankCategoryEntityToQuestionBankCategory(questionBankCategoryJpaRepository
                        .save(questionBankCategoryDataAccessMapper
                                .questionBankCategoryToQuestionBankCategoryEntity(questionBankCategory)));
    }
}
