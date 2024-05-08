package com.backend.programming.learning.system.course.service.dataaccess.user.repository;

import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID>{
    Optional<UserEntity> findById(UUID id);
    Optional<UserEntity> findByEmailAndIsDeletedFalse(String email);

    Optional<UserEntity> findByUserIdMoodle(Integer userIdMoodle);
}
