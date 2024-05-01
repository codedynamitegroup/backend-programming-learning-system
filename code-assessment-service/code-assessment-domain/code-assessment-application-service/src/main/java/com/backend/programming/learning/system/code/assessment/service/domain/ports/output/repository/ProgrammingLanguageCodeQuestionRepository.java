package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguageCodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;

import java.util.Optional;

public interface ProgrammingLanguageCodeQuestionRepository {
    Optional<ProgrammingLanguageCodeQuestion> findById(ProgrammingLanguageCodeQuestionId id);
}
