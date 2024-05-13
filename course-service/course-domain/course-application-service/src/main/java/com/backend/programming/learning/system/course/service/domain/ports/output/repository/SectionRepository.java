package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SectionRepository {
    Section save(Section section);

    Section findById(UUID sectionId);

    Optional<Section> findBySectionMoodleId(Integer sectionMoodleId);

    void deleteById(UUID sectionId);

    void deleteBySectionMoodleId(Integer sectionMoodleId);

    List<Section> findByCourseId(CourseId courseId);

}
