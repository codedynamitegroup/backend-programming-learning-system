package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SharedSolutionJpaRepository extends JpaRepository<SharedSolutionEntity, UUID> {
    List<SharedSolutionEntity> findByCodeQuestionId(UUID codeQuestionId);
}
