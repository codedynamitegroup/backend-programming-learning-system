package com.backend.programming.learning.system.course.service.dataaccess.user.repository;

import com.backend.programming.learning.system.course.service.dataaccess.user.entity.UserEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID>{
    Optional<UserEntity> findById(UUID id);
    Optional<UserEntity> findByEmailAndIsDeletedFalse(String email);

    Optional<UserEntity> findByUserIdMoodle(Integer userIdMoodle);

    Optional<UserEntity> findByIdAndIsDeletedFalse(UUID id);
    void deleteByUserIdMoodle(Integer userIdMoodle);

    @Query("SELECT u " +
            "FROM UserEntity u " +
            "JOIN CourseUserEntity cu ON u.id = cu.user.id " +
            "JOIN CourseEntity c ON cu.course.id = c.id " +
            "JOIN AssignmentEntity a ON c.id = a.course.id WHERE a.id = :assignmentId")
    List<UserEntity> findAllByAssignmentId(UUID assignmentId);

    @Query("""
            SELECT u
            FROM UserEntity u
            JOIN CourseUserEntity cu ON u.id = cu.user.id
            JOIN CourseEntity c ON cu.course.id = c.id
            WHERE c.id = :courseId
            AND (cast(:searchName as text) IS NULL or UPPER(u.email) like UPPER(concat('%', cast(:searchName as text), '%')))
           """)
    Page<UserEntity> findAllByCourseId(UUID courseId, String searchName, Pageable pageable);
}
