package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeCodeQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeCodeQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeCodeQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeCodeQuestionRepositoryImpl implements QtypeCodeQuestionRepository {
    private final QtypeCodeQuestionJpaRepository qtypeCodeQuestionJpaRepository;
    private final QtypeCodeQuestionDataAccessMapper qtypeCodeQuestionDataAccessMapper;

    public QtypeCodeQuestionRepositoryImpl(QtypeCodeQuestionJpaRepository qtypeCodeQuestionJpaRepository,
                                           QtypeCodeQuestionDataAccessMapper qtypeCodeQuestionDataAccessMapper) {
        this.qtypeCodeQuestionJpaRepository = qtypeCodeQuestionJpaRepository;
        this.qtypeCodeQuestionDataAccessMapper = qtypeCodeQuestionDataAccessMapper;
    }

    @Override
    public QtypeCodeQuestion saveQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion) {
        return qtypeCodeQuestionDataAccessMapper.qtypeCodeQuestionEntityToQtypeCodeQuestion(qtypeCodeQuestionJpaRepository
                .save(qtypeCodeQuestionDataAccessMapper
                        .qtypeCodeQuestionToQtypeCodeQuestionEntity(qtypeCodeQuestion)));
    }

    @Override
    public Optional<QtypeCodeQuestion> findQtypeCodeQuestion(UUID qtCodeQuestionId) {
        return qtypeCodeQuestionJpaRepository.findById(qtCodeQuestionId)
                .map(qtypeCodeQuestionDataAccessMapper::qtypeCodeQuestionEntityToQtypeCodeQuestion);
    }

    @Override
    public List<QtypeCodeQuestion> findAllQtypeCodeQuestions() {
        return qtypeCodeQuestionJpaRepository
                .findAll()
                .stream()
                .map(qtypeCodeQuestionDataAccessMapper::qtypeCodeQuestionEntityToQtypeCodeQuestion)
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
            log.error("Qtype Code Question not found with id: {}", qtypeCodeQuestion.getId().getValue());
            throw new QtypeCodeQuestionNotFoundException("Qtype Code Question not found with id: " + qtypeCodeQuestion.getId().getValue());
        }

        QtypeCodeQuestionEntity savingQtypeCodeQuestionEntity = qtypeCodeQuestionDataAccessMapper
                .setQtypeCodeQuestionEntity(qtypeCodeQuestionEntity.get(), qtypeCodeQuestion);
        qtypeCodeQuestionJpaRepository.save(savingQtypeCodeQuestionEntity);
    }

}
