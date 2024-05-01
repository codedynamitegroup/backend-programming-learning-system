package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.adapter;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.entity.ProgrammingLanguageCodeQuestionEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.mapper.ProgrammingLanguageCodeQuestionDataAccessMapper;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language_code_question.repository.ProgrammingLanguageCodeQuestionJpaRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguageCodeQuestion;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.ProgrammingLanguageCodeQuestionRepository;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.programming_language_code_question.ProgrammingLanguageCodeQuestionId;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProgrammingLanguageCodeQuestionRepositoryImpl implements ProgrammingLanguageCodeQuestionRepository {
    private final ProgrammingLanguageCodeQuestionDataAccessMapper dataAccessMapper;
    private final ProgrammingLanguageCodeQuestionJpaRepository jpaRepository;

    public ProgrammingLanguageCodeQuestionRepositoryImpl(ProgrammingLanguageCodeQuestionDataAccessMapper dataAccessMapper, ProgrammingLanguageCodeQuestionJpaRepository jpaRepository) {
        this.dataAccessMapper = dataAccessMapper;
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<ProgrammingLanguageCodeQuestion> findById(ProgrammingLanguageCodeQuestionId id) {
        Optional<ProgrammingLanguageCodeQuestionEntity> entity
                = jpaRepository.findById(dataAccessMapper.idToEntityId(id));
        return entity.map(dataAccessMapper::entityToDomainObject);
    }
}
