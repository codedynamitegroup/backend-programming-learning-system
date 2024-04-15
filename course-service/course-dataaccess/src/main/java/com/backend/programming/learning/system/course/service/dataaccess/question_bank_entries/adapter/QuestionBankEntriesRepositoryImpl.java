package com.backend.programming.learning.system.course.service.dataaccess.question_bank_entries.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank_entries.mapper.QuestionBankEntriesDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question_bank_entries.repository.QuestionBankEntriesJpaRepository;
import com.backend.programming.learning.system.entity.QuestionBankEntries;
import com.backend.programming.learning.system.ports.output.repository.QuestionBankEntriesRepository;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionBankEntriesRepositoryImpl implements QuestionBankEntriesRepository {
    private final QuestionBankEntriesJpaRepository questionBankEntriesJpaRepository;
    private final QuestionBankEntriesDataAccessMapper questionBankEntriesDataAccessMapper;

    public QuestionBankEntriesRepositoryImpl(QuestionBankEntriesJpaRepository questionBankEntriesJpaRepository, QuestionBankEntriesDataAccessMapper questionBankEntriesDataAccessMapper) {
        this.questionBankEntriesJpaRepository = questionBankEntriesJpaRepository;
        this.questionBankEntriesDataAccessMapper = questionBankEntriesDataAccessMapper;
    }


    @Override
    public QuestionBankEntries saveQuestionBankEntries(QuestionBankEntries questionBankEntries) {
        return questionBankEntriesDataAccessMapper
                .questionBankEntriesEntityToQuestionBankEntries(questionBankEntriesJpaRepository
                        .save(questionBankEntriesDataAccessMapper
                                .questionBankEntriesToQuestionBankEntriesEntity(questionBankEntries)));
    }
}
