package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguageCodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProgrammingLanguageCodeQuestionRepository {
    Optional<ProgrammingLanguageCodeQuestion> findById(ProgrammingLanguageCodeQuestionId id);

    List<ProgrammingLanguageCodeQuestion> findByCodeQuestionId(CodeQuestionId id);
}
