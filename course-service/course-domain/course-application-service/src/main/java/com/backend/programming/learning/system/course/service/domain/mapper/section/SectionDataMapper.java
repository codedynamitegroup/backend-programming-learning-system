package com.backend.programming.learning.system.course.service.domain.mapper.section;

import com.backend.programming.learning.system.course.service.domain.dto.responseentity.moodle.section.SectionModel;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.valueobject.SectionId;
import org.springframework.stereotype.Component;

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

    public Section setSection(Section previousSection, SectionModel sectionModel) {
        return Section.builder()
                .name(sectionModel.getName())
                .visible(sectionModel.getVisible())
                .build();
    }
}
