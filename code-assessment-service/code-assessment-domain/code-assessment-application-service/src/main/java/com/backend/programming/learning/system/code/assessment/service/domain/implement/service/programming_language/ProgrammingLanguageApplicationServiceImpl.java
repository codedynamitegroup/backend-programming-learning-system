package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.programming_language;

import com.backend.programming.learning.system.code.assessment.service.domain.dto.entity.ProgrammingLanguageDto;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.programming_language.CreateProgammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.programming_language.DeleteProgrammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.programming_language.UpdateProgrammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.input.service.ProgrammingLanguageApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Validated
@Service
@Slf4j
public class ProgrammingLanguageApplicationServiceImpl implements ProgrammingLanguageApplicationService {
    final ProgrammingLanguageHandler programmingLanguageHandler;

    public ProgrammingLanguageApplicationServiceImpl(ProgrammingLanguageHandler programmingLanguageHandler) {
        this.programmingLanguageHandler = programmingLanguageHandler;
    }

    @Override
    public void createProgrammingLanguage(CreateProgammingLanguageCommand command) {
        programmingLanguageHandler.createProgrammingLanguage(command);
    }

    @Override
    public List<ProgrammingLanguageDto> getLanguage(Boolean active) {
        return programmingLanguageHandler.getLanguage(active);
    }

    @Override
    public void deleteLanguage(DeleteProgrammingLanguageCommand command) {
        programmingLanguageHandler.deleteLanguage(command);
    }

    @Override
    public void updateLanguage(UpdateProgrammingLanguageCommand command) {
        programmingLanguageHandler.updateLanguage(command);
    }
}
