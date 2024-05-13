package com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.programming_language.CreateProgammingLanguageCommand;
import jakarta.validation.Valid;

import java.util.List;

public interface ProgrammingLanguageApplicationService {
    void createProgrammingLanguage(@Valid CreateProgammingLanguageCommand command);

    List<ProgrammingLanguageDto> getLanguage();
}
