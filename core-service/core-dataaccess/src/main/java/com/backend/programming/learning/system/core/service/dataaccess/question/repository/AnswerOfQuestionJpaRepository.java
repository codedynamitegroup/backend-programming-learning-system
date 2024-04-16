package com.backend.programming.learning.system.core.service.dataaccess.question.repository;

import com.backend.programming.learning.system.core.service.dataaccess.question.entity.AnswerOfQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AnswerOfQuestionJpaRepository extends JpaRepository<AnswerOfQuestionEntity, UUID> {
}
