package com.backend.programming.learning.system.core.service.dataaccess.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.AnswerOfQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNullApi;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnswerOfQuestionJpaRepository extends JpaRepository<AnswerOfQuestionEntity, UUID> {
//    @Transactional

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM AnswerOfQuestionEntity a WHERE a.questionId = :questionId")
    void deleteByQuestionId(UUID questionId);
    Optional<AnswerOfQuestionEntity> findById(UUID id);
}
