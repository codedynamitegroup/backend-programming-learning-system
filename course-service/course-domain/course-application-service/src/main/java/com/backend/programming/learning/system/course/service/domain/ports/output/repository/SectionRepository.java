package com.backend.programming.learning.system.course.service.domain.ports.output.repository;

import com.backend.programming.learning.system.course.service.domain.entity.Section;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SectionRepository {
    Section save(Section section);

    Section findById(UUID sectionId);

    List<Section> findByCourseId(UUID courseId);
    void deleteById(UUID sectionId);
}
