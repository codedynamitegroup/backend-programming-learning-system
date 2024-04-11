package com.backend.programming.learning.system.auth.service.dataaccess.user.repository;

import com.backend.programming.learning.system.auth.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
}
