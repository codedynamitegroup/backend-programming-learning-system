package com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag.CodeQuestionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.code_question.entity.tag.CodeQuestionTagEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeQuestionTagJpaRepository extends JpaRepository<CodeQuestionTagEntity, CodeQuestionTagEntityId> {
}
