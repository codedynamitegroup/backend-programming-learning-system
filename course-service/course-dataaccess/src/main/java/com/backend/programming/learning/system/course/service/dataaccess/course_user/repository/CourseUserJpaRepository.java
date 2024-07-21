package com.backend.programming.learning.system.course.service.dataaccess.course_user.repository;

import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface CourseUserJpaRepository extends JpaRepository<CourseUserEntity, UUID> {
    List<CourseUserEntity> findByCourseId(UUID id);

    void deleteByCourseIdAndUserIdIn(UUID courseId, List<UUID> userIds);
    void deleteByCourseIdAndUserId(UUID courseId, UUID userIds);

    @Query("""
            SELECT cu
            FROM CourseUserEntity cu
            WHERE cu.course.id = :courseId
            AND (cu.roleMoodle.id = 3 OR cu.roleMoodle.id = 4) 
    """)
    List<CourseUserEntity> findByCourseIdAndRoleTeacher(UUID courseId);


    @Query("""
            SELECT cu
            FROM CourseUserEntity cu
            WHERE cu.course.id = :id
            AND (cu.user.firstName LIKE %:search% OR cu.user.lastName LIKE %:search% OR cu.user.email LIKE %:search%)
    """)
    Page<CourseUserEntity> findAllUserByCourseId(UUID id, String search, Pageable pageable);



    @Query("""
            SELECT COUNT(cu)
            FROM CourseUserEntity cu
            WHERE cu.course.id = :courseId
            AND cu.roleMoodle.id = 5
    """)
    Integer countStudentByCourseId(UUID courseId);

    @Query("""
        SELECT cu
        FROM CourseUserEntity cu
        WHERE cu.user.id = :userId
        AND (cu.course.name LIKE CONCAT('%', :search, '%'))
        AND (:courseType IS NULL OR cu.course.courseType.id IN :courseType)
    """)
    Page<CourseUserEntity> findAllCourseByUserId(UUID userId, String search, String[] courseType, Pageable pageable);

    @Query("""
    SELECT cu 
    FROM ExamEntity e
    JOIN CourseUserEntity cu ON cu.course = e.course
    WHERE e.id = :examId AND cu.user.roleMoodle.id = 5
    """)
    Page<CourseUserEntity> findByExamId(UUID examId, Pageable pageable);

    Optional<CourseUserEntity> findByCourseIdAndUserId(UUID courseId, UUID userId);

    @Query("""
    SELECT u
    FROM UserEntity u
    WHERE u.organization.id = :organizationId
    AND u.roleMoodle.id != 1
    AND (u.firstName LIKE %:search% OR u.lastName LIKE %:search% OR u.email LIKE %:search%)
    AND NOT EXISTS (
        SELECT cu
        FROM CourseUserEntity cu
        WHERE cu.user.id = u.id
        AND cu.course.id = :courseId
    )
                """)
    Page<UserEntity> findAllUsersAreAbleToAssign(UUID courseId, UUID organizationId, String search, Pageable pageable);


}
