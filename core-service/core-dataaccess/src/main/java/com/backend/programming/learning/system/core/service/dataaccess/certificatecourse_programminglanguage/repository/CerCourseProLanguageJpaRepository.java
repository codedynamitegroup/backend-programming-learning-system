package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.entity.CerCourseProLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CerCourseProLanguageJpaRepository extends JpaRepository<CerCourseProLanguageEntity, UUID> {
    Optional<CerCourseProLanguageEntity> findById(UUID id);
}
