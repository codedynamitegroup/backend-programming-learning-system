package com.backend.programming.learning.system.course.service.dataaccess.question_bank.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank.mapper.QuestionBankDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank.repository.QuestionBankJpaRepository;
import com.backend.programming.learning.system.entity.QuestionBank;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankRepository;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionBankRepositoryImpl implements QuestionBankRepository {
    private final QuestionBankJpaRepository questionBankJpaRepository;
    private final QuestionBankDataAccessMapper questionBankDataAccessMapper;

    public QuestionBankRepositoryImpl(QuestionBankJpaRepository questionBankJpaRepository, QuestionBankDataAccessMapper questionBankDataAccessMapper) {
        this.questionBankJpaRepository = questionBankJpaRepository;
        this.questionBankDataAccessMapper = questionBankDataAccessMapper;
    }

    @Override
    public QuestionBank saveQuestionBank(QuestionBank questionBank) {
        return questionBankDataAccessMapper
                .questionBankEntityToQuestionBank(questionBankJpaRepository
                        .save(questionBankDataAccessMapper
                                .questionBankToQuestionBankEntity(questionBank)));
    }
}
