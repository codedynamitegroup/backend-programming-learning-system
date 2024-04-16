package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.dto.query.question.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class QuestionRepositoryImpl implements QuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionDataAccessMapper questionDataAccessMapper;

    public QuestionRepositoryImpl(QuestionJpaRepository questionJpaRepository,
                                  QuestionDataAccessMapper questionDataAccessMapper) {
        this.questionJpaRepository = questionJpaRepository;
        this.questionDataAccessMapper = questionDataAccessMapper;
    }

    @Override
    public Question saveQuestion(Question question) {
        return questionDataAccessMapper.questionEntityToQuestion(questionJpaRepository
                .save(questionDataAccessMapper
                        .questionToQuestionEntity(question)));
    }

    @Override
    public Optional<Question> findQuestion(UUID id) {
        return questionJpaRepository.findById(id)
                .map(questionDataAccessMapper::questionEntityToQuestion);
    }

    @Override
    public List<QuestionResponseEntity> findAllQuestion() {
        return questionJpaRepository
                .findAll()
                .stream()
                .map(questionDataAccessMapper::questionEntityToQuestionResponseEntity)
                .toList();
    }

    @Override
    public void deleteQuestion(UUID id) {
        questionJpaRepository.deleteById(id);
    }
}
