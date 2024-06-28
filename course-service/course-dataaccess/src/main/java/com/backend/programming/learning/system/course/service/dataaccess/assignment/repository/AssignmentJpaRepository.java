package com.backend.programming.learning.system.course.service.dataaccess.assignment.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query("""
    SELECT a
    FROM AssignmentEntity a
    JOIN CourseEntity c ON a.course.id = c.id
    JOIN CourseUserEntity cu ON c.id = cu.course.id
    WHERE cu.user.id = :userId
    AND a.course.id = :courseId
    AND (cast(:searchName as text) IS NULL or UPPER(a.title) like UPPER(concat('%', cast(:searchName as text), '%')))
    """)
    Page<AssignmentEntity> findListGradeAssignmentByCourseId(UUID courseId, UUID userId, String searchName, Pageable pageable);


    @Query("""
    SELECT a
    FROM AssignmentEntity a
    JOIN CourseEntity c ON a.course.id = c.id
    AND a.course.id = :courseId
    """)
    List<AssignmentEntity> findAllGradeStudentAssignment(UUID courseId);

}
