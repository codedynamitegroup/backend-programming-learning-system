package com.backend.programming.learning.system.course.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.ports.output.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class QuestionRepositoryImpl implements QuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    @Override
    public Question saveQuestion(Question question) {
        return questionDataAccessMapper
                .questionEntityToQuestion(questionJpaRepository
                        .save(questionDataAccessMapper
                                .questionToQuestionEntity(question)));
    }

    @Override
    public Page<Question> findAll(UUID questionBankCategoryId, Integer page, Integer size) {
        return questionJpaRepository.findAll(questionBankCategoryId, PageRequest.of(page, size))
                .map(questionDataAccessMapper::questionEntityToQuestion);
    }

    @Override
    public Question findById(UUID questionId) {
        return questionDataAccessMapper
                .questionEntityToQuestion(questionJpaRepository
                        .findById(questionId)
                        .orElseThrow(() -> new RuntimeException("Question not found")));
    }

    @Override
    public void deleteById(UUID questionId) {
        questionJpaRepository.deleteById(questionId);
    }
}
