package com.backend.programming.learning.system.auth.service.dataaccess.user_role.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.user_role.entity.UserRoleEntity;
import com.backend.programming.learning.system.auth.service.domain.valueobject.RoleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRoleJpaRepository extends JpaRepository<UserRoleEntity, UUID> {
    Optional<UserRoleEntity> findByRoleIdAndUserId(UUID roleId, UUID userId);
    @Query(value = """
            select ur.*
            from user_role ur
            join role r on ur.role_id = r.id
            where ur.user_id = ?1 and r.name != 'user'
            """, nativeQuery = true)
    Optional<UserRoleEntity> findByUserIdAndRoleIsNotUser(UUID userId);
    void deleteByRoleIdAndUserId(UUID roleId, UUID userID);
    void deleteByRoleId(UUID roleId);
}
