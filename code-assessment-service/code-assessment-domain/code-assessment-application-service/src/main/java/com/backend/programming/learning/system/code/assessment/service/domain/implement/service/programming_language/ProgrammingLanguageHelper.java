package com.backend.programming.learning.system.code.assessment.service.domain.implement.service.programming_language;


import com.backend.programming.learning.system.code.assessment.service.domain.CodeAssessmentDomainService;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.create.programming_language.CreateProgammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.delete.programming_language.DeleteProgrammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.dto.method.update.programming_language.UpdateProgrammingLanguageCommand;
import com.backend.programming.learning.system.code.assessment.service.domain.entity.ProgrammingLanguage;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.GenericHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.implement.service.ValidateHelper;
import com.backend.programming.learning.system.code.assessment.service.domain.mapper.programming_language.ProgrammingLanguageDataMapper;
import com.backend.programming.learning.system.code.assessment.service.domain.ports.output.repository.ProgrammingLanguageRepository;
import com.backend.programming.learning.system.domain.valueobject.ProgrammingLanguageId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Component
public class ProgrammingLanguageHelper {
    final ProgrammingLanguageRepository programmingLanguageRepository;
    final ProgrammingLanguageDataMapper programmingLanguageDataMapper;
    final CodeAssessmentDomainService codeAssessmentDomainService;
    final GenericHelper genericHelper;
    final ValidateHelper validateHelper;

    public ProgrammingLanguageHelper(ProgrammingLanguageRepository programmingLanguageRepository, ProgrammingLanguageDataMapper programmingLanguageDataMapper, CodeAssessmentDomainService codeAssessmentDomainService, GenericHelper genericHelper, ValidateHelper validateHelper) {
        this.programmingLanguageRepository = programmingLanguageRepository;
        this.programmingLanguageDataMapper = programmingLanguageDataMapper;
        this.codeAssessmentDomainService = codeAssessmentDomainService;
        this.genericHelper = genericHelper;
        this.validateHelper = validateHelper;
    }

    public void createProgrammingLanguage(CreateProgammingLanguageCommand command) {
        ProgrammingLanguage programmingLanguage = programmingLanguageDataMapper.createProgammingLanguageCommandToProgrammingLangauge(command);
        codeAssessmentDomainService.inititateProgrammingLanguage(programmingLanguage);
        programmingLanguageRepository.save(programmingLanguage);
    }

    public List<ProgrammingLanguage> getLanguage() {
        return programmingLanguageRepository.findAll();
    }

    @Transactional
    public void deleteLanguage(DeleteProgrammingLanguageCommand command) {
        ProgrammingLanguage pl = validateHelper.validateProgrammingLanguage(new ProgrammingLanguageId(command.getLanguageId()));
        programmingLanguageRepository.deleteById(pl.getId());
    }

    @Transactional
    public void updateLanguage(UpdateProgrammingLanguageCommand command) {
        ProgrammingLanguage pl = validateHelper.validateProgrammingLanguage(new ProgrammingLanguageId(command.getLanguageId()));
        ProgrammingLanguage plUpdated = programmingLanguageDataMapper.updateProgrammingLanguageCommandToProgrammingLangauge(command);
        genericHelper.mapRepositoryAttributeToUpdateAttribute(pl, plUpdated, ProgrammingLanguage.class);
        programmingLanguageRepository.save(pl);
    }
}
