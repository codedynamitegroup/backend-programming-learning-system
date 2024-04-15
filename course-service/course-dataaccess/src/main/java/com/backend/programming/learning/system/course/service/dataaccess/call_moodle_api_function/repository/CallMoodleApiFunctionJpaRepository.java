package com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.repository;

import com.backend.programming.learning.system.course.service.dataaccess.call_moodle_api_function.entity.CallMoodleApiFunctionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CallMoodleApiFunctionJpaRepository extends JpaRepository<CallMoodleApiFunctionEntity, UUID> {
    Optional<CallMoodleApiFunctionEntity> findById(UUID id);
}
