package com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.adapter;

import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.mapper.ProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.repository.ProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.core.service.dataaccess.review.mapper.ReviewDataAccessMapper;
import com.backend.programming.learning.system.core.service.dataaccess.review.repository.ReviewJpaRepository;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.core.service.domain.entity.Review;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ProgrammingLanguageRepository;
import com.backend.programming.learning.system.core.service.domain.ports.output.repository.ReviewRepository;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

import java.util.Optional;

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
}
