package com.backend.programming.learning.system.core.service.dataaccess.question.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeCodeQuestionEntity;
import com.backend.programming.learning.system.core.service.dataaccess.question.mapper.QtypeCodeQuestionDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.question.repository.QtypeCodeQuestionJpaRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.QtypeCodeQuestionRepository;
import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Optional<QtypeCodeQuestion> findQtypeCodeQuestionByQuestionId(UUID questionId) {
        return qtypeCodeQuestionJpaRepository.findByQuestionId(questionId)
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

        qtypeCodeQuestionJpaRepository.save(qtypeCodeQuestionDataAccessMapper
                .setQtypeCodeQuestionEntity(qtypeCodeQuestionEntity.get(), qtypeCodeQuestion));
    }

    @Override
    public void deleteById(UUID id) {
        qtypeCodeQuestionJpaRepository.deleteById(id);
    }

    @Override
    public Optional<QtypeCodeQuestion> findQuestionId(UUID questionId) {
        return qtypeCodeQuestionJpaRepository.findByQuestionId(questionId)
                .map(qtypeCodeQuestionDataAccessMapper::qtypeCodeQuestionEntityToQtypeCodeQuestion);
    }

    @Override
    public Page<QtypeCodeQuestion> findAllAdminQtypeCodeQuestions(
            String search,
            QuestionDifficulty difficulty,
            Boolean isPublic,
            Integer pageNo,
            Integer pageSize) {
        Pageable pageable
                = PageRequest
                .of(pageNo, pageSize);

        Page<QtypeCodeQuestionEntity> qtypeCodeQuestionEntities = qtypeCodeQuestionJpaRepository
                .findAllAdminQtypeCodeQuestions(
                        search,
                        difficulty == null ? null: difficulty.name(),
                        isPublic,
                        pageable);

        Page<QtypeCodeQuestion> codeQuestions = qtypeCodeQuestionEntities
                .map(qtypeCodeQuestionDataAccessMapper::qtypeCodeQuestionEntityToQtypeCodeQuestion);

        return codeQuestions;
    }

    @Override
    public Page<QtypeCodeQuestion> findAllOrgAdminQtypeCodeQuestions(UUID orgId,
                                                                     String search,
                                                                     QuestionDifficulty difficulty,
                                                                     Boolean isPublic,
                                                                     Integer pageNo,
                                                                     Integer pageSize) {
        Pageable pageable
                = PageRequest
                .of(pageNo, pageSize);

        Page<QtypeCodeQuestionEntity> qtypeCodeQuestionEntities = qtypeCodeQuestionJpaRepository
                .findAllOrgAdminQtypeCodeQuestions(
                        orgId,
                        search,
                        difficulty == null ? null: difficulty.name(),
                        isPublic,
                        pageable);

        Page<QtypeCodeQuestion> codeQuestions = qtypeCodeQuestionEntities
                .map(qtypeCodeQuestionDataAccessMapper::qtypeCodeQuestionEntityToQtypeCodeQuestion);

        return codeQuestions;
    }

    @Override
    public Page<QtypeCodeQuestion> findAllAllowedToImportOrgAdminQtypeCodeQuestions(UUID orgId, String search, QuestionDifficulty difficulty, Boolean isPublic, Integer pageNo, Integer pageSize) {
        Pageable pageable
                = PageRequest
                .of(pageNo, pageSize);

        Page<QtypeCodeQuestionEntity> qtypeCodeQuestionEntities = qtypeCodeQuestionJpaRepository
                .findAllAllowedToImportOrgAdminQtypeCodeQuestions(
                        orgId,
                        search,
                        difficulty == null ? null: difficulty.name(),
                        isPublic,
                        pageable);

        Page<QtypeCodeQuestion> codeQuestions = qtypeCodeQuestionEntities
                .map(qtypeCodeQuestionDataAccessMapper::qtypeCodeQuestionEntityToQtypeCodeQuestion);

        return codeQuestions;
    }

    @Override
    public Page<QtypeCodeQuestion> findAllAllowedToImportTeacherQtypeCodeQuestions(String search, QuestionDifficulty difficulty, Boolean isPublic, Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);

        Page<QtypeCodeQuestionEntity> qtypeCodeQuestionEntities = qtypeCodeQuestionJpaRepository
                .findAllAllowedToImportTeacherQtypeCodeQuestions(
                        search,
                        difficulty == null ? null: difficulty.name(),
                        isPublic,
                        pageable);

        Page<QtypeCodeQuestion> codeQuestions = qtypeCodeQuestionEntities
                .map(qtypeCodeQuestionDataAccessMapper::qtypeCodeQuestionEntityToQtypeCodeQuestion);

        return codeQuestions;
    }

}
