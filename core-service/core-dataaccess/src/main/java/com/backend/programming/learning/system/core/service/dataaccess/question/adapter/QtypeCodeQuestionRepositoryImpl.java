package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeCodeQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.domain.entity.QtypeCodeQuestion;
import org.springframework.stereotype.Component;

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
}
