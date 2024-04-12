package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_programminglanguage.entity.CertificateCourseProgrammingLanguageEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.entity.CertificateCourseTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CertificateCourseTopicJpaRepository extends JpaRepository<CertificateCourseTopicEntity, UUID> {
    Optional<CertificateCourseTopicEntity> findById(UUID id);
}
