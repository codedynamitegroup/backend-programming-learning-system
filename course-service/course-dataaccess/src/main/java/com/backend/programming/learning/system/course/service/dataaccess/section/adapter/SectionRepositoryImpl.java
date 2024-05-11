package com.backend.programming.learning.system.course.service.dataaccess.section.adapter;

import com.backend.programming.learning.system.course.service.dataaccess.section.mapper.SectionDataAccessMapper;
import com.backend.programming.learning.system.course.service.dataaccess.section.repository.SectionJpaRepository;
import com.backend.programming.learning.system.course.service.domain.entity.Section;
import com.backend.programming.learning.system.course.service.domain.entity.User;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.SectionRepository;
import com.backend.programming.learning.system.course.service.domain.ports.output.repository.UserRepository;
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
    public List<Section> findByCourseId(UUID courseId) {
        return
            sectionDataAccessMapper.sectionEntityListToSectionList(sectionJpaRepository.findByCourseId(courseId));
    }

    @Override
    public void deleteById(UUID sectionId) {
        sectionJpaRepository.deleteById(sectionId);
    }
}
