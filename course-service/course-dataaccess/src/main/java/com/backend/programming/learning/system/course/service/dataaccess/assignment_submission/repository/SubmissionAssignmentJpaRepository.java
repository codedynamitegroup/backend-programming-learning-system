package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository

public interface SubmissionAssignmentJpaRepository extends JpaRepository<SubmissionAssignmentEntity, UUID> {
    Optional<SubmissionAssignmentEntity> findById(UUID id);
    @Query(
            "SELECT s FROM SubmissionAssignmentEntity s " +
                    "WHERE s.assignment.id = :assignmentId " +
                    "AND (UPPER(s.user.email) LIKE UPPER(concat('%', cast(:search as text), '%')) " +
                    "OR UPPER(s.user.firstName) LIKE UPPER(concat('%', cast(:search as text), '%')) " +
                    "OR UPPER(s.user.lastName) LIKE UPPER(concat('%', cast(:search as text), '%')))"+
                    "AND (:isGraded IS NULL OR s.isGraded = :isGraded)"
    )
    Page<SubmissionAssignmentEntity> findAllByAssignmentId(UUID assignmentId, String search, Boolean isGraded, Pageable pageable);

    Optional<SubmissionAssignmentEntity> findByAssignmentIdAndUserId(UUID assignmentId, UUID userId);

    @Query("SELECT COUNT(s) FROM SubmissionAssignmentEntity s " +
            "WHERE s.assignment.id = :assignmentId " +
            "AND s.isGraded = false")
    Integer countSubmissionsToGradeByAssignmentId(UUID assignmentId);


    @Query("SELECT COUNT(s) FROM SubmissionAssignmentEntity s " +
            "WHERE s.assignment.id = :assignmentId "+
            "AND s.submitTime IS NOT NULL")
    Integer countAllByAssignmentId(UUID assignmentId);


    List<SubmissionAssignmentEntity> findAllByAssignmentId(UUID assignmentId);

}
