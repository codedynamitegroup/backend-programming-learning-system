package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SharedSolutionJpaRepository extends JpaRepository<SharedSolutionEntity, UUID> {
    List<SharedSolutionEntity> findByCodeQuestionId(UUID codeQuestionId);

    @Modifying
    @Query("""
            update SharedSolutionEntity sse
            set sse.viewNumber = sse.viewNumber + 1
            where sse.id = ?1
            """)
    void increaseOneViewById(UUID value);
}
