package com.backend.programming.learning.system.code.assessment.service.dataaccess.language.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.mapper.ProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.repository.ProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.ProgrammingLanguageRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
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
    public Optional<ProgrammingLanguage> findById(ProgrammingLanguageId languageId) {
        return jpaRepository.findById(languageId.getValue()).map(dataAccessMapper::entityToProgramingLanguage);
    }

    @Override
    public void save(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguageEntity programmingLanguageEntity = dataAccessMapper.programmingLanguageToEntity(programmingLanguage);
        jpaRepository.save(programmingLanguageEntity);
    }

    @Override
    public List<ProgrammingLanguage> findAll() {
        return jpaRepository.findAll().stream().map(dataAccessMapper::entityToProgramingLanguage).toList();
    }
}
