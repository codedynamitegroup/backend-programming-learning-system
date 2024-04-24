package com.backend.programming.learning.system.auth.service.dataaccess.organization.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrganizationJpaRepository extends JpaRepository<OrganizationEntity, UUID> {
    Page<OrganizationEntity> findAllByIsDeletedFalse(Pageable pageable);
    Optional<OrganizationEntity> findByIdAndIsDeletedFalse(UUID id);
}
