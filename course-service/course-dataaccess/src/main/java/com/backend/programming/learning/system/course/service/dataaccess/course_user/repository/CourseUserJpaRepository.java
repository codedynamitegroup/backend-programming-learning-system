package com.backend.programming.learning.system.course.service.dataaccess.course_user.repository;

import com.backend.programming.learning.system.course.service.dataaccess.course_user.entity.CourseUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
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
}
