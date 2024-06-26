package com.backend.programming.learning.system.core.service.dataaccess.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeMultichoiceQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QtypeMultichoiceQuestionJpaRepository extends JpaRepository<QtypeMultichoiceQuestionEntity, UUID>{
    @Query("SELECT q.id FROM QtypeMultichoiceQuestionEntity q WHERE q.question.id = :questionId")
    UUID getId(UUID questionId);
    Optional<QtypeMultichoiceQuestionEntity> findByQuestionId(UUID questionId);
}
