package com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.mapper.QuestionBankCategoryDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.repository.QuestionBankCategoryJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.QuestionBankCategory;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.QuestionBankCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class QuestionBankCategoryRepositoryImpl implements QuestionBankCategoryRepository {
    private final QuestionBankCategoryJpaRepository questionBankCategoryJpaRepository;
    private final QuestionBankCategoryDataAccessMapper questionBankCategoryDataAccessMapper;

    @Override
    public QuestionBankCategory save(QuestionBankCategory questionBankCategory) {
        return questionBankCategoryDataAccessMapper
                .questionBankCategoryEntityToQuestionBankCategory(questionBankCategoryJpaRepository
                        .save(questionBankCategoryDataAccessMapper
                                .questionBankCategoryToQuestionBankCategoryEntity(questionBankCategory)));
    }

    @Override
    public Page<QuestionBankCategory> findAll(String search, Integer pageNo, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize);
        return questionBankCategoryJpaRepository.findAll(search, pageRequest)
                .map(questionBankCategoryDataAccessMapper::questionBankCategoryEntityToQuestionBankCategory);
    }

    @Override
    public QuestionBankCategory findById(UUID id) {
        return questionBankCategoryDataAccessMapper
                .questionBankCategoryEntityToQuestionBankCategory(questionBankCategoryJpaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Question bank category not found")));
    }

    @Override
    public Optional<QuestionBankCategory> findQuestionBankCategoryById(UUID questionBankCategoryId) {
        return questionBankCategoryJpaRepository.findById(questionBankCategoryId)
                .map(questionBankCategoryDataAccessMapper::questionBankCategoryEntityToQuestionBankCategory);
    }

    @Override
    public void deleteById(UUID value) {
        questionBankCategoryJpaRepository.deleteById(value);
    }

}
