package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeCodeQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class QtypeCodeQuestionRepositoryImpl implements QtypeCodeQuestionRepository {
    private final QtypeCodeQuestionJpaRepository qtypeCodeQuestionJpaRepository;
    private final QtypeQuestionDataAccessMapper qtypeQuestionDataAccessMapper;

    public QtypeCodeQuestionRepositoryImpl(QtypeCodeQuestionJpaRepository qtypeCodeQuestionJpaRepository,
                                           QtypeQuestionDataAccessMapper qtypeQuestionDataAccessMapper) {
        this.qtypeCodeQuestionJpaRepository = qtypeCodeQuestionJpaRepository;
        this.qtypeQuestionDataAccessMapper = qtypeQuestionDataAccessMapper;
    }

    @Override
    public QtypeCodeQuestion saveQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion) {
        return qtypeQuestionDataAccessMapper.qtypeCodeQuestionEntityToQtypeCodeQuestion(qtypeCodeQuestionJpaRepository
                .save(qtypeQuestionDataAccessMapper
                        .qtypeCodeQuestionToQtypeCodeQuestionEntity(qtypeCodeQuestion)));
    }

    @Override
    public Optional<QtypeCodeQuestion> findQtypeCodeQuestion(UUID qtCodeQuestionId) {
        return qtypeCodeQuestionJpaRepository.findById(qtCodeQuestionId)
                .map(qtypeQuestionDataAccessMapper::qtypeCodeQuestionEntityToQtypeCodeQuestion);
    }

    @Override
    public List<QtypeCodeQuestion> findAllQtypeCodeQuestions() {
        return qtypeCodeQuestionJpaRepository
                .findAll()
                .stream()
                .map(qtypeQuestionDataAccessMapper::qtypeCodeQuestionEntityToQtypeCodeQuestion)
                .toList();
    }

    @Override
    public UUID getId(UUID questionId) {
        return qtypeCodeQuestionJpaRepository.getId(questionId);
    }

    @Override
    public void updateQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion) {
        Optional<QtypeCodeQuestionEntity> qtypeCodeQuestionEntity = qtypeCodeQuestionJpaRepository.findById(qtypeCodeQuestion.getId().getValue());

        if (qtypeCodeQuestionEntity.isEmpty()) {
            throw new QtypeCodeQuestionNotFoundException("Qtype Code Question not found with id: " + qtypeCodeQuestion.getId().getValue());
        }

        QtypeCodeQuestionEntity savingQtypeCodeQuestionEntity = qtypeQuestionDataAccessMapper.setQtypeCodeQuestionEntity(qtypeCodeQuestionEntity.get(), qtypeCodeQuestion);
        qtypeCodeQuestionJpaRepository.save(savingQtypeCodeQuestionEntity);
    }

}
