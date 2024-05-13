package com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository;

import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;

import java.util.List;
import java.util.Optional;

public interface ProgrammingLanguageRepository {
    Optional<ProgrammingLanguage> findById(ProgrammingLanguageId languageId);

    void save(ProgrammingLanguage programmingLanguage);

    List<ProgrammingLanguage> findAll();

    void deleteById(ProgrammingLanguageId id);
}
