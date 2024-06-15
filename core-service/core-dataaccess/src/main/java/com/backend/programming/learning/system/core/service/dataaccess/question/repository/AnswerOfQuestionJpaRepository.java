package com.backend.programming.learning.system.core.service.dataaccess.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.AnswerOfQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnswerOfQuestionJpaRepository extends JpaRepository<AnswerOfQuestionEntity, UUID> {
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM AnswerOfQuestionEntity a WHERE a.questionId = :questionId")
    void deleteByQuestionId(UUID questionId);
    Optional<AnswerOfQuestionEntity> findById(UUID id);

    List<AnswerOfQuestionEntity> findAllByQuestionId(UUID questionId);

    @Modifying
    @Query(value = "DELETE FROM AnswerOfQuestionEntity a WHERE a.id IN :ids")
    void deleteAllByIdInQuery(@Param("ids") List<UUID> ids);
}
