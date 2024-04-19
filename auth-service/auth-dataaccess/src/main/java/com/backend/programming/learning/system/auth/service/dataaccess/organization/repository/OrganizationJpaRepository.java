package com.backend.programming.learning.system.auth.service.dataaccess.organization.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.organization.entity.OrganizationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrganizationJpaRepository extends JpaRepository<OrganizationEntity, UUID> {
    Page<OrganizationEntity> findAllByIsDeletedFalse(Pageable pageable);
}
