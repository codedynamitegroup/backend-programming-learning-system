package com.backend.programming.learning.system.course.service.dataaccess.question_bank.repository;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank.entity.QuestionBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface QuestionBankJpaRepository extends JpaRepository<QuestionBankEntity, UUID> {
    Optional<QuestionBankEntity> findById(UUID id);
}
