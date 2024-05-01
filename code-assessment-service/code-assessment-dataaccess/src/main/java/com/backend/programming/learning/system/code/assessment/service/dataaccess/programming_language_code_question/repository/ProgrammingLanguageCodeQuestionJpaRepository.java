package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity.ProgrammingLanguageCodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity.ProgrammingLanguageCodeQuestionEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProgrammingLanguageCodeQuestionJpaRepository
        extends JpaRepository<ProgrammingLanguageCodeQuestionEntity, ProgrammingLanguageCodeQuestionEntityId> {
}
