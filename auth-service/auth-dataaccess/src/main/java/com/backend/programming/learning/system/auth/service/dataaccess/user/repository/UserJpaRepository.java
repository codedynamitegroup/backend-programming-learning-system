package com.backend.programming.learning.system.auth.service.dataaccess.user.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmailAndIsDeletedFalse(String email);
    Optional<UserEntity> findByIdAndIsDeletedFalse(UUID id);
    Optional<UserEntity> findByIdAndIsDeletedTrue(UUID id);
    Page<UserEntity> findAllByIsDeletedFalse(Pageable pageable);
    Page<UserEntity> findAllByOrganizationId(UUID organizationId, Pageable pageable);
}
