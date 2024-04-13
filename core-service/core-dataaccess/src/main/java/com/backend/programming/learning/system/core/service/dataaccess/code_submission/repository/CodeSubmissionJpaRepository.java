package com.backend.programming.learning.system.core.service.dataaccess.code_submission.repository;

import com.backend.programming.learning.system.core.service.dataaccess.code_submission.entity.CodeSubmissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CodeSubmissionJpaRepository extends JpaRepository<CodeSubmissionEntity, UUID> {
    Optional<CodeSubmissionEntity> findById(UUID id);
}
