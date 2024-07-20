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
    public Optional<Section> findById(UUID sectionId) {
        return sectionJpaRepository.findById(sectionId)
                .map(sectionDataAccessMapper::sectionEntityToSection);
    }

    @Override
    public Optional<Section> findBySectionMoodleIdAndCourseId(Integer sectionMoodleId, UUID courseId) {
        return
            sectionJpaRepository.findBySectionMoodleIdAndCourseId(sectionMoodleId,courseId)
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
    public void deleteBySectionMoodleIdAndCourseId(Integer sectionMoodleId, UUID courseId) {

        sectionJpaRepository.findBySectionMoodleIdAndCourseId(sectionMoodleId,courseId)
            .ifPresent(sectionJpaRepository::delete);
    }

}
