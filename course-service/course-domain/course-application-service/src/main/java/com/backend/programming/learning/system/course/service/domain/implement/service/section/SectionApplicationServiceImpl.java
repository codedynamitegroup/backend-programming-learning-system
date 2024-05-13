package com.backend.programming.learning.system.course.service.domain.implement.service.section;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.section.DeleteSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.section.DeleteSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.section.QueryAllSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.section.QuerySectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionResponse;
import com.backend.programming.learning.system.course.service.domain.ports.input.service.section.SectionApplicationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@Slf4j
@RequiredArgsConstructor
public class SectionApplicationServiceImpl implements SectionApplicationService {
    private final SectionCommandHandler sectionCommandHandler;


    @Override
    public CreateSectionResponse createSection(CreateSectionCommand createSectionCommand) {
        return sectionCommandHandler.createSection(createSectionCommand);
    }

    @Override
    public QueryAllSectionResponse queryAllSections(QuerySectionCommand querySectionCommand) {
        return sectionCommandHandler.queryAllByCourseId(querySectionCommand.getCourseId());
    }

    @Override
    public DeleteSectionResponse deleteSection(DeleteSectionCommand deleteSectionCommand) {
        return sectionCommandHandler.deleteSection(deleteSectionCommand);
    }

    @Override
    public UpdateSectionResponse updateSection(UUID sectionId, UpdateSectionCommand updateSectionCommand) {
        return sectionCommandHandler.updateSection(sectionId,updateSectionCommand);
    }
}
