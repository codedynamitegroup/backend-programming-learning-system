package com.backend.programming.learning.system.course.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.entity.Question;
import com.backend.programming.learning.system.ports.output.repository.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionRepositoryImpl implements QuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public QuestionRepositoryImpl(QuestionJpaRepository questionJpaRepository, QuestionDataAccessMapper questionDataAccessMapper) {
        this.questionJpaRepository = questionJpaRepository;
        this.questionDataAccessMapper = questionDataAccessMapper;
    }


    @Override
    public Question saveQuestion(Question question) {
        return questionDataAccessMapper
                .questionEntityToQuestion(questionJpaRepository
                        .save(questionDataAccessMapper
                                .questionToQuestionEntity(question)));
    }

    @Override
    public Page<Question> findAll(Integer page, Integer size) {
        return questionJpaRepository.findAll(PageRequest.of(page, size))
                .map(questionDataAccessMapper::questionEntityToQuestion);
    }
}
