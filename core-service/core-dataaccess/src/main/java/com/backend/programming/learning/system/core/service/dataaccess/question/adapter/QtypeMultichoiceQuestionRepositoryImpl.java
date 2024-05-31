package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeMultichoiceQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeMultichoiceQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeMultichoiceQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeMultichoiceQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeMultiChoiceQuestion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class QtypeMultichoiceQuestionRepositoryImpl implements QtypeMultichoiceQuestionRepository {
    private final QtypeMultichoiceQuestionJpaRepository qtypeMultichoiceQuestionJpaRepository;
    private final QtypeMultichoiceQuestionDataAccessMapper qtypeMultichoiceQuestionDataAccessMapper;

    public QtypeMultichoiceQuestionRepositoryImpl(QtypeMultichoiceQuestionJpaRepository qtypeMultichoiceQuestionJpaRepository,
                                                  QtypeMultichoiceQuestionDataAccessMapper qtypeMultichoiceQuestionDataAccessMapper) {
        this.qtypeMultichoiceQuestionJpaRepository = qtypeMultichoiceQuestionJpaRepository;
        this.qtypeMultichoiceQuestionDataAccessMapper = qtypeMultichoiceQuestionDataAccessMapper;
    }

    @Override
    public QtypeMultiChoiceQuestion saveQtypeMultipleChoiceQuestion(QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        return qtypeMultichoiceQuestionDataAccessMapper.qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion(qtypeMultichoiceQuestionJpaRepository
                .save(qtypeMultichoiceQuestionDataAccessMapper
                        .qtypeMultichoiceQuestionToQtypeMultichoiceQuestionEntity(qtypeMultichoiceQuestion)));
    }

    @Override
    public Optional<QtypeMultiChoiceQuestion> findQtypeMultipleChoiceQuestion(UUID qtMultipleChoiceQuestionId) {
        return qtypeMultichoiceQuestionJpaRepository.findById(qtMultipleChoiceQuestionId)
                .map(qtypeMultichoiceQuestionDataAccessMapper::qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion);
    }

    @Override
    public Optional<QtypeMultiChoiceQuestion> findQtypeMultipleChoiceQuestionByQuestionId(UUID questionId) {
        return qtypeMultichoiceQuestionJpaRepository.findByQuestionId(questionId)
                .map(qtypeMultichoiceQuestionDataAccessMapper::qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion);
    }

    @Override
    public List<QtypeMultiChoiceQuestion> findAllQtypeMultipleChoiceQuestion() {
        return qtypeMultichoiceQuestionJpaRepository
                .findAll()
                .stream().map(qtypeMultichoiceQuestionDataAccessMapper::qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion)
                .toList();
    }

    @Override
    public void deleteQtypeMultipleChoiceQuestion(UUID qtMultipleChoiceQuestionId) {

    }

    @Override
    public UUID getId(UUID questionId) {
        return qtypeMultichoiceQuestionJpaRepository.getId(questionId);
    }

    @Override
    public void updateQtypeMultichoiceQuestion(QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        Optional<QtypeMultichoiceQuestionEntity> qtypeMultichoiceQuestionEntity = qtypeMultichoiceQuestionJpaRepository.findById(qtypeMultichoiceQuestion.getId().getValue());
        qtypeMultichoiceQuestionJpaRepository.save(qtypeMultichoiceQuestionDataAccessMapper
                .setQtypeMultichoiceQuestionEntity(qtypeMultichoiceQuestionEntity.get(), qtypeMultichoiceQuestion));
    }

    @Override
    public Optional<QtypeMultiChoiceQuestion> findByQuestionId(UUID questionId) {
        return qtypeMultichoiceQuestionJpaRepository.findByQuestionId(questionId)
                .map(qtypeMultichoiceQuestionDataAccessMapper::qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion);
    }
}
