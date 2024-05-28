package com.backend.programming.learning.system.auth.service.dataaccess.role.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleEntity, UUID> {
    Page<RoleEntity> findAll(Pageable pageable);
    Optional<RoleEntity> findByName(String name);
}
