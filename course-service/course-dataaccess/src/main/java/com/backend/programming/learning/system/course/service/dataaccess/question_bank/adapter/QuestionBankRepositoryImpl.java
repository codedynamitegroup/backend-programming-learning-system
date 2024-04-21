package com.backend.programming.learning.system.course.service.dataaccess.question_bank.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank.mapper.QuestionBankDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank.repository.QuestionBankJpaRepository;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class QuestionBankRepositoryImpl implements QuestionBankRepository {
    private final QuestionBankJpaRepository questionBankJpaRepository;
    private final QuestionBankDataAccessMapper questionBankDataAccessMapper;

    @Override
    public QuestionBank save(QuestionBank questionBank) {
        return questionBankDataAccessMapper
                .questionBankEntityToQuestionBank(questionBankJpaRepository
                        .save(questionBankDataAccessMapper
                                .questionBankToQuestionBankEntity(questionBank)));
    }

    @Override
    public Page<QuestionBank> findAll(String search, Integer pageNo, Integer pageSize) {
        return questionBankJpaRepository.findAll(search, PageRequest.of(pageNo, pageSize))
                .map(questionBankDataAccessMapper::questionBankEntityToQuestionBank);
    }

    @Override
    public QuestionBank findById(UUID questionBankId) {
        return questionBankDataAccessMapper
                .questionBankEntityToQuestionBank(questionBankJpaRepository
                        .findById(questionBankId)
                        .orElseThrow(() -> new RuntimeException("Question bank not found")));
    }

    @Override
    public void deleteById(UUID value) {
        questionBankJpaRepository.deleteById(value);
    }
}
