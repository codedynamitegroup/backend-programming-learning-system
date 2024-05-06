package com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.repository;

import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionTagEntity;
import com.backend.programming.learning.system.code.assessment.service.dataaccess.shared_solution.entity.SharedSolutionTagEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SharedSolutionTagJpaRepository extends JpaRepository<SharedSolutionTagEntity, SharedSolutionTagEntityId> {
    List<SharedSolutionTagEntity> findBySharedSolutionId(UUID id);

//    @Query("select count(*) form SharedSolutionTagEntity sste where sste.shared_solution_id = ?1 and sste.")
//    Integer countUpvoteById()
}
