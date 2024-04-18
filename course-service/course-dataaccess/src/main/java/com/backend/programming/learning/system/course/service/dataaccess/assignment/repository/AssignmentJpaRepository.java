package com.backend.programming.learning.system.course.service.dataaccess.assignment.repository;

import com.backend.programming.learning.system.course.service.dataaccess.assignment.entity.AssignmentEntity;
import com.backend.programming.learning.system.ports.output.repository.AssignmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AssignmentJpaRepository extends JpaRepository<AssignmentEntity, UUID>
{
    Optional<AssignmentEntity> findById(UUID id);

    List<AssignmentEntity> findAllByCourseId(UUID courseId);

}
