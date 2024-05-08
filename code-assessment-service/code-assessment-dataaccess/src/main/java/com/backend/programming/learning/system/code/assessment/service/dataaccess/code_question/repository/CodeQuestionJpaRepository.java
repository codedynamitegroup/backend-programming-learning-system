package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.CodeQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeQuestionJpaRepository extends JpaRepository<CodeQuestionEntity, UUID> {
    Optional<CodeQuestionEntity> findByQuestionId(UUID questionId);
}
