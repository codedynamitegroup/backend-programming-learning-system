package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.entity.CertificateCourseProgrammingLanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CertificateCourseProgrammingLanguageJpaRepository extends JpaRepository<CertificateCourseProgrammingLanguageEntity, UUID> {
    Optional<CertificateCourseProgrammingLanguageEntity> findById(UUID id);
}
