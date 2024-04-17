package com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.repository;

import com.backend.programming.learning.system.core.service.dataaccess.certificatecourse_user.entity.CertificateCourseUserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CertificateCourseUserJpaRepository extends PagingAndSortingRepository<CertificateCourseUserEntity, UUID> {
    Optional<CertificateCourseUserEntity> findById(UUID id);

    Page<CertificateCourseUserEntity> findAllByCertificateCourseId(
            UUID certificateCourseId, Pageable pageable);
}
