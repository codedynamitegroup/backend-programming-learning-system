package com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.entity.SubmissionAssignmentEntity;
import com.backend.programming.learning.system.course.service.dataaccess.assignment_submission.projection.AllSubmissionAssignmentProjection;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import com.backend.programming.learning.system.course.service.domain.entity.User;
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

    @Query("""
    SELECT u.id as userId,
           MAX(sa.id) as submissionAssignmentId,
           CONCAT(u.firstName, ' ', u.lastName) as fullName,
           u.email as email,
           MAX(sa.submitTime) as submitTime,
           MAX(sa.timemodified) as timeModified,
           MAX(sa.content) as content,
           MAX(sa.feedback) as feedback,
           sa.isGraded as isGraded
    FROM UserEntity u
    JOIN CourseUserEntity cu ON cu.user.id = u.id AND cu.roleMoodle.id = 5
    JOIN CourseEntity c ON cu.course.id = c.id
    LEFT JOIN SubmissionAssignmentEntity sa ON sa.user.id = u.id AND sa.assignment.id = :assignmentId
    WHERE (UPPER(u.email) LIKE UPPER(CONCAT('%', :search, '%'))
           OR UPPER(u.firstName) LIKE UPPER(CONCAT('%', :search, '%'))
           OR UPPER(u.lastName) LIKE UPPER(CONCAT('%', :search, '%')))
      AND (:isGraded IS NULL OR sa.isGraded = :isGraded)
    GROUP BY u.id, u.firstName, u.lastName, u.email, sa.isGraded
""")
    Page<AllSubmissionAssignmentProjection> findAllSubmissionAssignment(
            UUID assignmentId,
            String search,
            Boolean isGraded,
            Pageable pageable
    );










}
