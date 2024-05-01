package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLangauge;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;

import java.util.Optional;

public interface ProgrammingLanguageRepository {
    Optional<ProgrammingLangauge> findById(ProgrammingLanguageId languageId);

}
