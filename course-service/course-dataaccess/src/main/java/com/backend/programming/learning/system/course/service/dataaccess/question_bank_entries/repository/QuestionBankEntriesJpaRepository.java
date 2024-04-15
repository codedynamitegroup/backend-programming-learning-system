package com.backend.programming.learning.system.course.service.dataaccess.question_bank_entries.repository;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank_entries.entity.QuestionBankEntriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface QuestionBankEntriesJpaRepository extends JpaRepository<QuestionBankEntriesEntity, UUID> {
    Optional<QuestionBankEntriesEntity> findById(UUID id);
}
