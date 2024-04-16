package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse.entity.CertificateCourseEntity;
import com.backend.programming.learning.system.core.service.dataaccess.organization.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CertificateCourseJpaRepository extends JpaRepository<CertificateCourseEntity, UUID> {
    Optional<CertificateCourseEntity> findById(UUID id);
    Optional<CertificateCourseEntity> findByName(String name);
}
