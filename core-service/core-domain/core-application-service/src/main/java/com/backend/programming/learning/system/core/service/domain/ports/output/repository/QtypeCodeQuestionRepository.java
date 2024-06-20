package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.QtypeCodeQuestion;
import com.backend.programming.learning.system.domain.valueobject.QuestionDifficulty;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QtypeCodeQuestionRepository {
    QtypeCodeQuestion saveQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
    Optional<QtypeCodeQuestion> findQtypeCodeQuestion(UUID qtCodeQuestionId);
    Optional<QtypeCodeQuestion> findQtypeCodeQuestionByQuestionId(UUID questionId);
    List<QtypeCodeQuestion> findAllQtypeCodeQuestions();
    UUID getId(UUID questionId);
    void updateQtypeCodeQuestion(QtypeCodeQuestion qtypeCodeQuestion);
    void deleteById(UUID id);

    Optional<QtypeCodeQuestion> findQuestionId(UUID questionId);
    Page<QtypeCodeQuestion> findAllAdminQtypeCodeQuestions(String search,
                                                           QuestionDifficulty difficulty,
                                                           Boolean isPublic,
                                                           UUID userId,
                                                           Integer pageNo,
                                                           Integer pageSize);
    Page<QtypeCodeQuestion> findAllOrgAdminQtypeCodeQuestions(UUID orgId,
                                                            String search,
                                                           QuestionDifficulty difficulty,
                                                           Boolean isPublic,
                                                           UUID userId,
                                                           Integer pageNo,
                                                           Integer pageSize);
}
