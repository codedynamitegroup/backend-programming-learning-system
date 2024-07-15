package com.backend.programming.learning.system.core.service.domain.ports.output.repository;

import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ProgrammingLanguageRepository {
    ProgrammingLanguage saveProgrammingLanguage(ProgrammingLanguage programmingLanguage);

    Optional<ProgrammingLanguage> findById(ProgrammingLanguageId programmingLanguageId);

    Page<ProgrammingLanguage> findAllWithSearch(String search, Integer pageNo, Integer pageSize);
}
