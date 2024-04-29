package com.backend.programming.learning.system.code.assessment.service.dataaccess.language.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.mapper.ProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.repository.ProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Langauge;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.ProgrammingLanguageRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.LanguageId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ProgrammingLanguageRepositoryImpl implements ProgrammingLanguageRepository {
    private final ProgrammingLanguageDataAccessMapper dataAccessMapper;
    private final ProgrammingLanguageJpaRepository jpaRepository;

    public ProgrammingLanguageRepositoryImpl(ProgrammingLanguageDataAccessMapper dataAccessMapper, ProgrammingLanguageJpaRepository jpaRepository) {
        this.dataAccessMapper = dataAccessMapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Langauge> findById(LanguageId languageId) {
        return jpaRepository.findById(languageId.getValue()).map(dataAccessMapper::entityToProgramingLanguage);
    }
}
