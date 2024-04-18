package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeShortanswerQuestionDataAccessMapper;
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
    private final QtypeShortanswerQuestionDataAccessMapper qtypeShortanswerQuestionDataAccessMapper;

    public QtypeShortanswerQuestionRepositoryImpl(QtypeShortanswerQuestionJpaRepository qtypeShortAnswerQuestionJpaRepository,
                                                  QtypeShortanswerQuestionDataAccessMapper qtypeShortanswerQuestionDataAccessMapper) {
        this.qtypeShortAnswerQuestionJpaRepository = qtypeShortAnswerQuestionJpaRepository;
        this.qtypeShortanswerQuestionDataAccessMapper = qtypeShortanswerQuestionDataAccessMapper;
    }

    @Override
    public QtypeShortAnswerQuestion saveQtypeShortAnswerQuestion(QtypeShortAnswerQuestion question) {
        return qtypeShortanswerQuestionDataAccessMapper.qtypeShortanswerQuestionEntityToQtypeShortanswerQuestion(qtypeShortAnswerQuestionJpaRepository
                .save(qtypeShortanswerQuestionDataAccessMapper
                        .qtypeShortanswerQuestionToQtypeShortanswerQuestionEntity(question)));
    }

    @Override
    public Optional<QtypeShortAnswerQuestion> findQtypeShortAnswerQuestion(UUID qtShortAnswerQuestionId) {
        return qtypeShortAnswerQuestionJpaRepository.findById(qtShortAnswerQuestionId)
                .map(qtypeShortanswerQuestionDataAccessMapper::qtypeShortanswerQuestionEntityToQtypeShortanswerQuestion);
    }

    @Override
    public List<QtypeShortAnswerQuestion> findAllQtypeShortAnswerQuestions() {
        return qtypeShortAnswerQuestionJpaRepository
                .findAll()
                .stream()
                .map(qtypeShortanswerQuestionDataAccessMapper::qtypeShortanswerQuestionEntityToQtypeShortanswerQuestion)
                .toList();
    }

    @Override
    public void deleteQtypeShortAnswerQuestion(UUID qtShortAnswerQuestionId) {
        qtypeShortAnswerQuestionJpaRepository.deleteById(qtShortAnswerQuestionId);
    }

    @Override
    public UUID getId(UUID questionId) {
        return qtypeShortAnswerQuestionJpaRepository.getId(questionId);
    }
}
