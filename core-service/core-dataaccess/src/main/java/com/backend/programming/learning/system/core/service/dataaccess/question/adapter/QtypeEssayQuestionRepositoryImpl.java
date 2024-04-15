package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeEssayQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeEssayQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import org.springframework.stereotype.Component;

@Component
public class QtypeEssayQuestionRepositoryImpl implements QtypeEssayQuestionRepository {
    private final QtypeEssayQuestionJpaRepository qtypeEssayQuestionJpaRepository;
    private final QtypeQuestionDataAccessMapper qtypeQuestionDataAccessMapper;

    public QtypeEssayQuestionRepositoryImpl(QtypeEssayQuestionJpaRepository qtypeEssayQuestionJpaRepository,
                                            QtypeQuestionDataAccessMapper qtypeQuestionDataAccessMapper) {
        this.qtypeEssayQuestionJpaRepository = qtypeEssayQuestionJpaRepository;
        this.qtypeQuestionDataAccessMapper = qtypeQuestionDataAccessMapper;
    }

    @Override
    public QtypeEssayQuestion saveQtypeEssayQuestion(QtypeEssayQuestion question) {
        return qtypeQuestionDataAccessMapper.qtypeEssayQuestionEntityToQtypeEssayQuestion(qtypeEssayQuestionJpaRepository
                .save(qtypeQuestionDataAccessMapper
                        .qtypeEssayQuestionToQtypeEssayQuestionEntity(question)));
    }
}
