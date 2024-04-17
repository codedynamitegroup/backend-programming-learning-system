package com.backend.programming.learning.system.core.service.dataaccess.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.QtypeShortanswerQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface QtypeShortanswerQuestionJpaRepository extends JpaRepository<QtypeShortanswerQuestionEntity, UUID>{
    @Query("SELECT q.id FROM QtypeShortanswerQuestionEntity q WHERE q.question.id = :questionId")
    UUID getId(UUID questionId);
}
