package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeMultichoiceQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeMultichoiceQuestionRepository;
import com.backend.programming.learning.system.domain.entity.QtypeMultiChoiceQuestion;
import org.springframework.stereotype.Component;

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

}
