package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.mapper.ProgrammingLanguageDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.repository.ProgrammingLanguageJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity.ProgrammingLanguageCodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.repository.ProgrammingLanguageCodeQuestionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.ProgrammingLanguageRepository;
import com.backend.programming.learning.system.domain.valueobject.CodeQuestionId;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class ProgrammingLanguageRepositoryImpl implements ProgrammingLanguageRepository {
    private final ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper;
    private final ProgrammingLanguageJpaRepository programmingLanguageJpaRepository;
    private final ProgrammingLanguageCodeQuestionJpaRepository programmingLanguageCodeQuestionJpaRepository;

    public ProgrammingLanguageRepositoryImpl(ProgrammingLanguageDataAccessMapper programmingLanguageDataAccessMapper, ProgrammingLanguageJpaRepository programmingLanguageJpaRepository, ProgrammingLanguageCodeQuestionJpaRepository programmingLanguageCodeQuestionJpaRepository) {
        this.programmingLanguageDataAccessMapper = programmingLanguageDataAccessMapper;
        this.programmingLanguageJpaRepository = programmingLanguageJpaRepository;
        this.programmingLanguageCodeQuestionJpaRepository = programmingLanguageCodeQuestionJpaRepository;
    }

    @Override
    public Optional<ProgrammingLanguage> findById(ProgrammingLanguageId languageId) {
        return programmingLanguageJpaRepository.findById(languageId.getValue()).map(programmingLanguageDataAccessMapper::entityToProgramingLanguage);
    }

    @Override
    public void save(ProgrammingLanguage programmingLanguage) {
        ProgrammingLanguageEntity programmingLanguageEntity = programmingLanguageDataAccessMapper.programmingLanguageToEntity(programmingLanguage);
        programmingLanguageJpaRepository.save(programmingLanguageEntity);
    }

    @Override
    public List<ProgrammingLanguage> findAll(Boolean active) {
        List<ProgrammingLanguageEntity> entities = List.of();
        if(active == null)
            entities = programmingLanguageJpaRepository
                    .findAllByOrderByNameAsc();
        else{
            entities = programmingLanguageJpaRepository.findAllByIsActivedOrderByNameAsc(active);
        }
        return entities.stream()
                .map(programmingLanguageDataAccessMapper::entityToProgramingLanguage).toList();
    }

    @Override
    public void deleteById(ProgrammingLanguageId id) {
        programmingLanguageJpaRepository.deleteById(id.getValue());
    }

    @Override
    public List<ProgrammingLanguage> findByCodeQuestionId(CodeQuestionId id) {
        List<ProgrammingLanguageCodeQuestionEntity> plcqe = programmingLanguageCodeQuestionJpaRepository.findByCodeQuestionId(id.getValue());
        return plcqe.stream()
                .map(ProgrammingLanguageCodeQuestionEntity::getProgrammingLanguage)
                .map(programmingLanguageDataAccessMapper::entityToProgramingLanguage)
                .toList();
    }
}
