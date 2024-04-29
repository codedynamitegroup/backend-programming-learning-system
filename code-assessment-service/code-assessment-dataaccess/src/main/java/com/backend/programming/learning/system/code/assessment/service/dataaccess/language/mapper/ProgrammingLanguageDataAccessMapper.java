package com.backend.programming.learning.system.code.assessment.service.dataaccess.language.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.Langauge;
import com.backend.programming.learning.system.code.assessment.service.domain.valueobject.LanguageId;
import com.backend.programming.learning.system.domain.valueobject.CopyState;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingLanguageDataAccessMapper {
    public Langauge entityToProgramingLanguage(ProgrammingLanguageEntity entity) {
        return Langauge.builder()
                .id(new LanguageId(entity.getId()))
                .judge0_compilerApiId(entity.getCompilerApiId())
                .timeLimit(entity.getTimeLimit())
                .memoryLimit(entity.getMemoryLimit())
                .isActive(entity.getIsActived())
                .copyState(CopyState.valueOf(entity.getCopyState()))
                .build();
    }
}
