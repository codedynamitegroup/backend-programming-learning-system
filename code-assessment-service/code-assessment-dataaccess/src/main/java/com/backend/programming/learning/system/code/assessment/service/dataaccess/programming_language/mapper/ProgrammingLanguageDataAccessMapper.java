package com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.mapper;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.programming_language.entity.ProgrammingLanguageEntity;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingLanguageDataAccessMapper {
    public ProgrammingLanguage entityToProgramingLanguage(ProgrammingLanguageEntity entity) {
        return ProgrammingLanguage.builder()
                .id(new ProgrammingLanguageId(entity.getId()))
                .judge0_compilerApiId(entity.getCompilerApiId())
                .name(entity.getName())
                .timeLimit(entity.getTimeLimit())
                .memoryLimit(entity.getMemoryLimit())
                .isActive(entity.getIsActived())
                .headCode(entity.getHeadCode())
                .bodyCode(entity.getBodyCode())
                .tailCode(entity.getTailCode())
                .copyState(entity.getCopyState())
                .build();
    }

    public ProgrammingLanguageEntity programmingLanguageToEntity(ProgrammingLanguage programmingLanguage) {
        return ProgrammingLanguageEntity.builder()
                .id(programmingLanguage.getId().getValue())
                .compilerApiId(programmingLanguage.getJudge0_compilerApiId())
                .name(programmingLanguage.getName())
                .isActived(programmingLanguage.getIsActive())
                .memoryLimit(programmingLanguage.getMemoryLimit())
                .timeLimit(programmingLanguage.getMemoryLimit())
                .copyState(programmingLanguage.getCopyState())
                .headCode(programmingLanguage.getHeadCode())
                .bodyCode(programmingLanguage.getBodyCode())
                .tailCode(programmingLanguage.getTailCode())
                .build();
    }
}
