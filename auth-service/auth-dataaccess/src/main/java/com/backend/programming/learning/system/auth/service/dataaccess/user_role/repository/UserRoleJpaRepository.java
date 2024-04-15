package com.backend.programming.learning.system.auth.service.dataaccess.user_role.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.user_role.entity.UserRoleEntity;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRoleJpaRepository extends JpaRepository<UserRoleEntity, UUID> {
    Optional<UserRoleEntity> findByRoleIdAndUserId(UUID roleId, UUID userId);
    void deleteByRoleIdAndUserId(UUID roleId, UUID userID);
    void deleteByRoleId(UUID roleId);
}
