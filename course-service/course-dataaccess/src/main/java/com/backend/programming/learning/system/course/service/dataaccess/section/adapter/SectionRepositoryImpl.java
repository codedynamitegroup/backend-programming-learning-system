package com.backend.programming.learning.system.course.service.dataaccess.section.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.section.mapper.SectionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.section.repository.SectionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
import com.backend.programming.learning.system.course.service.domain.valueobject.CourseId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SectionRepositoryImpl implements SectionRepository {
    private final SectionJpaRepository sectionJpaRepository;
    private final SectionDataAccessMapper sectionDataAccessMapper;


    @Override
    public Section save(Section section) {
        return
            sectionDataAccessMapper.sectionEntityToSection(sectionJpaRepository
                .save(sectionDataAccessMapper
                    .sectionToSectionEntity(section)));
    }

    @Override
    public Section findById(UUID sectionId) {
        return
            sectionDataAccessMapper.sectionEntityToSection(sectionJpaRepository
                .findById(sectionId)
                .orElseThrow(() -> new RuntimeException("Section not found")));
    }

    @Override
    public Optional<Section> findBySectionMoodleId(Integer sectionMoodleId) {
        return
            sectionJpaRepository.findBySectionMoodleId(sectionMoodleId)
                .map(sectionDataAccessMapper::sectionEntityToSection);
    }


    @Override
    public List<Section> findByCourseId(CourseId courseId) {
        return
            sectionDataAccessMapper.sectionEntityListToSectionList(sectionJpaRepository.findByCourseId(courseId.getValue()));
    }

    @Override
    public void deleteById(UUID sectionId) {
        sectionJpaRepository.deleteById(sectionId);
    }

    @Override
    public void deleteBySectionMoodleId(Integer sectionMoodleId) {
        sectionJpaRepository.findBySectionMoodleId(sectionMoodleId)
            .ifPresent(sectionJpaRepository::delete);
    }
}
