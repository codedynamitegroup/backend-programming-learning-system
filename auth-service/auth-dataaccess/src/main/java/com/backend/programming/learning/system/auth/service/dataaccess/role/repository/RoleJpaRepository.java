package com.backend.programming.learning.system.auth.service.dataaccess.role.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.role.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface RoleJpaRepository extends JpaRepository<RoleEntity, UUID> {

}
