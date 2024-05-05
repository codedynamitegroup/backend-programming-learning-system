package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeEssayQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeEssayQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeEssayQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.exception.question.QtypeEssayQuestionNotFoundException;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeEssayQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeEssayQuestion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Slf4j
public class QtypeEssayQuestionRepositoryImpl implements QtypeEssayQuestionRepository {
    private final QtypeEssayQuestionJpaRepository qtypeEssayQuestionJpaRepository;
    private final QtypeEssayQuestionDataAccessMapper qtypeEssayQuestionDataAccessMapper;

    public QtypeEssayQuestionRepositoryImpl(QtypeEssayQuestionJpaRepository qtypeEssayQuestionJpaRepository,
                                            QtypeEssayQuestionDataAccessMapper qtypeEssayQuestionDataAccessMapper) {
        this.qtypeEssayQuestionJpaRepository = qtypeEssayQuestionJpaRepository;
        this.qtypeEssayQuestionDataAccessMapper = qtypeEssayQuestionDataAccessMapper;
    }

    @Override
    public QtypeEssayQuestion saveQtypeEssayQuestion(QtypeEssayQuestion question) {
        return qtypeEssayQuestionDataAccessMapper.qtypeEssayQuestionEntityToQtypeEssayQuestion(qtypeEssayQuestionJpaRepository
                .save(qtypeEssayQuestionDataAccessMapper
                        .qtypeEssayQuestionToQtypeEssayQuestionEntity(question)));
    }

    @Override
    public Optional<QtypeEssayQuestion> findQtypeEssayQuestion(UUID qtEssayQuestionId) {
        return qtypeEssayQuestionJpaRepository.findById(qtEssayQuestionId)
                .map(qtypeEssayQuestionDataAccessMapper::qtypeEssayQuestionEntityToQtypeEssayQuestion);
    }

    @Override
    public Optional<QtypeEssayQuestion> findQtypeEssayQuestionByQuestionId(UUID questionId) {
        return qtypeEssayQuestionJpaRepository.findByQuestionId(questionId)
                .map(qtypeEssayQuestionDataAccessMapper::qtypeEssayQuestionEntityToQtypeEssayQuestion);
    }

    @Override
    public List<QtypeEssayQuestion> findAllQtypeEssayQuestion() {
        return qtypeEssayQuestionJpaRepository
                .findAll()
                .stream()
                .map(qtypeEssayQuestionDataAccessMapper::qtypeEssayQuestionEntityToQtypeEssayQuestion)
                .toList();
    }

    @Override
    public void deleteQtypeEssayQuestion(UUID qtEssayQuestionId) {

    }

    @Override
    public UUID getId(UUID questionId) {
        return qtypeEssayQuestionJpaRepository.getId(questionId);
    }

    @Override
    public void updateQtypeEssayQuestion(QtypeEssayQuestion qtypeEssayQuestion) {
        Optional<QtypeEssayQuestionEntity> qtypeEssayQuestionEntity = qtypeEssayQuestionJpaRepository.findById(qtypeEssayQuestion.getId().getValue());

        if (qtypeEssayQuestionEntity.isEmpty()) {
            log.error("Qtype Essay Question not found with id: {}", qtypeEssayQuestion.getId().getValue());
            throw new QtypeEssayQuestionNotFoundException("Qtype Essay Question not found with id: " + qtypeEssayQuestion.getId().getValue());
        }

        QtypeEssayQuestionEntity savingQtypeEssayQuestionEntity = qtypeEssayQuestionDataAccessMapper
                .setQtypeEssayQuestionEntity(qtypeEssayQuestionEntity.get(), qtypeEssayQuestion);
        qtypeEssayQuestionJpaRepository.save(savingQtypeEssayQuestionEntity);
    }
}
