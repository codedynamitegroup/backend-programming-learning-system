package com.backend.programming.learning.system.course.service.dataaccess.exam.repository;

import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface ExamJpaRepository extends JpaRepository<ExamEntity, UUID> {
    Optional<ExamEntity> findById(UUID id);

    @Query("""
            SELECT e
            FROM ExamEntity e
            WHERE e.course.id = :courseId
            AND (e.name LIKE %:search%)
            """)
    Page<ExamEntity> findAll(UUID courseId, String search, Pageable pageable);

    Optional<ExamEntity> findByName(String name);

    @Query("""
            SELECT COUNT(cu)
            FROM ExamEntity e
            JOIN CourseUserEntity cu ON e.course.id = cu.course.id AND cu.roleMoodle.id = 5
            WHERE e.id = :examId
            """)
    Integer countStudent(UUID examId);

    @Query("""
            SELECT e
            FROM ExamEntity e
            ORDER BY createdAt DESC
            LIMIT 5
            """)
    List<ExamEntity> findRecentExam();
}
