package com.backend.programming.learning.system.course.service.domain.implement.service.section;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.section.DeleteSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.delete.section.DeleteSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.section.QueryAllSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionResponse;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.mapper.section.SectionDataMapper;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class SectionCommandHandler {
    private final SectionDeleteHelper sectionDeleteHelper;
    private final SectionQueryHelper sectionQueryHelper;
    private final SectionCreateHelper sectionCreateHelper;
    private final SectionUpdateHelper sectionUpdateHelper;

    private final SectionDataMapper sectionDataMapper;

    private final SectionRepository sectionRepository;


    @Transactional
    public CreateSectionResponse createSection(CreateSectionCommand createSectionCommand) {
        Section section=sectionCreateHelper.createSection(createSectionCommand);
        return sectionDataMapper.sectionToCreateSectionResponse(section,"Section is created successfully");
    }
    @Transactional(readOnly = true)
    public QueryAllSectionResponse queryAllByCourseId(UUID courseId) {
        List<Section> sections=sectionQueryHelper.queryAllByCourseId(courseId);
        return sectionDataMapper.sectionsToQueryAllSectionResponse(sections);
    }

    @Transactional
    public DeleteSectionResponse deleteSection(DeleteSectionCommand deleteSectionCommand) {
        sectionDeleteHelper.deleteSection(deleteSectionCommand.getSectionId());
        return DeleteSectionResponse.builder().message("Section is deleted successfully").build();
    }

    @Transactional
    public UpdateSectionResponse updateSection(UUID sectionId,UpdateSectionCommand updateSectionCommand) {
        Section updatedSection=sectionUpdateHelper.updateSection(sectionId,updateSectionCommand);
        return sectionDataMapper.sectionToUpdateSectionResponse(updatedSection,"Section is updated successfully");
    }
}
