package com.backend.programming.learning.system.code.assessment.service.domain.mapper.programming_language;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.programming_language.CreateProgammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguage;
import org.springframework.stereotype.Component;

@Component
public class ProgrammingLanguageDataMapper {
    public ProgrammingLanguage createProgammingLanguageCommandToProgrammingLangauge(CreateProgammingLanguageCommand command) {
        return ProgrammingLanguage.builder()
                .name(command.getName())
                .judge0_compilerApiId(command.getLanguageJudge0Id())
                .isActive(command.getIsActived())
                .timeLimit(command.getTimeLimit())
                .memoryLimit(command.getMemoryLimit())
                .build();
    }
}
