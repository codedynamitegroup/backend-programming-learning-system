package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeShortanswerQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeShortanswerQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import org.springframework.stereotype.Component;

@Component
public class QtypeShortanswerQuestionRepositoryImpl implements QtypeShortanswerQuestionRepository {
    private final QtypeShortanswerQuestionJpaRepository qtypeShortAnswerQuestionJpaRepository;
    private final QtypeQuestionDataAccessMapper qtypeQuestionDataAccessMapper;

    public QtypeShortanswerQuestionRepositoryImpl(QtypeShortanswerQuestionJpaRepository qtypeShortAnswerQuestionJpaRepository,
                                                  QtypeQuestionDataAccessMapper qtypeQuestionDataAccessMapper) {
        this.qtypeShortAnswerQuestionJpaRepository = qtypeShortAnswerQuestionJpaRepository;
        this.qtypeQuestionDataAccessMapper = qtypeQuestionDataAccessMapper;
    }

    @Override
    public QtypeShortAnswerQuestion saveQtypeShortAnswerQuestion(QtypeShortAnswerQuestion question) {
        return qtypeQuestionDataAccessMapper.qtypeShortanswerQuestionEntityToQtypeShortanswerQuestion(qtypeShortAnswerQuestionJpaRepository
                .save(qtypeQuestionDataAccessMapper
                        .qtypeShortanswerQuestionToQtypeShortanswerQuestionEntity(question)));
    }
}
