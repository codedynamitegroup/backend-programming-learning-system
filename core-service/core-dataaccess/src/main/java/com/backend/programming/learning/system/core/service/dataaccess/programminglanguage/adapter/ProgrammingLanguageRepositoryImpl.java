package com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.mapper.ProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.repository.ProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ProgrammingLanguageRepository;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProgrammingLanguageRepositoryImpl implements ProgrammingLanguageRepository {
    private final ProgrammingLanguageJpaRepository programmingLanguageJpaRepository;
    private final ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper;

    public ProgrammingLanguageRepositoryImpl(ProgrammingLanguageJpaRepository programmingLanguageJpaRepository,
                                             ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper) {
        this.programmingLanguageJpaRepository = programmingLanguageJpaRepository;
        this.programmingLanguageDataAccessMapper = programmingLanguageDataAccessMapper;
    }

    @Override
    public ProgrammingLanguage saveProgrammingLanguage(ProgrammingLanguage programmingLanguage) {
        return programmingLanguageDataAccessMapper.programmingLanguageEntityToProgrammingLanguage(
                programmingLanguageJpaRepository.save(
                        programmingLanguageDataAccessMapper.
                                programmingLanguageToProgrammingLanguageEntity(programmingLanguage)
                )
        );
    }

    @Override
    public Optional<ProgrammingLanguage> findById(ProgrammingLanguageId programmingLanguageId) {
        return programmingLanguageJpaRepository.findById(programmingLanguageId.getValue())
                .map(programmingLanguageDataAccessMapper::programmingLanguageEntityToProgrammingLanguage);
    }

    @Override
    public Page<ProgrammingLanguage> findAllWithSearch(String search, Integer pageNo, Integer pageSize, List<UUID> selectedProgrammingLanguages) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        return programmingLanguageJpaRepository.findAllWithSearch(search, selectedProgrammingLanguages, paging)
                .map(programmingLanguageDataAccessMapper::programmingLanguageEntityToProgrammingLanguage);
    }

    @Override
    public Page<ProgrammingLanguage> findAllWithSearchById(
            String search,
            Integer pageNo,
            Integer pageSize,
            List<UUID> selectedProgrammingLanguageIds) {
        Pageable paging = PageRequest.of(pageNo, pageSize);

        return programmingLanguageJpaRepository.findAllWithSearchById(search, selectedProgrammingLanguageIds, paging)
                .map(programmingLanguageDataAccessMapper::programmingLanguageEntityToProgrammingLanguage);
    }
}
