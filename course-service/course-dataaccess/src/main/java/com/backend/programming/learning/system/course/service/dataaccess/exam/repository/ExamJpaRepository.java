package com.backend.programming.learning.system.course.service.dataaccess.exam.repository;

import com.backend.programming.learning.system.course.service.dataaccess.exam.entity.ExamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface ExamJpaRepository extends JpaRepository<ExamEntity, UUID> {
    Optional<ExamEntity> findById(UUID id);
}