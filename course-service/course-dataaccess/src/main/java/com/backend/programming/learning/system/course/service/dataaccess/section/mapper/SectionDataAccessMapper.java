package com.backend.programming.learning.system.course.service.dataaccess.section.mapper;

import com.backend.programming.learning.system.course.service.dataaccess.course.entity.CourseEntity;
import com.backend.programming.learning.system.course.service.dataaccess.course.mapper.CourseDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.section.entity.SectionEntity;
import com.backend.programming.learning.system.course.service.domain.entity.Course;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import com.backend.programming.learning.system.course.service.domain.valueobject.SectionId;
import com.backend.programming.learning.system.domain.valueobject.UserId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SectionDataAccessMapper {

    private final CourseDataAccessMapper courseDataAccessMapper;

    public SectionDataAccessMapper(CourseDataAccessMapper courseDataAccessMapper) {
        this.courseDataAccessMapper = courseDataAccessMapper;
    }

    public SectionEntity sectionToSectionEntity(Section section) {
        CourseEntity course = CourseEntity.builder().id(section.getCourseId().getValue()).build();
        return SectionEntity.builder()
                .id(section.getId().getValue())
                .sectionMoodleId(section.getSectionMoodleId())
                .course(course)
                .visible(section.getVisible())
                .name(section.getName())
                .build();
    }

    public Section sectionEntityToSection(SectionEntity sectionEntity) {
        return Section.builder()
                .id(new SectionId(sectionEntity.getId()))
                .name(sectionEntity.getName())
                .sectionMoodleId(sectionEntity.getSectionMoodleId())
                .courseId(new CourseId(sectionEntity.getCourse().getId()))
                .visible(sectionEntity.getVisible())
                .build();

    }

    public List<Section> sectionEntityListToSectionList(List<SectionEntity> sectionEntityList) {
        return sectionEntityList.stream().map(this::sectionEntityToSection).toList();
    }
}
