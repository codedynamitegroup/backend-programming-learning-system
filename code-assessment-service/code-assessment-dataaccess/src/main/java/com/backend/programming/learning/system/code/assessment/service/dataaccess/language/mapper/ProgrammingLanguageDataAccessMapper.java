package com.backend.programming.learning.system.code.assessment.service.dataaccess.language.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLangauge;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingLanguageDataAccessMapper {
    public ProgrammingLangauge entityToProgramingLanguage(ProgrammingLanguageEntity entity) {
        return ProgrammingLangauge.builder()
                .id(new ProgrammingLanguageId(entity.getId()))
                .judge0_compilerApiId(entity.getCompilerApiId())
                .timeLimit(entity.getTimeLimit())
                .memoryLimit(entity.getMemoryLimit())
                .isActive(entity.getIsActived())
                .copyState(entity.getCopyState())
                .build();
    }
}
