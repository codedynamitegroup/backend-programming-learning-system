package com.backend.programming.learning.system.course.service.dataaccess.role_moodle.repository;

import com.backend.programming.learning.system.course.service.dataaccess.role_moodle.entity.RoleMoodleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleMoodleJpaRepository extends JpaRepository<RoleMoodleEntity, Integer>{
    Optional<RoleMoodleEntity> findById(Integer id);
    Optional<RoleMoodleEntity> findByName(String name);

    void delete(RoleMoodleEntity roleMoodleEntity);
}
