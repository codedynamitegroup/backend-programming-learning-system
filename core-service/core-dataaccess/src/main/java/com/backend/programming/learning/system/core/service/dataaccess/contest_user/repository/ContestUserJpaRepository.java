package com.backend.programming.learning.system.core.service.dataaccess.contest_user.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import com.backend.programming.learning.system.core.service.dataaccess.contest_user.entity.ContestUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ContestUserJpaRepository extends JpaRepository<ContestUserEntity, UUID> {
    Optional<ContestUserEntity> findById(UUID id);
}
