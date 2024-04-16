package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeShortanswerQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeShortanswerQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeShortAnswerQuestion;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Optional<QtypeShortAnswerQuestion> findQtypeShortAnswerQuestion(UUID qtShortAnswerQuestionId) {
        return qtypeShortAnswerQuestionJpaRepository.findById(qtShortAnswerQuestionId)
                .map(qtypeQuestionDataAccessMapper::qtypeShortanswerQuestionEntityToQtypeShortanswerQuestion);
    }

    @Override
    public List<QtypeShortAnswerQuestion> findAllQtypeShortAnswerQuestions() {
        return qtypeShortAnswerQuestionJpaRepository
                .findAll()
                .stream()
                .map(qtypeQuestionDataAccessMapper::qtypeShortanswerQuestionEntityToQtypeShortanswerQuestion)
                .toList();
    }
}
