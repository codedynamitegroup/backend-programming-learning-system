package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeQuestionDataAccessMapper;
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
    private final QtypeQuestionDataAccessMapper qtypeQuestionDataAccessMapper;

    public QtypeMultichoiceQuestionRepositoryImpl(QtypeMultichoiceQuestionJpaRepository qtypeMultichoiceQuestionJpaRepository,
                                                  QtypeQuestionDataAccessMapper qtypeQuestionDataAccessMapper) {
        this.qtypeMultichoiceQuestionJpaRepository = qtypeMultichoiceQuestionJpaRepository;
        this.qtypeQuestionDataAccessMapper = qtypeQuestionDataAccessMapper;
    }

    @Override
    public QtypeMultiChoiceQuestion saveQtypeMultipleChoiceQuestion(QtypeMultiChoiceQuestion qtypeMultichoiceQuestion) {
        return qtypeQuestionDataAccessMapper.qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion(qtypeMultichoiceQuestionJpaRepository
                .save(qtypeQuestionDataAccessMapper
                        .qtypeMultichoiceQuestionToQtypeMultichoiceQuestionEntity(qtypeMultichoiceQuestion)));
    }

    @Override
    public Optional<QtypeMultiChoiceQuestion> findQtypeMultipleChoiceQuestion(UUID qtMultipleChoiceQuestionId) {
        return qtypeMultichoiceQuestionJpaRepository.findById(qtMultipleChoiceQuestionId)
                .map(qtypeQuestionDataAccessMapper::qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion);
    }

    @Override
    public List<QtypeMultiChoiceQuestion> findAllQtypeMultipleChoiceQuestion() {
        return qtypeMultichoiceQuestionJpaRepository
                .findAll()
                .stream().map(qtypeQuestionDataAccessMapper::qtypeMultichoiceQuestionEntityToQtypeMultichoiceQuestion)
                .toList();
    }
}
