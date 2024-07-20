package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SectionRepository {
    Section save(Section section);

    Optional<Section> findById(UUID sectionId);

    Optional<Section> findBySectionMoodleIdAndCourseId(Integer sectionMoodleId,UUID courseId);

    void deleteById(UUID sectionId);

    void deleteBySectionMoodleIdAndCourseId(Integer sectionMoodleId,UUID courseId);

    List<Section> findByCourseId(CourseId courseId);

}
