package com.backend.programming.learning.system.course.service.dataaccess.intro_file.repository;

import com.backend.programming.learning.system.course.service.dataaccess.intro_file.entity.IntroFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IntroFileJpaRepository extends JpaRepository<IntroFileEntity, UUID>{
    Optional<IntroFileEntity> findById(UUID id);

    List<IntroFileEntity> findAllByAssignmentId(UUID assignmentId);

}
