package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.category_bank.CodeQuestionCategoryBankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CodeQuestionCategoryBankJpaRepository extends JpaRepository<CodeQuestionCategoryBankEntity, UUID> {
}
