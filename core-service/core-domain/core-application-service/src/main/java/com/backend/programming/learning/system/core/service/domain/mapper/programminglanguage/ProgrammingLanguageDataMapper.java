package com.backend.programming.learning.system.core.service.domain.mapper.programminglanguage;

import com.backend.programming.learning.system.core.service.domain.dto.responseentity.programminglanguage.ProgrammingLanguageResponseEntity;
import com.backend.programming.learning.system.core.service.domain.entity.ProgrammingLanguage;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProgrammingLanguageDataMapper {

    public ProgrammingLanguageResponseEntity programmingLanguageToQueryProgrammingLanguageResponse(
            ProgrammingLanguage programmingLanguage) {
        return ProgrammingLanguageResponseEntity.builder()
                .programmingLanguageId(programmingLanguage.getId().getValue())
                .name(programmingLanguage.getName())
                .compilerApiId(programmingLanguage.getCompilerApiId())
                .timeLimit(programmingLanguage.getTimeLimit())
                .memoryLimit(programmingLanguage.getMemoryLimit())
                .build();
    }

    public List<ProgrammingLanguageResponseEntity> programmingLanguagesToQueryProgrammingLanguageResponses(
            List<ProgrammingLanguage> programmingLanguages) {
        return programmingLanguages.stream()
                .map(this::programmingLanguageToQueryProgrammingLanguageResponse)
                .collect(Collectors.toList());
    }

}
