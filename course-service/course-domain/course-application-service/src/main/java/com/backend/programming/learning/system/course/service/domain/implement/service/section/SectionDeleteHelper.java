package com.backend.programming.learning.system.course.service.domain.implement.service.section;

import com.backend.programming.learning.system.course.service.domain.entity.Module;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.exception.CourseDomainException;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.ModuleRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class SectionDeleteHelper {
    private final SectionRepository sectionRepository;
    private final ModuleRepository moduleRepository;

    public SectionDeleteHelper(SectionRepository sectionRepository, ModuleRepository moduleRepository) {
        this.sectionRepository = sectionRepository;
        this.moduleRepository = moduleRepository;
    }

    public void deleteSection(String sectionId,UUID courseId) {
        Optional<Section> section = sectionRepository.findBySectionMoodleIdAndCourseId(Integer.valueOf(sectionId),courseId);
        if (section.isEmpty()) {
            log.error("Section is not found with id: {}", sectionId);
            return;
        }
        sectionRepository.deleteBySectionMoodleIdAndCourseId(Integer.valueOf(sectionId),courseId);
        log.info("Section is deleted with id: {}", sectionId);
    }

    public void deleteSection(UUID sectionId) {
        Optional<Section> section = sectionRepository.findById(sectionId);
        if (section.isEmpty()) {
            log.error("Section is not found with id: {}", sectionId);
            return;
        }
        Section sectionFound = section.get();
        if (sectionFound.getSectionMoodleId() != null) {
            log.error("Section is not deleted because it is associated with moodle section id: {}", sectionFound.getSectionMoodleId());
            throw new CourseDomainException("Section is not deleted because it is associated with moodle section");
        }

        List<Module> modules = moduleRepository.findBySectionId(sectionId);
        if (modules.size() > 0) {
            log.error("Section is not deleted because it is associated with modules");
            throw new CourseDomainException("Section is not deleted because it is associated with modules");
        }

        sectionRepository.deleteById(sectionId);
        log.info("Section is deleted with id: {}", sectionId);
    }
}
