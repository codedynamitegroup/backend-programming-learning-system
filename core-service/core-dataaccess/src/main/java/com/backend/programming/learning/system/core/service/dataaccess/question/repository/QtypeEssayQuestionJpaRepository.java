package com.backend.programming.learning.system.core.service.dataaccess.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeEssayQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QtypeEssayQuestionJpaRepository extends JpaRepository<QtypeEssayQuestionEntity, UUID> {
    @Query("SELECT q.id FROM QtypeEssayQuestionEntity q WHERE q.question.id = :questionId")
    UUID getId(UUID questionId);
    Optional<QtypeEssayQuestionEntity> findByQuestionId(UUID questionId);
}
