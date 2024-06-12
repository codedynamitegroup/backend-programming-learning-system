package com.backend.programming.learning.system.course.service.dataaccess.assignment.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssignmentJpaRepository extends JpaRepository<AssignmentEntity, UUID>
{
    Optional<AssignmentEntity> findById(UUID id);

    List<AssignmentEntity> findAllByCourseId(UUID courseId);

    Optional<AssignmentEntity> findByAssignmentIdMoodle(Integer assignmentIdMoodle);

    @Query("""
            SELECT a
            FROM AssignmentEntity a
            ORDER BY createdAt DESC
            LIMIT 5
            """)
    List<AssignmentEntity> findRecentAssignment();
}
