package com.backend.programming.learning.system.course.service.dataaccess.module.repository;

import com.backend.programming.learning.system.course.service.dataaccess.module.entity.ModuleEntity;
import com.backend.programming.learning.system.course.service.dataaccess.section.entity.SectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ModuleJpaRepository extends JpaRepository<ModuleEntity, UUID>{
    Optional<ModuleEntity> findById(UUID id);

    List<ModuleEntity> findBySectionId(UUID sectionId);

    Optional<ModuleEntity> findByCmid(Integer cmid);
}
