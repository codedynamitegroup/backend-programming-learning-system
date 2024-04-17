package com.backend.programming.learning.system.core.service.dataaccess.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, UUID> {
    Optional<QuestionEntity> findById(UUID id);

    @Query("SELECT q.qtype FROM QuestionEntity q WHERE q.id = :id")
    String getQtype(UUID id);
}
