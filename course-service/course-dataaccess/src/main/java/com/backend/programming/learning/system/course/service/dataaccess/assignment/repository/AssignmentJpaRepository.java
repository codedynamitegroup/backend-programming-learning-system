package com.backend.programming.learning.system.course.service.dataaccess.assignment.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.ports.output.repository.AssignmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssignmentJpaRepository extends JpaRepository<AssignmentEntity, UUID>
{
    Optional<AssignmentEntity> findById(UUID id);

    List<AssignmentEntity> findAllByCourseId(UUID courseId);

    @Transactional
    @Modifying
    @Query("""
           update AssignmentEntity a
           set a.title = ?1,
           a.intro = ?2,
           a.score = ?3,
           a.maxScore = ?4,
           a.timeClose = ?5,
           a.timeLimit = ?6,
           a.type = ?7,
           a.visible = ?8
           where a.id = ?9""")
    int updateAssignmentById(String title,
                             String intro,
                             Float score,
                             Float maxScore,
                             ZonedDateTime timeClose,
                             ZonedDateTime timeLimit,
                             String type,
                             Boolean visible,
                             UUID id);
}
