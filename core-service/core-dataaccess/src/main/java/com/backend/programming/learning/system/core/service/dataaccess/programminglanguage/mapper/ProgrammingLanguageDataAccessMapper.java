package com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.mapper;

import com.backend.programming.learning.system.core.service.dataaccess.programminglanguage.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingLanguageDataAccessMapper {
    public ProgrammingLanguageEntity programmingLanguageToProgrammingLanguageEntity(
            ProgrammingLanguage programmingLanguage) {
        return ProgrammingLanguageEntity.builder()
                .id(programmingLanguage.getId().getValue())
                .name(programmingLanguage.getName())
                .compilerApiId(programmingLanguage.getCompilerApiId())
                .timeLimit(programmingLanguage.getTimeLimit())
                .memoryLimit(programmingLanguage.getMemoryLimit())
                .build();
    }

    public ProgrammingLanguage programmingLanguageEntityToProgrammingLanguage(
            ProgrammingLanguageEntity programmingLanguageEntity) {
        return ProgrammingLanguage.builder()
                .id(new ProgrammingLanguageId(programmingLanguageEntity.getId()))
                .name(programmingLanguageEntity.getName())
                .compilerApiId(programmingLanguageEntity.getCompilerApiId())
                .timeLimit(programmingLanguageEntity.getTimeLimit())
                .memoryLimit(programmingLanguageEntity.getMemoryLimit())
                .build();
    }
}
