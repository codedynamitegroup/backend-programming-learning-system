package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.programming_language;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.DtoMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.programming_language.CreateProgammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.programming_language.DeleteProgrammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.programming_language.UpdateProgrammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.programming_language.ProgrammingLanguageDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProgrammingLanguageHandler {
    final ProgrammingLanguageHelper programmingLanguageHelper;
    final ProgrammingLanguageDataMapper programmingLanguageDataMapper;
    final DtoMapper dtoMapper;

    public ProgrammingLanguageHandler(ProgrammingLanguageHelper programmingLanguageHelper, ProgrammingLanguageDataMapper programmingLanguageDataMapper, DtoMapper dtoMapper) {
        this.programmingLanguageHelper = programmingLanguageHelper;
        this.programmingLanguageDataMapper = programmingLanguageDataMapper;
        this.dtoMapper = dtoMapper;
    }

    public void createProgrammingLanguage(CreateProgammingLanguageCommand command) {
        programmingLanguageHelper.createProgrammingLanguage(command);
    }

    public List<ProgrammingLanguageDto> getLanguage() {
        List<ProgrammingLanguage> programmingLanguages = programmingLanguageHelper.getLanguage();
        return programmingLanguages.stream().map(dtoMapper::programmingLanguageToDto).toList();
    }

    public void deleteLanguage(DeleteProgrammingLanguageCommand command) {
        programmingLanguageHelper.deleteLanguage(command);
    }

    public void updateLanguage(UpdateProgrammingLanguageCommand command) {
        programmingLanguageHelper.updateLanguage(command);
    }
}
