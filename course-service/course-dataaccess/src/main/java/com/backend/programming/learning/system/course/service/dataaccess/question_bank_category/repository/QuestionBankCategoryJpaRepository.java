package com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.repository;

import com.backend.programming.learning.system.course.service.dataaccess.question_bank_category.entity.QuestionBankCategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionBankCategoryJpaRepository extends JpaRepository<QuestionBankCategoryEntity, UUID> {
    Optional<QuestionBankCategoryEntity> findById(UUID id);

    @Query("SELECT q FROM QuestionBankCategoryEntity q WHERE q.name LIKE %:search% AND q.isOrgQuestionBank = :isOrgQuestionBank")
    Page<QuestionBankCategoryEntity> findAll(Boolean isOrgQuestionBank, String search, Pageable pageable);
}
