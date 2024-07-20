package com.backend.programming.learning.system.course.service.dataaccess.section.repository;

import com.backend.programming.learning.system.course.service.dataaccess.section.entity.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SectionJpaRepository extends JpaRepository<SectionEntity, UUID>{
    Optional<SectionEntity> findById(UUID id);

    @Query("""
            SELECT s FROM SectionEntity s
            WHERE s.course.id = :courseId
            ORDER BY s.name ASC
            """)
    List<SectionEntity> findByCourseId(UUID courseId);

    Optional<SectionEntity> findBySectionMoodleIdAndCourseId(Integer sectionMoodleId,UUID courseId);

    void deleteBySectionMoodleId(Integer sectionMoodleId);
}
