package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.dto.responseentity.QuestionResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.Question;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QuestionRepository;
import com.backend.programming.learning.system.domain.exception.question.QuestionNotFoundException;
import com.backend.programming.learning.system.domain.valueobject.QuestionType;
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

    @Override
    public QuestionType getQtype(UUID id) {
        return QuestionType.valueOf(questionJpaRepository.getQtype(id));
    }

    // Update Question and Answer of Question
    @Override
    public void updateQuestion(Question question) {
        Optional<QuestionEntity> questionEntity = questionJpaRepository.findById(question.getId().getValue());

        if (questionEntity.isEmpty()) {
            throw new QuestionNotFoundException("Question not found with id: " + question.getId().getValue());
        }

        questionJpaRepository.save(questionDataAccessMapper.setQuestionEntity(questionEntity.get(), question));
    }
}
