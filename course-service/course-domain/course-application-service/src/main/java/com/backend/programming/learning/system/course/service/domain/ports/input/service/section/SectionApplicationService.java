package com.backend.programming.learning.system.course.service.domain.ports.input.service.section;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.section.DeleteSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.section.DeleteSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.section.QueryAllSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.section.QuerySectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionResponse;
import jakarta.validation.Valid;

import java.util.UUID;

public interface SectionApplicationService {

    CreateSectionResponse createSection(@Valid CreateSectionCommand createSectionCommand);

    QueryAllSectionResponse queryAllSections(@Valid QuerySectionCommand querySectionCommand);

    DeleteSectionResponse deleteSection(@Valid DeleteSectionCommand deleteSectionCommand);

    UpdateSectionResponse updateSection(@Valid UUID sectionId, @Valid UpdateSectionCommand updateSectionCommand);
}
