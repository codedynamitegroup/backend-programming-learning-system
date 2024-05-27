package com.backend.programming.learning.system.course.service.dataaccess.submission_file.repository;

import com.backend.programming.learning.system.course.service.dataaccess.submission_file.entity.SubmissionFileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SubmissionFileJpaRepository extends JpaRepository<SubmissionFileEntity, UUID>{
    Optional<SubmissionFileEntity> findById(UUID id);

    List<SubmissionFileEntity> findAllBySubmissionAssignmentFileId(UUID submissionAssignmentId);

}
