package com.backend.programming.learning.system.course.service.dataaccess.section.repository;

import com.backend.programming.learning.system.course.service.dataaccess.section.entity.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SectionJpaRepository extends JpaRepository<SectionEntity, UUID>{
    Optional<SectionEntity> findById(UUID id);

    List<SectionEntity> findByCourseId(UUID courseId);

}
