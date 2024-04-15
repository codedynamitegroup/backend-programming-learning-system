package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_topic.entity.CertificateCourseTopicEntity;
import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CertificateCourseUserJpaRepository extends JpaRepository<CertificateCourseUserEntity, UUID> {
    Optional<CertificateCourseUserEntity> findById(UUID id);
}
