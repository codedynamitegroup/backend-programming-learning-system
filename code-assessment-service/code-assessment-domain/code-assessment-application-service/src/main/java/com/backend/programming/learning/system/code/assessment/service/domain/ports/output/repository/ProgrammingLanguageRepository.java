package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.CodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Langauge;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.LanguageId;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;

import java.util.Optional;

public interface ProgrammingLanguageRepository {
    Optional<Langauge> findById(LanguageId languageId);

}
