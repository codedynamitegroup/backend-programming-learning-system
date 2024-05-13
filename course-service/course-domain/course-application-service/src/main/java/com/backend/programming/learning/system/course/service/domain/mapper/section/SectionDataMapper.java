package com.backend.programming.learning.system.course.service.domain.mapper.section;

import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.create.section.CreateSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.query.section.QueryAllSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionCommand;
import com.backend.programming.learning.system.course.service.domain.dto.method.update.section.UpdateSectionResponse;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.SectionModel;
import com.backend.programming.learning.system.course.service.domain.dto.responseentity.section.SectionResponseEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.SectionId;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SectionDataMapper {
    public Section sectionModelToSection(SectionModel sectionModel, Course course) {
        return Section.builder()
                .name(sectionModel.getName())
                .visible(sectionModel.getVisible())
                .sectionMoodleId(Integer.valueOf(sectionModel.getId()))
                .courseId(course.getId())
                .build();
    }

    public void setSection(Section previousSection, SectionModel sectionModel) {
        previousSection.setName(sectionModel.getName());
        previousSection.setVisible(sectionModel.getVisible());
    }

    public Section createSectionCommandToSection(CreateSectionCommand createSectionCommand) {
        return Section.builder()
                .name(createSectionCommand.getName())
                .visible(createSectionCommand.getVisible())
                .courseId(new CourseId(createSectionCommand.getCourseId()))
                .build();
    }


    public CreateSectionResponse sectionToCreateSectionResponse(Section section,String message) {
        return CreateSectionResponse.builder()
                .courseId(section.getCourseId().getValue())
                .sectionId(section.getId().getValue())
                .name(section.getName())
                .message(message)
                .build();
    }

    public SectionResponseEntity sectionToSectionResponseEntity(Section section) {
        return SectionResponseEntity.builder()
                .sectionId(section.getId().getValue())
                .name(section.getName())
                .visible(section.getVisible())
                .build();

    }
    public QueryAllSectionResponse sectionsToQueryAllSectionResponse(List<Section> sections) {
        return QueryAllSectionResponse.builder()
                .sections(sections.stream().map(this::sectionToSectionResponseEntity).toList())
                .courseId(sections.get(0).getCourseId().getValue())
                .build();
    }

    public UpdateSectionResponse sectionToUpdateSectionResponse(Section updatedSection, String sectionIsUpdatedSuccessfully) {
        return UpdateSectionResponse.builder()
                .sectionId(updatedSection.getId().getValue())
                .name(updatedSection.getName())
                .message(sectionIsUpdatedSuccessfully)
                .build();
    }
}
